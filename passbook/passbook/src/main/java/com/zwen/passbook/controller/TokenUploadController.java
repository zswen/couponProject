package com.zwen.passbook.controller;



import com.zwen.passbook.constant.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <h1>PassTemplate Token Upload</h1>
 * 6-27
 */

@Slf4j
@Controller
public class TokenUploadController {

    /** redis client*/
    private final StringRedisTemplate redisTemplate;

    public TokenUploadController(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @GetMapping("/upload") // return html file for token upload
    public String upload() {
        return "upload";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() { // Spring Boot will search template based on return string
        return "uploadStatus";
    }

    @PostMapping("/token")
    public String tokenFileUpload(@RequestParam("merchantsId") String merchantsId,
                                  @RequestParam("passTemplateId") String passTemplateId,
                                  @RequestParam("file") MultipartFile file,
                                  RedirectAttributes redirectAttributes) { // upload token and write it to redis
        if (passTemplateId == null || file.isEmpty()) { // TODO: Check if this merchant has been validated and other validations
            redirectAttributes.addFlashAttribute("message",
                    "passTemplateId is null or file is empty");
            return "redirect:/uploadStatus";
        }
        try{
            File cur = new File(Constants.TOKEN_DIR + merchantsId); // map different merchants to different dir
            if (!cur.exists()) {
                log.info("Create File: {}", cur.mkdir());
            }
            Path path = Paths.get(Constants.TOKEN_DIR, merchantsId, passTemplateId);
            Files.write(path, file.getBytes());

            if (!writeTokenToRedis(path, passTemplateId)) { // One tokens means one available pass
                redirectAttributes.addFlashAttribute("message", "write token error");
            } else {
                redirectAttributes.addFlashAttribute("message",
                        "You successfully uploaded '" + file.getOriginalFilename() + "'");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "redirect:/uploadStatus";
    }

    /**
     * <h2>Write token to redis</h2>
     * @param path {@link Path}
     * @param key redis key
     * @return true/false
     */
    private boolean writeTokenToRedis(Path path, String key) { // path to token file
        Set<String> tokens;

        try (Stream<String> stream  = Files.lines(path)){ // Read token files line by line and save to set
            tokens = stream.collect(Collectors.toSet()); // One token per line
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }

        if (!CollectionUtils.isEmpty(tokens)) {
            redisTemplate.executePipelined((RedisCallback<Object>) connection -> { // Write token to redis
                for (String token : tokens) {
                    connection.sAdd(key.getBytes(), token.getBytes());
                }
                return null;
            });
            return true;
        }
        return false;
    }
}

package com.zwen.passbook;

import com.zwen.passbook.security.AuthCheckInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

@Slf4j
@SpringBootApplication
public class MerchantsApplication extends WebMvcConfigurerAdapter {

    @Resource // inject java bean
    private AuthCheckInterceptor authCheckInterceptor;

    public static void main(String[] args) {
        SpringApplication.run(MerchantsApplication.class, args);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authCheckInterceptor)
                .addPathPatterns("/merchants/**"); // check all http with /merchants
        super.addInterceptors(registry);

        log.info("A Interceptor is created");

    }

}

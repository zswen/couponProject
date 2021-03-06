package com.zwen.passbook.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import com.zwen.passbook.vo.Feedback;
import com.zwen.passbook.vo.GainPassTemplateRequest;
import com.zwen.passbook.vo.PassTemplate;

/**
 * <h1>RowKey generation utils </h1>
 * 6-11, 6-20
 *
 */
@Slf4j
public class RowKeyGenUtil {

    /**
     *  <h2>Generate a rowKey based on given passTemplate object</h2>
     *  @param passTemplate {@link PassTemplate}
     *  @return String RowKey
     * */
    public static String genPassTemplateRowKey(PassTemplate passTemplate) {

        String passInfo = String.valueOf(passTemplate.getId()) + "_" + passTemplate.getTitle();
        String rowKey = DigestUtils.md2Hex(passInfo); // data with similar rowkey will be stored in same node
        // md5 can help distribute data to cluster

        log.info("GenPassTemplateRowKey: {}, {}", passInfo, rowKey);

        return rowKey;
    }

    /**
     * <h2>Generate a rowKey based on provided pick up pass template request</h2>
     * Pass Rowkey = reversed(userId) + inverse(timestamp) + PassTemplate RowKey
     * Add passTemplate rowKey for data science purpose because we can see which user picked a specific pass(filter)
     * @param request {@link GainPassTemplateRequest}
     * @return
     */
    public static String genPassRowKey(GainPassTemplateRequest request) {
        return new StringBuilder(String.valueOf(request.getUserId())).reverse().toString()
                + (Long.MAX_VALUE - System.currentTimeMillis())
                + genPassTemplateRowKey(request.getPassTemplate());
    }

    /**
     * <h2>Generate a rowKey based on Feedback</h2>
     * @param feedback {@link Feedback}
     * @return String RowKey
     */
    public static String genFeedbackRowKey(Feedback feedback) { // Let feedback from same user stored as close as possible

        return new StringBuilder(String.valueOf(feedback.getUserId())).reverse().toString() +
                (Long.MAX_VALUE - System.currentTimeMillis());
    }

}

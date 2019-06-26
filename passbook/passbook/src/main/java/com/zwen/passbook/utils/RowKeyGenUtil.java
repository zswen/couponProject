package com.zwen.passbook.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import vo.Feedback;
import vo.PassTemplate;

/**
 * <h1>RowKey generation utils </h1>
 * 6-11
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
     * <h2>Generate a rowKey based on Feedback</h2>
     * @param feedback {@link Feedback}
     * @return String RowKey
     */
    public static String genFeedbackRowKey(Feedback feedback) { // Let feedback from same user stored as close as possible

        return new StringBuilder(String.valueOf(feedback.getUserId())).reverse().toString() +
                (Long.MAX_VALUE - System.currentTimeMillis());
    }

}

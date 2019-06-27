package com.zwen.passbook.service.impl;

import com.alibaba.fastjson.JSON;
import com.spring4all.spring.boot.starter.hbase.api.HbaseTemplate;
import com.zwen.passbook.constant.Constants;
import com.zwen.passbook.mapper.FeedbackRowMapper;
import com.zwen.passbook.service.IFeedbackService;
import com.zwen.passbook.utils.RowKeyGenUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.PrefixFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vo.Feedback;
import vo.Response;

import java.util.List;

/**
 * <h1>Implementation of Feedback services</h1>
 * 6-17
 */

@Slf4j
@Service
public class FeedbackServiceImpl implements IFeedbackService {

    private final HbaseTemplate hbaseTemplate;

    public FeedbackServiceImpl(HbaseTemplate hbaseTemplate) {
        this.hbaseTemplate = hbaseTemplate;
    }

    @Override
    public Response createFeedback(Feedback feedback) {
        if (!feedback.validate()) {
            log.error("Feedback Error: {}", JSON.toJSONString(feedback));
            return Response.failure("Feedback Error");
        }

        Put put = new Put(Bytes.toBytes(RowKeyGenUtil.genFeedbackRowKey(feedback)));

        put.addColumn(
                Bytes.toBytes(Constants.Feedback.FAMILY_I),
                Bytes.toBytes(Constants.Feedback.USER_ID),
                Bytes.toBytes(feedback.getUserId())
        );
        put.addColumn(
                Bytes.toBytes(Constants.Feedback.FAMILY_I),
                Bytes.toBytes(Constants.Feedback.TYPE),
                Bytes.toBytes(feedback.getType())
        );
        put.addColumn(
                Bytes.toBytes(Constants.Feedback.FAMILY_I),
                Bytes.toBytes(Constants.Feedback.TEMPLATE_ID),
                Bytes.toBytes(feedback.getTemplateId())
        );
        put.addColumn(
                Bytes.toBytes(Constants.Feedback.FAMILY_I),
                Bytes.toBytes(Constants.Feedback.COMMENT),
                Bytes.toBytes(feedback.getComment())
        );

        hbaseTemplate.saveOrUpdate(Constants.Feedback.TABLE_NAME, put);

        return Response.seccess();
    }

    @Override
    public Response getFeedback(Long userId) {

        byte[] reverseUserId = new StringBuilder(String.valueOf(userId)).reverse().toString().getBytes(); // get user id
        Scan scan = new Scan();
        scan.setFilter(new PrefixFilter(reverseUserId)); // scan tables and retrieve key with certain userId

        List<Feedback> feedbacks = hbaseTemplate.find(Constants.Feedback.TABLE_NAME, scan, new FeedbackRowMapper());
        // table name, filter, rowmapper(res to obj)
        return new Response(feedbacks);
    }
}

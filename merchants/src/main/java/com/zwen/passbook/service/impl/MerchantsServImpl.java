package com.zwen.passbook.service.impl;


import com.alibaba.fastjson.JSON;
import com.zwen.passbook.constant.Constants;
import com.zwen.passbook.constant.ErrorCode;
import com.zwen.passbook.dao.MerchantsDao;
import com.zwen.passbook.entity.Merchants;
import com.zwen.passbook.service.IMerchantsServ;
import com.zwen.passbook.vo.CreateMerchantsRequest;
import com.zwen.passbook.vo.CreateMerchantsResponse;
import com.zwen.passbook.vo.PassTemplate;
import com.zwen.passbook.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 5-9
 * Implementation of MerchantServ interface
 */

@Slf4j
@Service
public class MerchantsServImpl implements IMerchantsServ {

    /** Merchants database interface */
    private final MerchantsDao merchantsDao;

    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public MerchantsServImpl(MerchantsDao merchantsDao,
                             KafkaTemplate<String, String> kafkaTemplate) {

        this.merchantsDao = merchantsDao;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    @Transactional
    public Response createMerchants(CreateMerchantsRequest request) { // get a merhants creation request

        Response response = new Response();
        CreateMerchantsResponse merchantsResponse = new CreateMerchantsResponse();

        ErrorCode errorCode = request.validate(merchantsDao); // 1.Check fields in request 2.Use dao to check database
        if (errorCode != ErrorCode.SUCCESS) {
            merchantsResponse.setId(-1); // -1 means creation failed
            response.setErrorCode(errorCode.getCode());
            response.setErrorMsg(errorCode.getDesc());
        } else {
            merchantsResponse.setId(merchantsDao.save(request.toMerchants()).getId());
            // save method is used for saving entity we got from database for future use
        }

        response.setData(merchantsResponse);
        return response;
    }

    @Override
    public Response buildMerchantsInfoById(Integer id) {


        Response response = new Response();
        Merchants merchants = merchantsDao.findById(id);

        if (merchants == null) {
            response.setErrorCode(ErrorCode.MERCHANTS_NOT_EXIST.getCode());
            response.setErrorMsg(ErrorCode.MERCHANTS_NOT_EXIST.getDesc());
        }
        response.setData(merchants);

        return response;
    }

    @Override
    public Response dropPassTemplate(PassTemplate template) {

        Response response = new Response();
        ErrorCode errorCode = template.validate(merchantsDao);

        if (errorCode != ErrorCode.SUCCESS) {
            response.setErrorCode(errorCode.getCode());
            response.setErrorMsg(errorCode.getDesc());
        } else {
            String passTemplate = JSON.toJSONString(template);
            kafkaTemplate.send( // Just for simplify this problem
                    Constants.TEMPLATE_TOPIC,
                    Constants.TEMPLATE_TOPIC,
                    passTemplate
            );
            log.info("DropPassTemplates: {}", passTemplate);
        }
        return response;
    }
}

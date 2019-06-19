package com.zwen.passbook.service.impl;


import com.zwen.passbook.constant.ErrorCode;
import com.zwen.passbook.dao.MerchantsDao;
import com.zwen.passbook.service.IMerchantsServ;
import com.zwen.passbook.vo.CreateMerchantsRequest;
import com.zwen.passbook.vo.CreateMerchantsResponse;
import com.zwen.passbook.vo.PassTemplate;
import com.zwen.passbook.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    public MerchantsServImpl(MerchantsDao merchantsDao) {
        this.merchantsDao = merchantsDao;
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
        return null;
    }

    @Override
    public Response dropPassTemplate(PassTemplate template) {
        return null;
    }
}

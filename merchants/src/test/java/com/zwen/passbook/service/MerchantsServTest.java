package com.zwen.passbook.service;

import com.alibaba.fastjson.JSON;
import com.zwen.passbook.vo.CreateMerchantsRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * 5-9
 * <h1>Merchants Services Test </h1>
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MerchantsServTest {

    @Autowired
    private IMerchantsServ merchantsServ;

    /**
     * {"data":{"id":17},"errorMsg":""}
     */

    @Test
    @Transactional // This is a test case. Database will auto rollback
    public void testCreateMerchantsServ() {
        CreateMerchantsRequest request = new CreateMerchantsRequest();
        request.setName("zwen");
        request.setLogoUrl("www.zwen.com");
        request.setBusinessLicenseUrl("www.zwen.com");
        request.setPhone("2174171459");
        request.setAddress("SJ");
        System.out.println(JSON.toJSONString(merchantsServ.createMerchants(request)));
    }
}

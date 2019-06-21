package com.zwen.passbook.service;

import com.alibaba.fastjson.JSON;
import com.zwen.passbook.vo.CreateMerchantsRequest;
import com.zwen.passbook.vo.PassTemplate;
import org.apache.commons.lang.time.DateUtils;
import org.assertj.core.util.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 5-9
 * 5-10
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
    //@Transactional // This is a test case. Database will auto rollback
    public void testCreateMerchantsServ() {
        CreateMerchantsRequest request = new CreateMerchantsRequest();
        request.setName("xinglu");
        request.setLogoUrl("www.xinglu.com");
        request.setBusinessLicenseUrl("www.xinglu.com");
        request.setPhone("9198087167");
        request.setAddress("SJ");
        System.out.println(JSON.toJSONString(merchantsServ.createMerchants(request)));
    }

    /**
     * First comment @Transactional and run above case generate a merchant in database and then run this
     * {"data":{"address":"SJ","businessLicenseUrl":"www.zwen.com","id":19,"isAudit":false,
     * "logoUrl":"www.zwen.com","name":"zwen","phone":"2174171459"},"errorMsg":""}
     *
     */

    @Test
    @Transactional
    public void testBuildMerchantsInfoById() {
        System.out.println(JSON.toJSONString(merchantsServ.buildMerchantsInfoById(20)));
    }

    @Test
    public void testDropPassTemplate() {
        PassTemplate passTemplate = new PassTemplate();
        passTemplate.setId(20);
        passTemplate.setTitle("title: xinglu");
        passTemplate.setSummary("summary: xinglu");
        passTemplate.setDesc("details: xinglu");
        passTemplate.setLimit(10000L);
        passTemplate.setHasToken(false);
        passTemplate.setBackground(2);
        passTemplate.setStart(new Date());
        passTemplate.setEnd(DateUtils.addDays(new Date(), 10));

        System.out.println(JSON.toJSONString(merchantsServ.dropPassTemplate(passTemplate)));

    }
}

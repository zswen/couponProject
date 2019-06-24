package com.zwen.passbook.service;

import com.zwen.passbook.vo.CreateMerchantsRequest;
import com.zwen.passbook.vo.PassTemplate;
import com.zwen.passbook.vo.Response;

/**
 * 5-8
 * interface services facing merchants
 */

public interface IMerchantsServ {

    /**
     * <h2>Merchants creation service</h2>
     *
     * @param request {@link CreateMerchantsRequest} Merchants creation request
     * @return {@link Response}
     */
    Response createMerchants(CreateMerchantsRequest request);

    /**
     * <h2>build merchants's info by Id.</h2>
     *
     * @param id Merchants id
     * @return {@link Response}
     */
    Response buildMerchantsInfoById(Integer id);


    /**
     * <h2>publish coupons</h2>
     *
     * @param template {@link PassTemplate} Coupon object
     * @return {@link Response}
     */
    Response dropPassTemplate(PassTemplate template);
}

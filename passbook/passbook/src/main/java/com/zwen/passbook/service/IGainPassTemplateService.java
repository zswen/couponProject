package com.zwen.passbook.service;

import com.zwen.passbook.vo.GainPassTemplateRequest;
import com.zwen.passbook.vo.Response;

/**
 * <h1>User pick up passtemplate</h1>
 */
public interface IGainPassTemplateService {

    /**
     * <2h>User pick up pass template</2h>
     * @param request {@link GainPassTemplateRequest}
     * @return {@link Response}
     * @throws Exception
     */
    Response gainPassTemplate(GainPassTemplateRequest request) throws Exception;
}

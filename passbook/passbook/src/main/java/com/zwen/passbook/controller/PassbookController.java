package com.zwen.passbook.controller;

import com.zwen.passbook.service.IFeedbackService;
import com.zwen.passbook.service.IGainPassTemplateService;
import com.zwen.passbook.service.IInventoryService;
import com.zwen.passbook.service.IUserPassService;
import com.zwen.passbook.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <h1>Passbook Rest Controller</h1>
 */

@Slf4j
@RestController
@RequestMapping("/passbook")
public class PassbookController {

    /** User Pass service */
    private final IUserPassService userPassService;

    /** Pass Inventory service */
    private final IInventoryService inventoryService;


    @Autowired
    /** Pass Template pick up service */
    private final IGainPassTemplateService gainPassTemplateService;

    /** Feedback Service */
    @Autowired
    private final IFeedbackService feedbackService;

    /** Request from client */
    private final HttpServletRequest httpServletRequest;

    @Autowired
    public PassbookController(IUserPassService userPassService,
                              IInventoryService inventoryService,
                              IGainPassTemplateService gainPassTemplateService,
                              IFeedbackService feedbackService,
                              HttpServletRequest httpServletRequest) {
        this.userPassService = userPassService;
        this.inventoryService = inventoryService;
        this.gainPassTemplateService = gainPassTemplateService;
        this.feedbackService = feedbackService;
        this.httpServletRequest = httpServletRequest;
    }

    Response userPassInfo(Long userId) throws Exception {
        Log
    }
}

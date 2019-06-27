package com.zwen.passbook.service;

import com.zwen.passbook.vo.Response;

/**
 * <h1>Retrieve Inventory. Only includes passes that a user has not picked up.</h1>
 * 6-19
 */
public interface IInventoryService {

    /**
     * <h2>Retrieve Inventory</h2>
     * @param userId
     * @return {@link Response}
     * @throws Exception
     */
    Response getInventoryInfo(Long userId) throws Exception;
}

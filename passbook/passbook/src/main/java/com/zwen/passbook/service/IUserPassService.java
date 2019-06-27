package com.zwen.passbook.service;

import vo.Pass;
import vo.Response;

/**
 * <h1>Retrieve pass info of a user</h1>
 * 6-19
 */
public interface IUserPassService {

    /**
     * <h2>Retrieve pass info of a user. "My Available Passes" feature </h2>
     * @param userId
     * @return {@link Response}
     * @throws Exception
     */
    Response getUserPassInfo(Long userId) throws Exception;


    /**
     * <h2>Retrieve used passes of a user</h2>
     * @param userId
     * @return {@link Response}
     * @throws Exception
     */
    Response getUserUserdPassInfo(Long userId) throws Exception;

    /**
     * <h2>Return all passes (available + used/expired)</h2>
     * @param userId
     * @return {@link Response}
     * @throws Exception
     */
    Response getUserAllPassInfo(Long userId) throws Exception;

    /**
     * <h2>User use pass</h2>
     * @param pass
     * @return {@link Response}
     */
    Response userUsePass(Pass pass);

}

package com.zwen.passbook.service;

import vo.Response;
import vo.User;

/**
 * <h1>User service. Create User </h1>
 * 6-15
 */
public interface IUserService {

    /**
     * <h2>Create User</h2>
     * @param user {@link User}
     * @return {@link Response}
     * @throws Exception
     */
    Response createUser(User user) throws Exception;
}

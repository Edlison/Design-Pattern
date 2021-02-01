package com.edlison.design.spring.ioc.service;

import com.edlison.design.spring.ioc.dao.UserDAO;

/**
 * UserService
 *
 * @Author Edlison
 * @Date 2/1/21 09:20
 */
public class UserService {
    private UserDAO userDAO;
    private String userServiceLog;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public String getUserServiceLog() {
        return userServiceLog;
    }

    public void setUserServiceLog(String userServiceLog) {
        this.userServiceLog = userServiceLog;
    }

    @Override
    public String toString() {
        return "UserService{" +
                "userDAO=" + userDAO +
                ", userServiceLog='" + userServiceLog + '\'' +
                '}';
    }
}

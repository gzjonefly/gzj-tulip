package com.dbdemo.service;

import com.dbdemo.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author guozijian
 * @date 2016/9/23 20:28
 */
public class UserService {
    @Autowired
    private UserDAO userDAO;


}

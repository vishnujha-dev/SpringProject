package com.project.security.service;

import com.project.security.model.UserInfo;
import com.project.security.repository.UserDetailDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailService {

    @Autowired
    UserDetailDao userDetailDao;

    private static final Logger logger= LoggerFactory.getLogger(UserDetailServiceImpl.class);
    @Override
    public List<UserInfo> getResisterUser() {
       return this.userDetailDao.getUsers();
    }

    @Override
    public UserInfo getUserUserNameOrID(String data) {
       return this.userDetailDao.getUserByUserNameOrID(data);
    }
}

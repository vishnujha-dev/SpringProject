package com.project.security.service;

import com.project.security.model.UserInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserDetailService {

    public List<UserInfo> getResisterUser();
    public UserInfo getUserUserNameOrID(String data);
}

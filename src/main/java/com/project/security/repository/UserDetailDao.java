package com.project.security.repository;

import com.project.security.model.UserInfo;
import com.project.security.springsecurityConfig.UserSecurityConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDetailDao {

    @Autowired
    UserSecurityConfig userSecurityConfig;
    List<UserInfo> userInfoList;

    private static final Logger logger= LoggerFactory.getLogger(UserDetailDao.class);


    public List<UserInfo> getUsers() {
        userInfoList =new ArrayList<>();
        userInfoList.add(new UserInfo.UserInfoBuilder().setUserId("0001").setUserName("rahul")
                .setFullName("rahul jha").setMobileNo(8920341597l)
                .setPassword(userSecurityConfig.passwordEncoder().encode("rahul")).build());
        userInfoList.add(new UserInfo.UserInfoBuilder().setUserId("0002").setUserName("ram")
                .setFullName("ram jha").setMobileNo(8920341597l)
                .setPassword(userSecurityConfig.passwordEncoder().encode("ram")).build());
        userInfoList.add(new UserInfo.UserInfoBuilder().setUserId("0003").setUserName("Shweta")
                .setFullName("Shweta jha").setMobileNo(8920341597l)
                .setPassword(userSecurityConfig.passwordEncoder().encode("Shweta")).build());
        return userInfoList;
    }

    public UserInfo getUserByUserNameOrID(String data) {
        UserInfo optional= this.getUsers().stream().filter(userInfo -> userInfo.getUserId().equalsIgnoreCase(data)).findAny().orElse(null);

        if(optional ==null){
            return this.getUsers().stream().filter(userInfo -> userInfo.getUserName().equalsIgnoreCase(data)).findAny().orElse(null);
        }

        return optional;
    }
}

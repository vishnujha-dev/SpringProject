package com.project.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;


public class UserInfo {
    private final String userId;
    private final String userName;
    private final String password;
    private final String fullName;
    private final Long mobileNo;

    private UserInfo(UserInfoBuilder builder) {
        this.userId = builder.userId;
        this.userName = builder.userName;
        this.password = builder.password;
        this.fullName = builder.fullName;
        this.mobileNo = builder.mobileNo;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public Long getMobileNo() {
        return mobileNo;
    }


    public static class UserInfoBuilder{

        private  String userId;
        private  String userName;
        private  String password;
        private  String fullName;
        private  Long mobileNo;

        public UserInfoBuilder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public UserInfoBuilder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public UserInfoBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserInfoBuilder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public UserInfoBuilder setMobileNo(Long mobileNo) {
            this.mobileNo = mobileNo;
            return this;
        }

        public UserInfo build(){
            return new UserInfo(this);
        }

    }
}

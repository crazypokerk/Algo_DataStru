package com.exe.wenda.service;

import com.exe.wenda.dao.UserInfoDAO;
import com.exe.wenda.model.User_Info;
import org.springframework.beans.factory.annotation.Autowired;


public class UserInfoService {
  @Autowired
  UserInfoDAO userInfoDAO;

  public User_Info setUserInfo(User_Info userInfo) {
    return userInfoDAO.setUserInfo(userInfo);
  }

}

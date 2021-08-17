package com.example.module_user;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.export_user.IUserService;
import com.example.export_user.UserInfo;
import com.example.export_user.UserRouterInfo;

@Route(path = UserRouterInfo.PATH_SERVICE_USER)
public class UserInfoServiceImpl implements IUserService {

    @Override
    public UserInfo getUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setName("test");
        userInfo.setPwd("123456");
        return userInfo;
    }

    @Override
    public void init(Context context) {
        // 初始化工作，服务注入时会调用，可忽略
    }
}

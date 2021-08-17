package com.example.export_user;


import android.content.Context;

import com.alibaba.android.arouter.facade.template.IProvider;

// 必须继承IProvider，为了使用ARouter的实现注入
public interface IUserService extends IProvider {

    UserInfo getUserInfo();
}

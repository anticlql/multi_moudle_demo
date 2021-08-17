package com.example.export_user;

import com.alibaba.android.arouter.launcher.ARouter;

public class UserServiceUtil {

    // 跳转到用户信息页面
    public static void navigateUserPage(String param) {
        ARouter.getInstance().build(UserRouterInfo.PATH_PAGE_USER)
                .withString("param1", param)
                .navigation();
    }

    // 获取用户服务
    public static IUserService getUserService() {
        // 通过 ARouter 获得用户服务实例
        return (IUserService) ARouter.getInstance().build(UserRouterInfo.PATH_SERVICE_USER).navigation();
    }

    public static UserInfo getUserInfo() {
        return getUserService().getUserInfo();
    }
}

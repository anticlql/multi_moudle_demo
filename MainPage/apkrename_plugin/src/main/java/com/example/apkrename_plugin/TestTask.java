package com.example.apkrename_plugin;

import org.gradle.api.Action;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;
import org.gradle.process.ExecSpec;

import java.io.File;
import java.io.IOException;

import javax.inject.Inject;

public class TestTask extends DefaultTask {

    File file;
    User user;

    @Inject
    public TestTask(File apk, User user) {
        this.file = apk;
        this.user = user;
        setGroup("apkrename");
    }

    // 双击使用插件的模块中的task中的注册的插件的名字
    // 执行此有@TaskAction注解的方法
    @TaskAction
    public void test() {
        System.out.println(file.getAbsoluteFile());
        System.out.println(user);
        // java代码中运行命令行
        /*try {
            Runtime.getRuntime().exec("javac");
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        // gradle封装运行命令行
        /*getProject().exec(new Action<ExecSpec>() {
            @Override
            public void execute(ExecSpec execSpec) {
                // 多个参数运行命令
                //execSpec.commandLine("java", "-jar", user.name, "XXX");
            }
        });*/
    }
}

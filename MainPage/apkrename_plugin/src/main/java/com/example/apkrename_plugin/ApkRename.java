package com.example.apkrename_plugin;

import com.android.build.gradle.AppExtension;
import com.android.build.gradle.api.ApplicationVariant;
import com.android.build.gradle.api.BaseVariantOutput;
import com.android.tools.r8.utils.F;

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;
import org.gradle.api.plugins.ApplicationPlugin;
import org.gradle.internal.impldep.org.apache.maven.model.Extension;
import org.gradle.platform.base.Application;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ApkRename implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        String projectName = project.getName();
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = fmt.format(new Date());
        //Extension appExtension = project.getExtensions().getByType();
        //Application app = (Application) project.getExtensions().getByType(ApplicationPlugin.class);

        // 按照javaBean中的参数进行扩展
        final User user = project.getExtensions().create("user", User.class);

        // 马上创建马上获取是不可以的
        // 程序运行之前先运行build gradle文件，分析完成之后再运行程序
        // gradle 分析完之后进行回调
        project.afterEvaluate(new Action<Project>() {
            @Override
            public void execute(Project project) {
                String name = user.getName();
                String password = user.getPassword();
                System.out.println(name+"\t"+password);
                // 获取android插件
                // 动态的获取生成的apk的文件
                AppExtension extension = project.getExtensions().getByType(AppExtension.class);
                //Object android = project.getExtensions().getByName("android");

                // 打包变种 通过all 遍历
                extension.getApplicationVariants().all(new Action<ApplicationVariant>() {
                    @Override
                    public void execute(ApplicationVariant applicationVariant) {
                        String name1 = applicationVariant.getName();
                        System.out.println(name1);      // debug/release

                        applicationVariant.getOutputs().all(new Action<BaseVariantOutput>() {
                            @Override
                            public void execute(BaseVariantOutput baseVariantOutput) {
                                File outputFile = baseVariantOutput.getOutputFile();
                                // 修改输出文件名
                                /*if (outputFile.getName().endsWith(".apk")) {
                                    String newFilePath = outputFile.getParent()+"\\"+name1+".apk";
                                    System.out.println(newFilePath);
                                    File newFile = new File(newFilePath);
                                    System.out.println(newFile.exists());
                                    boolean b = outputFile.renameTo(newFile);
                                    System.out.println(b);
                                    System.out.println("new address:"+outputFile.getAbsolutePath());
                                }*/
                                // 第三个参数以后是传给任务的参数
                                // 把文件和扩展的信息传给task
                                // 使用反射创建task对象
                                project.getTasks().create("apkrename"+baseVariantOutput.getName(), TestTask.class ,
                                        outputFile, user);
                            }
                        });
                    }
                });
            }
        });
    }
}
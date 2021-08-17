package com.example.hello_library;

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;
import org.gradle.api.tasks.TaskProvider;

public class HelloPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {

        project.getTasks().register("greeting", GoodbyeTask.class);

        // 添加扩展信息
        project.getExtensions().add("company", Company.class);
    }
}

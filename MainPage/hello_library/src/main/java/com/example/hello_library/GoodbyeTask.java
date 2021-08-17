package com.example.hello_library;

import org.gradle.api.Action;
import org.gradle.api.DefaultTask;
import org.gradle.api.Task;
import org.gradle.api.tasks.TaskAction;

public class GoodbyeTask extends DefaultTask {

    @TaskAction
    public void goodbye() {
        System.out.println("bye-bye");
    }

    @TaskAction
    public void sayhi() {
        System.out.println("hi");
    }

    @Override
    public Task doFirst(Action<? super Task> action) {
        return super.doFirst(action);
    }

    @Override
    public Task doLast(Action<? super Task> action) {
        System.out.println("doLast");
        return super.doLast(action);
    }
}

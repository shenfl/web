package com.test.activiti;

import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.activiti.api.task.model.Task;
import org.activiti.api.task.model.builders.TaskPayloadBuilder;
import org.activiti.api.task.runtime.TaskRuntime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author shenfl
 */
@SpringBootTest
public class TestTaskRuntime {
    @Autowired
    private SecurityUtil securityUtil;

    @Autowired
    private TaskRuntime taskRuntime;

    //获取当前登录用户任务
    @Test
    public void getTasks() {
        securityUtil.logInAs("bb");

        Page<Task> tasks = taskRuntime.tasks(Pageable.of(0,100));
        List<Task> list=tasks.getContent();
        for(Task tk : list){
            System.out.println("-------------------");
            System.out.println("getId："+ tk.getId());
            System.out.println("getName："+ tk.getName());
            System.out.println("getStatus："+ tk.getStatus());
            System.out.println("getCreatedDate："+ tk.getCreatedDate());
            if(tk.getAssignee() == null){
                //候选人为当前登录用户，null的时候需要前端拾取
                System.out.println("Assignee：待拾取任务");
            }else{
                System.out.println("Assignee："+ tk.getAssignee());
            }

        }

    }

    //完成任务
    @Test
    public void completeTask() {
        securityUtil.logInAs("wukong");
        Task task = taskRuntime.task("db9c5f80-d3ae-11ea-99e8-dcfb4875e032");
        if(task.getAssignee() == null){
            taskRuntime.claim(TaskPayloadBuilder.claim()
                    .withTaskId(task.getId())
                    .build());
        }
        taskRuntime.complete(TaskPayloadBuilder
                .complete()
                .withTaskId(task.getId())
                .build());
        System.out.println("任务执行完成");
    }

}

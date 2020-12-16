package com.test.activiti;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shenfl
 */
@SpringBootTest
public class TestTaskService {

    @Autowired
    private TaskService taskService;

    @Test
    public void testList() {
        List<Task> tasks = taskService.createTaskQuery().taskAssignee("3").list();
        for (Task task : tasks) {
            System.out.println(task.getId());
            System.out.println(task.getName());
            System.out.println(task.getAssignee());
            System.out.println(task.getProcessInstanceId());
        }
    }

    @Test
    public void testComplete() {
//        Map<String, Object> variables = new HashMap<>();
//        variables.put("money", 20000);
//        taskService.complete("df50f415-3f75-11eb-a973-fe6f930cea5d", variables);

        taskService.addComment("df50f415-3f75-11eb-a973-fe6f930cea5d", "ae861b8d-3f75-11eb-bff4-fe6f930cea5d", "full message");
        List<Comment> taskComments = taskService.getTaskComments("df50f415-3f75-11eb-a973-fe6f930cea5d");
        for (Comment taskComment : taskComments) {
            System.out.println(taskComment.getFullMessage());
        }

//        taskService.complete("70895591-39e3-11eb-b109-fe6f930cea5d");
        System.out.println("ok");
    }

}

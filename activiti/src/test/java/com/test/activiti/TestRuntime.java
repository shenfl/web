package com.test.activiti;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author shenfl
 */
@SpringBootTest
public class TestRuntime {
    @Autowired
    private RuntimeService runtimeService;

    @Test
    public void testStart() {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess_exclusive");
        System.out.println("实例ID：" + processInstance.getProcessDefinitionId());
    }

    @Test
    public void testList() {
        List<ProcessInstance> list = runtimeService.createProcessInstanceQuery().list();
        for (ProcessInstance processInstance : list) {
            System.out.println("ProcessInstanceId: " + processInstance.getProcessInstanceId());
            System.out.println(processInstance.getProcessDefinitionId());
            System.out.println("isEnded: " + processInstance.isEnded());
            System.out.println("isSuspended: " + processInstance.isSuspended());
        }
    }

}

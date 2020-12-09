package com.test.activiti;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author shenfl
 */
@SpringBootTest
public class TestDeployment {

    @Autowired
    private RepositoryService repositoryService;

    @Test
    public void testDeployment() {
        Deployment deployment = repositoryService.createDeployment().addClasspathResource("bpmn/myprocess_1.bpmn")
                .name("排他网管测试").deploy();
        System.out.println(deployment.getName());
    }

}

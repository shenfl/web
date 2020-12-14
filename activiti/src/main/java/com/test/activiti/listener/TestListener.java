package com.test.activiti.listener;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.stereotype.Component;

/**
 * @author shenfl
 */
@Component("testListener")
public class TestListener implements TaskListener {
    @Override
    public void notify(DelegateTask delegateTask) {
        System.out.println(delegateTask.getAssignee() + ":" + delegateTask.getName() + ":" + delegateTask.getExecutionId() + ":" + delegateTask.getEventName());
    }
}

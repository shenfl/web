package com.test.springboot.actuator;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

/**
 * @author shenfl
 * https://ricstudio.top/archives/spring_boot_actuator_learn
 * 需要配置:management.endpoint.health.show-details=always
 * 访问:http://localhost:9080/actuator/health
 */
@Component
public class MyHealthIndicator extends AbstractHealthIndicator {

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        // 使用 builder 来创建健康状态信息
        // 如果你throw 了一个 exception，那么status 就会被置为DOWN，异常信息会被记录下来
        builder.up()
                .withDetail("app", "这个项目很健康")
                .withDetail("error", "Nothing, I'm very good");
    }
}

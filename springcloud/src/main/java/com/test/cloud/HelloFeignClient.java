package com.test.cloud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author shenfl
 */
// 访问普通接口，需要url，不然报错
@FeignClient(url = "localhost:8080", value = "hello")
public interface HelloFeignClient {
    @GetMapping("/restGet")
    Boolean restGet();
}

package com.test.cloud;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shenfl
 */
@Api("测试接口")
@RestController
public class HelloController {

    @Autowired
    public HelloFeignClient helloFeignClient;

    @RequestMapping(value = "/testFeign", method = RequestMethod.GET)
    public String test() {
        System.out.println("aa");
        System.out.println(helloFeignClient.restGet());
        return "success";
    }
}

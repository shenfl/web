package com.test.cloud;

import com.test.cloud.model.Request;
import com.test.cloud.model.Status;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

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

    @GetMapping("/validate")
    // 这种处理异常太麻烦
//    public String testValidatete(@Valid Request request, BindingResult result) {
    public String testValidate(@Valid Request request) {
        // 不能加@RequestParam，加了后request就被当成一个参数了
        // 这儿也必须加个@Valid，不然request里面的内容不做校验
//        if (result.hasErrors()) {
//            for (FieldError fieldError : result.getFieldErrors()) {
//                System.out.println(fieldError);
//            }
//            return "failed";
//        }
        System.out.println(request);
        return "ok";
    }
}

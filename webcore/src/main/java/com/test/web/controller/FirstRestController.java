package com.test.web.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Created by shenfl on 2018/6/28
 */
@RestController
public class FirstRestController {

    @RequestMapping(value = "/rest", method = RequestMethod.POST)
    public Boolean first(@RequestBody Map<String, Object> a) { // 加入jackson依赖后可以支持map和java bean
        System.out.println(a);

        // org.springframework.http.converter.HttpMessageNotWritableException: No converter found for return value of type: class java.lang.Boolean
        // 默认没有boolean converter，加入jackson依赖后就好了
//        return true;

        return true;
    }

    @RequestMapping(value = "/import", method = RequestMethod.POST)
    public Boolean importFile(@RequestParam("file") MultipartFile file) {
        System.out.println(file.getOriginalFilename());
        return true;
    }
}

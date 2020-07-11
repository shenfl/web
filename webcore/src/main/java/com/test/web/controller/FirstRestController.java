package com.test.web.controller;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
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

    @RequestMapping(value = "/restGet", method = RequestMethod.GET)
    public Boolean restGet() {
        return true;
    }

    /**
     * https://baijiahao.baidu.com/s?id=1654419465068708673&wfr=spider&for=pc
     * @param file
     * @return
     */
    @RequestMapping(value = "/import", method = RequestMethod.POST)
    public Boolean importFile(@RequestParam("file") MultipartFile file) {
        System.out.println(file.getOriginalFilename());
        return true;
    }

    /**
     * https://msd.misuland.com/pd/3629905938225299562
     * @param params
     * @param request
     * @return
     */
    @PostMapping(value = "/download")
    public ResponseEntity<Resource> downloadFile(@RequestBody Map<String, Object> params, HttpServletRequest request) throws IOException {
        System.out.println("Params: " + params);
        File file = new File("/springmvc.xml");
        Resource resource = new FileSystemResource(file);
        return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/octet-stream")) // application/vnd.ms-excel下载excel
                .contentLength(resource.contentLength())
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}

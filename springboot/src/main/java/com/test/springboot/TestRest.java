package com.test.springboot;

import org.springframework.web.client.RestTemplate;

/**
 * https://cloud.tencent.com/developer/article/1554561
 * @author shenfl
 */
public class TestRest {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject("http://ng-searcher.dasouche-inc.net/usage/getUsage", String.class);
        System.out.println(forObject);
    }
}

package com.test.springboot.controller;

import com.test.springboot.actuator.PrometheusCustomMonitor;
import com.test.springboot.util.RateLimitClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Random;

/**
 * @author shenfl
 * https://blog.csdn.net/coqcnbkggnscf062/article/details/104818805
 */
@RestController
public class TestController {

    @Resource
    private PrometheusCustomMonitor monitor;

    @Autowired
    private RateLimitClient rateLimitClient;

    @Autowired
    StringRedisTemplate redisTemplate;

    //....

    @RequestMapping("/order")
    public String order(@RequestParam(defaultValue = "0") String flag) throws Exception {
        // 统计下单次数
        monitor.getOrderCount().increment();
        if ("1".equals(flag)) {
            throw new Exception("出错啦");
        }
        Random random = new Random();
        int amount = random.nextInt(100);
        // 统计金额
        monitor.getAmountSum().record(amount);
        return "下单成功, 金额: " + amount;
    }

    @GetMapping("/rate/{id}")
    public String rateLimiter(@PathVariable String id) {
        //渠道111、机构222、服务333  key=111222333 ，100，100，10.0
        //渠道222、机构333、服务444  key=111222333， 200，200，5.0

        //调用的服务

        //服务A配置  在这里只是为了打印控制台令牌桶的数量，可能打印的结果和实际不匹配，因为在此行代码和获取令牌桶操作之间会有其他线程进来
        Map bucketConfigMap = redisTemplate.opsForHash().entries("rateLimter:" + id);

        //令牌桶日志信息
        String msg = "当前程序：" + bucketConfigMap.get("app")
                + ",消费后令牌:" + bucketConfigMap.get("stored_permits")
                + ",最多令牌：" + bucketConfigMap.get("max_permits")
                + ",每秒放入令牌桶数量：" + bucketConfigMap.get("oneSecondNum");

        //获取令牌 执行结果为false则没有获取到令牌
        if (!rateLimitClient.execute(id)){
            System.err.println("请求失败," + msg );
            return "null";
        }

        System.out.println("请求成功," + msg);

        return "m1被调用完成";
    }
}
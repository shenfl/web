package com.test.springboot.util;

/**
 * @author shenfl
 */
public class RateLimitVo {
    /** 每秒放入令牌数量 */
    private Integer oneSecondNum;

    /** 令牌桶最大容量 */
    private Integer maxPermits;

    /** 令牌桶初始化容量 */
    private Integer initialPermits;

    public Integer getOneSecondNum() {
        return oneSecondNum;
    }

    public void setOneSecondNum(Integer oneSecondNum) {
        this.oneSecondNum = oneSecondNum;
    }

    public Integer getMaxPermits() {
        return maxPermits;
    }

    public void setMaxPermits(Integer maxPermits) {
        this.maxPermits = maxPermits;
    }

    public Integer getInitialPermits() {
        return initialPermits;
    }

    public void setInitialPermits(Integer initialPermits) {
        this.initialPermits = initialPermits;
    }
}

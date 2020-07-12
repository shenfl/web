package com.test.cloud.model;/**
 * @author shenfl
 */

/**
 * @author shenfl
 */
public enum Status {
    SUCCESS("success"), FAILED("failed");
    private String name;
    Status(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

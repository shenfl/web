package com.test.cloud.model;

import com.test.cloud.validate.StatusValidation;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author shenfl
 */
public class Request {
    @ApiModelProperty("主键值")
    @NotNull
    private Long id;
    @NotEmpty
    @ApiModelProperty("姓名")
    private String name;
    @StatusValidation(enumClass = Status.class)
    @ApiModelProperty("状态：success／failed")
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

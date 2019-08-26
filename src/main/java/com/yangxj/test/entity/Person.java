package com.yangxj.test.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author yangxj
 * @date 2019-08-23 14:21
 */
@Data
public class Person {
    private String id;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT-8")
    private Date birthday;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT-8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT-8")
    private Date timeStamp;
}

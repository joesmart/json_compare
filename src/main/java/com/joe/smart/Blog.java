package com.joe.smart;

import lombok.Data;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: ZouYanjian
 * Date: 12-5-5
 * Time: 下午10:43
 * To change this template use File | Settings | File Templates.
 */
public @Data class Blog {
    private String name;
    private String content;
    private Date publishDate;
}

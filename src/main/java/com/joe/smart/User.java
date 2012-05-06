package com.joe.smart;

import lombok.Data;

import java.net.URL;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ZouYanjian
 * Date: 12-5-5
 * Time: 下午3:46
 * To change this template use File | Settings | File Templates.
 */
@Data
public class User {
    private String name;
    private int age;
    private Date bornDate;
    private URL blogUrl;
    private List<Blog> blogs;
}

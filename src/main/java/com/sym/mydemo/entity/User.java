package com.sym.mydemo.entity;

import lombok.Data;

/**
 * @author suyiming3333@gmail.com
 * @version V1.0
 * @Title: User
 * @Package com.sym.mydemo.entity
 * @Description: TODO
 * @date 2019/4/24 15:41
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}

package com.study.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends Base implements Serializable {
    private Integer uid ;// '用户id',
    private String username ;// '用户名',
    private String password ; //'密码',
    private String salt ; // '盐值',
    private String phone ;// '电话号码',
    private String email;// '电子邮箱',
    private Integer gender ;// '性别:0-女，1-男',
    private String avatar ; // '头像',
    private Integer isDelete; // '是否注销：0-未注销，1-已注销',
}

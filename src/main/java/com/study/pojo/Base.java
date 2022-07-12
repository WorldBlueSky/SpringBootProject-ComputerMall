package com.study.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Base implements Serializable {
    private String createdUser ;//'日志-创建人'
    private Date createdTime ;//'日志-创建时间'
    private String modifiedUser;  //'日志-最后修改执行人'
    private Date modifiedTime ;//'日志-最后修改时间'
}

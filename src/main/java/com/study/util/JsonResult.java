package com.study.util;

import lombok.*;

import java.io.Serializable;

/**
 * 对 JSON 格式的数据进行包装
 * @param <E>
 */

@Setter
@Getter
@ToString
public class JsonResult<E> implements Serializable {
    private Integer state; // 响应的状态码
    private String message;// 返回信息
    private E Data; // 返回的数据,因为不确定返回的是什么类型，所以是泛型，类也要是泛型

    public JsonResult(){

    }

    /** 只传递state类型的数据 **/
    public JsonResult(Integer state) {
        this.state = state;
    }

    /* 传递state，以及返回对应的数据 */
    public JsonResult(Integer state, E data) {
        this.state = state;
        Data = data;
    }

    /**
     * 返回出异常的提示信息
     * @param e
     */
    public JsonResult(Throwable e) {
        this.message = e.getMessage();
    }
}

package com.study.controller;

import com.study.service.ex.*;
import com.study.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 控制层类的基类
 */
public class BaseController {

    // 表示操作成功的状态码
    public static final int OK = 200;

    /**
     * 因为加了 @Exceptionhandler 所以当代码发生了异常的话，那么自动跳转到这里，同时传递异常对象到这个方法参数中
     * @param e
     * @return  返回值直接给到前端
     */

    // 用于统一处理抛出的异常 ,请求处理方法，方法的返回值就是需要返回给前端的数据
    // 自动将异常对象传递给当前方法的参数列表上

    @ExceptionHandler(ServiceException.class)
    public JsonResult<Void> handlerException(Throwable e){

        JsonResult<Void> result =new JsonResult<>();

        if(e instanceof UsernameDuplicatedException){
            result.setState(4000);
            result.setMessage(e.getMessage());
        }else if(e instanceof UsernameNotFoundException){
            result.setState(5001);
            result.setMessage(e.getMessage());
        }else if(e instanceof PasswordNotMatchException){
            result.setState(5002);
            result.setMessage(e.getMessage());
        }else if(e instanceof InsertException){
            result.setState(5000);
            result.setMessage(e.getMessage());
        }

        return result;
    }

}

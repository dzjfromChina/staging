package com.duzj.staging.base.myexception;

import org.apache.log4j.LogManager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/**
 * @author duzj
 * @create 2019-07-14 13:20
 */
@ControllerAdvice(annotations=Controller.class)
@ResponseBody
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    public final org.apache.log4j.Logger logger = LogManager.getLogger(this.getClass());

    @ExceptionHandler
    @ResponseStatus
    public ResponseBean exceptionHandler(Exception e) {
        //e.getStackTrace();
        e.printStackTrace();
        //数组长度为 1
        StackTraceElement s= e.getStackTrace()[0];
        Class<? extends Exception> aClass = e.getClass();
        System.out.println(aClass.getMethods());
        logger.error("异常文件:"+s.getFileName());
        logger.error("异常类:"+s.getClassName());
        logger.error("异常方法:"+s.getMethodName());
        logger.error("报错的message:"+e.getMessage());
        ResponseBean rb = new ResponseBean();
        rb.setCode(30000);
        rb.setMsg(e.getMessage());
        rb.setData("");
        return rb;
    }
}

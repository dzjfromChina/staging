package com.duzj.staging.controller.webController;

import com.duzj.staging.base.annotation.WebLog;
import com.duzj.staging.base.cache.DemoCache;
import com.duzj.staging.base.myexception.ResponseBean;
import com.duzj.staging.controller.BaseController;
import com.duzj.staging.pojo.Test;
import com.duzj.staging.pojo.base.InParam;
import com.duzj.staging.pojo.param.TestInInset;
import com.duzj.staging.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.*;

/*
 * @Author duzj
 * @date 2019/07/03
 */
@Controller
@RequestMapping("/testController")
public class TestController extends BaseController {

    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private ITestService testService;

    /**
     * 测试插入
     *
     * @param jsonString
     * @return
     */
    @WebLog(description = "测试")
    @RequestMapping("/test")
    @ResponseBody
    public Object test(@RequestBody String jsonString) {
        ResponseBean rb = new ResponseBean();
        //Map returnMap = new HashMap(3);

        logger.info("ok");
        int a = 1 / 0; //测试异常

        //测试缓存
        String testCache = DemoCache.get("testCache").toString();
        System.out.println("testCache:" + testCache);
        /**
         *  redis
         *  1. 先使用mybatis plus从test表读取数据
         *  2.插入redis
         *  3.从redis获取
         */
        for (Test test : testService.list()) {
            redisTemplate.opsForValue().set(test.getName(), test.getAge().toString());
        }
        System.out.println(redisTemplate.opsForValue().get("张飞"));

        //优雅的判断是否为空
        /*Test test;
        Assert.isNull(true, "test为空");*/
        rb.setCode(10000);
        rb.setMsg("请求成功");
        return rb;
    }


    /**
     * @param jsonString
     * @return
     */
    @WebLog(description = "插入")
    @RequestMapping("/insert")
    @ResponseBody
    public Object insert( @RequestBody() InParam<TestInInset> jsonString) {
        ResponseBean rb = new ResponseBean();
        System.out.println(jsonString);
        TestInInset parameter = jsonString.getParameter();
        System.out.println(parameter);
        return rb;
    }




}

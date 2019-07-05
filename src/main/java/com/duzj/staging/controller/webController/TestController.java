package com.duzj.staging.controller.webController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.duzj.staging.base.annotation.WebLog;
import com.duzj.staging.base.cache.DemoCache;
import com.duzj.staging.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @Author duzj
 * @date 2019/07/03
 */
@Controller
@RequestMapping("/testController")
public class TestController extends BaseController{

    /**
     * 测试插入
     * @param jsonString
     * @return
     */
    @WebLog(description ="测试")
    @RequestMapping("/test")
    @ResponseBody
    public Object test(@RequestBody String jsonString){
        Map returnMap = new HashMap(3);
        try{
            logger.info("ok");
            //int a = 1/0; //测试异常

            //测试缓存
            //
            String testCache = DemoCache.get("testCache").toString();
            System.out.println("testCache:"+testCache);
            returnMap.put("code",10000);
            returnMap.put("msg","请求成功");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("异常类:"+ e.getStackTrace()[0].toString()+",异常原因:"+e.getMessage());
            returnMap.put("code",30000);
            returnMap.put("msg","系统异常");
        }finally {
            //关闭流等操作
        }
        return returnMap;
    }
}

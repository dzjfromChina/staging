package com.duzj.staging.controller.webController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.duzj.staging.base.annotation.WebLog;
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
    public Object insert(@RequestBody String jsonString){
        Map returnMap = new HashMap(3);
        try{
            logger.info("ok");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("异常类:"+ Arrays.toString(e.getStackTrace())+",异常原因:"+e.getMessage());
            returnMap.put("code",30000);
            returnMap.put("msg","系统异常");
        }finally {

        }
        return returnMap;
    }
}

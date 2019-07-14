package com.duzj.staging.retime;

import cn.hutool.core.date.DateUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author duzj
 * @create 2019-07-06 14:42
 */
@Component
public class DemoScheduler implements InitializingBean {

    /**
     * https://www.cnblogs.com/pejsidney/p/9046818.html
     * 每隔2秒执行一次
     *
     * 如果想要项目启动就能执行这个方法 需要implements InitializingBean
     */
    //@Scheduled(fixedRate = 2000)
    public void testTasks() {
        System.out.println("定时任务执行时间：" + DateUtil.now());
    }

    //implements InitializingBean  这样就能在项目启动时就执行
    @Override
    public void afterPropertiesSet() throws Exception {
        //this.testTasks();
    }
}

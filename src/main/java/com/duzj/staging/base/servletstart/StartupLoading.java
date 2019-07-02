package com.duzj.staging.base.servletstart;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/**
 * @author duzj
 * @create 2019-06-12 10:54
 */
@Component
public class StartupLoading implements CommandLineRunner {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public void run(String... args) throws Exception {
        logger.info("====================开始加载缓存====================");
        logger.info("====================结束加载缓存====================");
    }


}

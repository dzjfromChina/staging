package com.duzj.staging.base.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author duzj
 * @create 2019-06-22 15:19
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * 没有这个  分页会失效
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }

}

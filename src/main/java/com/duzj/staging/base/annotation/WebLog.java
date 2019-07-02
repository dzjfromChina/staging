package com.duzj.staging.base.annotation;

import java.lang.annotation.*;

/**
 * @author duzj
 * @create 2019-06-12 13:22
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface WebLog {
    /**
     * 日志描述信息
     *
     * @return
     */
    String description() default "";

}

package com.duzj.staging.base.myexception;

import lombok.Data;

/**
 * @author duzj
 * @create 2019-07-14 13:33
 */
@Data
public class ResponseBean {
    private int code;
    private String msg;
    private Object data;
}

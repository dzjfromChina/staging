package com.duzj.staging.base.myexception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author duzj
 * @create 2019-07-14 13:33
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBean {
    private int code;
    private String msg;
    private Object data;
}

package com.duzj.staging.pojo.base;

import lombok.Data;
import lombok.ToString;

/**
 * @author duzj
 * @create 2019-07-31 9:19
 */
@Data
@ToString
public class InParam<T> {
    private String sign;
    private String machine;
    private String token;
    private T parameter;
}

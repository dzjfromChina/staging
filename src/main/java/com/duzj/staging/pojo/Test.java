package com.duzj.staging.pojo;

import com.duzj.staging.pojo.base.BaseBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
 * @Author duzj
 * @date 2019/07/03
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Test extends BaseBean {
    private String name;
    private Integer age;
}

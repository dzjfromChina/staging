package com.duzj.staging.pojo;

import com.duzj.staging.pojo.base.BaseBean;
import lombok.*;

/*
 * @Author duzj
 * @date 2019/07/03
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Test extends BaseBean {
    private String name;
    private Integer age;
}

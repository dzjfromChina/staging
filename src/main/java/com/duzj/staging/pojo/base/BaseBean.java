package com.duzj.staging.pojo.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;
import java.io.Serializable;

/**
 * @author duzj
 * @create 2019-06-12 9:17
 */
@Data
public class BaseBean implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键必须加  不然插入会报错
     */
    @TableId(value = "id",type = IdType.INPUT)
    private Integer id;

    private String createDate;
    private String createBy;
    private String updateBy;
    private String updateDate;
    private String memo1;
    private String memo2;
    private String memo3;

    /**
     * 非表中字段
     */
    @TableField(exist=false)
    private Integer startRow;
    @TableField(exist=false)
    private Integer pageSize;
    @TableField(exist=false)
    private String orderColName;
    @TableField(exist=false)
    private String orderType;
}

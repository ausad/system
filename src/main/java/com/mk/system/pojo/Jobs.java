package com.mk.system.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * @TableName tbjobs
 */
@TableName(value ="tbjobs")
@Data
public class Jobs implements Serializable {
    @TableId
    private Integer jobId;

    private String jobTitle;

    private BigDecimal salary;

    private String responsibilities;

    private static final long serialVersionUID = 1L;
}
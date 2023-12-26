package com.mk.system.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName tbdepart
 */
@TableName(value ="tbdepart")
@Data
public class Depart implements Serializable {
    @TableId
    private Integer departId;

    private Integer employeeId;

    private Date departDate;

    private String departReason;

    private static final long serialVersionUID = 1L;
}
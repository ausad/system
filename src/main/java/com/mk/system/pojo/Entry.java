package com.mk.system.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName tbentry
 */
@TableName(value ="tbentry")
@Data
public class Entry implements Serializable {
    @TableId
    private Integer entryId;

    private Integer employeeId;

    private Date entryDate;

    private String entryType;

    private static final long serialVersionUID = 1L;
}
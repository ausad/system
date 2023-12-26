package com.mk.system.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName tbdepartments
 */
@TableName(value ="tbdepartments")
@Data
public class Departments implements Serializable {
    @TableId
    private Integer departmentId;

    private String departmentName;

    private Integer managerId;

    private static final long serialVersionUID = 1L;
}
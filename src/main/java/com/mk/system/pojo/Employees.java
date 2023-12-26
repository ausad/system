package com.mk.system.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName tbemployees
 */
@TableName(value ="tbemployees")
@Data
public class Employees implements Serializable {
    @TableId
    private Integer employeeId;

    private String employeeName;

    private String gender;

    private String address;

    private String phone;

    private String email;

    private Integer departmentId;

    private Integer jobId;

    private static final long serialVersionUID = 1L;
}
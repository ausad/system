package com.mk.system.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @TableName tbtransferposition
 */
@TableName(value ="tbtransferposition")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transferposition implements Serializable {
    @TableId
    private Integer transferId;

    private Integer employeeId;

    private Integer previousJobId;

    private Integer newJobId;

    private Date transferDate;

    private static final long serialVersionUID = 1L;
}
package com.mk.system.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName tbusers
 */
@TableName(value ="tbusers")
@Data
public class User implements Serializable {
    @TableId
    private Integer userId;

    private String username;

    private String name;

    private String password;

    private String phone;

    private String email;

    private static final long serialVersionUID = 1L;
}
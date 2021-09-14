package com.yanzhen.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author maqh
 * @since 2020-08-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="User对象", description="用户信息表")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer deptId;

    private String username;

    @ApiModelProperty(value = "0 代表女1 代表男")
    private String password;

    private String realname;

    private String sex;

    private String tel;

    private String email;

    private String avatar;

    private String jobTitle;

    private Integer status;

    private Integer sort;

    private Integer delFlag;

    private String createBy;

    private Date updateTime;

    private Date createTime;


}

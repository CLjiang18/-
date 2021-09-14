package com.chen.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 房屋信息管理
 * </p>
 *
 * @author chen
 * @since 2021-09-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Houses对象", description="房屋信息管理")
public class Houses implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String numbers;

    private Integer ownerId;

    private String address;

    private Double type;

    private String imgs;

    private String province;

    private String city;

    private String county;

    @ApiModelProperty(value = "0 代表女1 代表男")
    private Double sort;

    @ApiModelProperty(value = "0 未出租1 出租中 2 已退租")
    private Integer status;

    private String remarks;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    @ApiModelProperty(value = "面积")
    private Double area;

    private Double price;
    //添加房主对象
    private Owner owner;

}

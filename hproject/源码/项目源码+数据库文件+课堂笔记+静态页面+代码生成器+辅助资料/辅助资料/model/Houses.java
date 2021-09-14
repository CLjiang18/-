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
 * 房屋信息管理
 * </p>
 *
 * @author maqh
 * @since 2020-08-21
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

/*    private Integer 所在省;

    private Integer 市;

    private Integer 县;*/

    @ApiModelProperty(value = "0 代表女 1 代表男")
    private Double sort;

    @ApiModelProperty(value = "0 未出租 1 出租中 2 已退租")
    private Integer status;

    private String remarks;

    private Date createTime;

    private String createBy;

    private Date updateTime;


}

package com.chen.pojo;

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
 * 租赁信息表
 * </p>
 *
 * @author chen
 * @since 2021-09-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Rentinfo对象", description="租赁信息表")
public class Rentinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer housesId;

    private Integer customerId;

    private Integer contractId;

    private String address;

    private String remarks;

    private Date createTime;

    private String djr;

    private Date updateTime;

    private String xgr;

    @ApiModelProperty(value = "0未退租
1 退租
")
    private Integer status;


}

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
 * 合同信息表
 * </p>
 *
 * @author maqh
 * @since 2020-08-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Contract对象", description="合同信息表")
public class Contract implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer customerId;

    private Integer housesId;

    private Date qzrq;

    @ApiModelProperty(value = "0 代表女 1 代表男")
    private Date kfrq;

    private Date tzrq;

    private Double money;

    private String paymoney;

    private Date createTime;

    private String djr;

    private Date updateTime;

    private String xgr;

    private String 承租人身份号码;


}

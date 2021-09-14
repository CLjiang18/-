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
 * 合同信息表
 * </p>
 *
 * @author chen
 * @since 2021-09-01
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

    @ApiModelProperty(value = "0 代表女
            1 代表男")
    private Date kfrq;

    private Date tzrq;

    private Double money;

    private String paymoney;

    private Date createTime;

    private String djr;

    private Date updateTime;

    private String xgr;

    @ApiModelProperty(value = "租赁用户的身份证号")
    private String rentId;

    private String payrent;


}

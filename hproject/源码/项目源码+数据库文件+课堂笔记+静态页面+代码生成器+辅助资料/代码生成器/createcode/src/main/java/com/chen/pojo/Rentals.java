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
 * 收租信息表
 * </p>
 *
 * @author chen
 * @since 2021-09-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Rentals对象", description="收租信息表")
public class Rentals implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer housesId;

    private Integer customerId;

    private Integer money;

    private String address;

    @ApiModelProperty(value = "截至日期")
    private Date jzrq;

    @ApiModelProperty(value = "交租人")
    private String jfr;

    private String remarks;

    private Date date;

    private String djr;

    private Date updateTime;

    private String xgr;

    @ApiModelProperty(value = "开始日期")
    private Date ksrq;


}

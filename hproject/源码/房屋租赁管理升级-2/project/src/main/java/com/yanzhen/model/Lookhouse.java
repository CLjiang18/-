package com.yanzhen.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 看房信息表
 * </p>
 *
 * @author maqh
 * @since 2020-08-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Lookhouse对象", description="看房信息表")
public class Lookhouse implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer housesId;

    private Integer customerId;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date lookDate;

    private String remarks;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date date;

    private String djr;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date updateTime;

    private String xgr;

    @ApiModelProperty(value = "0 未看房1 已看房")
    private Integer stutas;

    private Customer customer;
    private Houses houses;
    private Owner owners;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setHouses(Houses houses) {
        this.houses = houses;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setHousesId(Integer housesId) {
        this.housesId = housesId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public void setLookDate(Date lookDate) {
        this.lookDate = lookDate;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDjr(String djr) {
        this.djr = djr;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setXgr(String xgr) {
        this.xgr = xgr;
    }

    public void setStutas(Integer stutas) {
        this.stutas = stutas;
    }
}

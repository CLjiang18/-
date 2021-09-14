package com.yanzhen.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 租赁信息表
 * </p>
 *
 * @author maqh
 * @since 2020-08-21
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

    private Customer customer;
    private Houses houses;

    private Contract contract;
    private Integer status;

    public Integer getHousesId() {
        return housesId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setHouses(Houses houses) {
        this.houses = houses;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setHousesId(Integer housesId) {
        this.housesId = housesId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


}

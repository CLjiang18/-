package com.yanzhen.model;

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
 * @author kappy
 * @since 2020-09-19
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


    private Double sort;

    @ApiModelProperty(value = "0 未出租 1 出租中2 已退租")
    private Integer status;

    private String remarks;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private double price;
    private double area;

    private Integer zt;//主要客户端查询
    private Integer lookId;//主要客户端查询



    public void setPrice(double price) {
        this.price = price;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPrice() {
        return price;
    }

    public double getArea() {
        return area;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //添加房东对象
    private Owner owner;

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }
}

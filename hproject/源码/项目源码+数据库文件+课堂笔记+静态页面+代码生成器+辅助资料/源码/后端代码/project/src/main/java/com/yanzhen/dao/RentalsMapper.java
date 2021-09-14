package com.yanzhen.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yanzhen.model.Rentals;
import com.yanzhen.model.RentalsVo;
import com.yanzhen.model.TongJi;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 收租信息表 Mapper 接口
 * </p>
 *
 * @author kappy
 * @since 2020-09-19
 */
@Component("rentalsDao")
public interface RentalsMapper extends BaseMapper<Rentals> {

    /**
     * 查询缴费信息列表
     */
    List<RentalsVo> queryList(RentalsVo rentalsVo);

    /**
     * 按月统计收租的金额
     */
    List<TongJi> queryCount();
}

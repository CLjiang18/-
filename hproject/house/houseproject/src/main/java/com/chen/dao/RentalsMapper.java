package com.chen.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chen.pojo.Rentals;
import com.chen.pojo.RentalsVo;
import com.chen.pojo.TongJi;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 收租信息表 Mapper 接口
 * </p>
 *
 * @author chen
 * @since 2021-09-01
 */
@Repository
public interface RentalsMapper extends BaseMapper<Rentals> {
    /**
     * 查询缴费列表
     */
    List<RentalsVo> queryList(RentalsVo rentalsVo);
    /**
     * 统计信息收租租金，按月份
     */
    List<TongJi> queryCounts();
}

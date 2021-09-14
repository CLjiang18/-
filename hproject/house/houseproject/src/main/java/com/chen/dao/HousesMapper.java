package com.chen.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chen.pojo.Customer;
import com.chen.pojo.Houses;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 房屋信息管理 Mapper 接口
 * </p>
 *
 * @author chen
 * @since 2021-09-01
*/
@Repository
public interface HousesMapper extends BaseMapper<Houses> {
    /**
     * 查询房屋信息
     */
    List<Houses> queryAll(Houses houses);
    List<Houses> queryHouseAll2(Integer id);
}

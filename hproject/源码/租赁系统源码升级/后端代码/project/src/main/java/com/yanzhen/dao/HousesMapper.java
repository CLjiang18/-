package com.yanzhen.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yanzhen.model.Houses;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 房屋信息管理 Mapper 接口
 * </p>
 *
 * @author kappy
 * @since 2020-09-19
 */
@Component("housesDao")
public interface HousesMapper extends BaseMapper<Houses> {

    /**
     * 根据条件查询房屋列表信息
     * @param houses
     * @return
     */
    List<Houses> queryHouseAll(Houses houses);

    List<Houses> queryHouseAll2(Integer id);
}

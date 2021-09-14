package com.yanzhen.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yanzhen.model.RentalsVo;
import com.yanzhen.model.Repair;
import com.yanzhen.model.TongJi;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 报修信息表 Mapper 接口
 * </p>
 *
 * @author kappy
 * @since 2020-09-19
 */
@Component("repairDao")
public interface RepairMapper extends BaseMapper<Repair> {
    List<Repair> queryList(Repair repair);

    //按月份维修数据的统计
    List<TongJi> queryCount();
}

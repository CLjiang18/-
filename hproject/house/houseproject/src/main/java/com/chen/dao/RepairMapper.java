package com.chen.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chen.pojo.Repair;
import com.chen.pojo.TongJi;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 报修信息表 Mapper 接口
 * </p>
 *
 * @author chen
 * @since 2021-09-01
 */
@Repository
public interface RepairMapper extends BaseMapper<Repair> {
    /**
     * 查询所有记录
     * @param repair
     * @return
     */
    List<Repair> queryList(Repair repair);

    /**
     * 按月份统计维修次数
     * @return
     */
    List<TongJi> queryCount();

}

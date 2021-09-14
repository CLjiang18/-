package com.chen.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chen.pojo.Rentinfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 租赁信息表 Mapper 接口
 * </p>
 *
 * @author chen
 * @since 2021-09-01
 */
@Repository
public interface RentinfoMapper extends BaseMapper<Rentinfo> {
    /**
     * 查询租赁信息记录、并实现高级查询
     * @param rentinfo
     * @return
     */
    List<Rentinfo> queryRentInfoALL(Rentinfo rentinfo);
    /**
     * 根据房子id查询客户ID
     * 提供repair的报修申请功能使用
     */
    Rentinfo queryByHId(Integer id);
}

package com.yanzhen.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yanzhen.model.Lookhouse;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 看房信息表 Mapper 接口
 * </p>
 *
 */
@Component("lookhouseDao")
public interface LookhouseMapper extends BaseMapper<Lookhouse> {
   /*
      查询所有的看房申请列表  支持高级查询
    */
    List<Lookhouse> queryLookHouseAll(Lookhouse lookhouse);

    /**
     * 根据看房申请id获取相关记录信息
     */
    Lookhouse queryById(Integer id);

}

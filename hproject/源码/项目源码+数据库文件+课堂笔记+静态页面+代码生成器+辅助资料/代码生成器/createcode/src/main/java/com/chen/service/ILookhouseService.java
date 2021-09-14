package com.chen.service;

import com.chen.pojo.Lookhouse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 看房信息表 服务类
 * </p>
 *
 * @author chen
 * @since 2021-09-01
 */
public interface ILookhouseService extends IService<Lookhouse> {

    /**
     * 查询看房信息表分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Lookhouse>
     */
    IPage<Lookhouse> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加看房信息表
     *
     * @param lookhouse 看房信息表
     * @return int
     */
    int add(Lookhouse lookhouse);

    /**
     * 删除看房信息表
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改看房信息表
     *
     * @param lookhouse 看房信息表
     * @return int
     */
    int updateData(Lookhouse lookhouse);

    /**
     * id查询数据
     *
     * @param id id
     * @return Lookhouse
     */
    Lookhouse findById(Long id);
}

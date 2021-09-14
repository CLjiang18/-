package com.chen.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chen.pojo.Customer;
import com.chen.pojo.Houses;
import com.chen.pojo.Lookhouse;
import com.github.pagehelper.PageInfo;

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
     * 分页查询看房信息列表
     * @param page
     * @param limit
     * @param lookhouse
     * @return
     */
    PageInfo<Lookhouse> queryLookHouseAll(Integer page, Integer limit, Lookhouse lookhouse);

    /**
     * 根据id查询用户，返回前端
     * @param id
     * @return
     */
    Lookhouse queryById(Integer id);
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

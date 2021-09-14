package com.yanzhen.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.yanzhen.model.Houses;

/**
 * <p>
 * 房屋信息管理 服务类
 * </p>
 *
 * @author kappy
 * @since 2020-09-19
 */
public interface IHousesService extends IService<Houses> {

    /**
     * 根据条件分页查询房屋信息
     */
    PageInfo<Houses> findHouseAll(Integer page, Integer pageSize, Houses houses);

    PageInfo<Houses> findHouseAll2(Integer page, Integer pageSize, Integer id);
    /**
     * 查询房屋信息管理分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Houses>
     */
    IPage<Houses> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加房屋信息管理
     *
     * @param houses 房屋信息管理
     * @return int
     */
    int add(Houses houses);

    /**
     * 删除房屋信息管理
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改房屋信息管理
     *
     * @param houses 房屋信息管理
     * @return int
     */
    int updateData(Houses houses);

    /**
     * id查询数据
     *
     * @param id id
     * @return Houses
     */
    Houses findById(Long id);
}

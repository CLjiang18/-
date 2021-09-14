package com.chen.service;

import com.chen.pojo.Houses;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 房屋信息管理 服务类
 * </p>
 *
 * @author chen
 * @since 2021-09-01
 */
public interface IHousesService extends IService<Houses> {

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

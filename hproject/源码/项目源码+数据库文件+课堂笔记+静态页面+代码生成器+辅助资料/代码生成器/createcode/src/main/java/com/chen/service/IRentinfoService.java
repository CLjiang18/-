package com.chen.service;

import com.chen.pojo.Rentinfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 租赁信息表 服务类
 * </p>
 *
 * @author chen
 * @since 2021-09-01
 */
public interface IRentinfoService extends IService<Rentinfo> {

    /**
     * 查询租赁信息表分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Rentinfo>
     */
    IPage<Rentinfo> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加租赁信息表
     *
     * @param rentinfo 租赁信息表
     * @return int
     */
    int add(Rentinfo rentinfo);

    /**
     * 删除租赁信息表
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改租赁信息表
     *
     * @param rentinfo 租赁信息表
     * @return int
     */
    int updateData(Rentinfo rentinfo);

    /**
     * id查询数据
     *
     * @param id id
     * @return Rentinfo
     */
    Rentinfo findById(Long id);
}

package com.chen.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chen.pojo.Houses;
import com.chen.pojo.Rentinfo;
import com.github.pagehelper.PageInfo;

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
     * 高级查询,支持分页效果
     * @param page
     * @param limit
     * @param rentinfo
     * @return PageInfo<Owner>
     */
    PageInfo<Rentinfo> queryAll(Integer page, Integer limit, Rentinfo rentinfo);
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
//给repair的add用
    Rentinfo queryByHId(Integer id);
}

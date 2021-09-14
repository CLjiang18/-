package com.chen.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.dao.NoticeMapper;
import com.chen.pojo.Lookhouse;
import com.chen.pojo.Notice;
import com.chen.pojo.RentalsVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 公告信息表 公布最新优质房源 服务实现类
 * </p>
 *
 * @author chen
 * @since 2021-09-01
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements INoticeService {
    @Resource
    private NoticeMapper noticeMapper;
    @Override
    public PageInfo<Notice> queryAll(int page, int limit, Notice notice) {
        //分页
        PageHelper.startPage(page,limit);
        //查询所有用户信息
        List<Notice> list=noticeMapper.queryNoticeAll(notice);
        PageInfo<Notice> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public  IPage<Notice> findListByPage(Integer page, Integer pageCount){
        IPage<Notice> wherePage = new Page<>(page, pageCount);
        Notice where = new Notice();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Notice notice){
        return baseMapper.insert(notice);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Notice notice){
        return baseMapper.updateById(notice);
    }

    @Override
    public Notice findById(Long id){
        return  baseMapper.selectById(id);
    }
}

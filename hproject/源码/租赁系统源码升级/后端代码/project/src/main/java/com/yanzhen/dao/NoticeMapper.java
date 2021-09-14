package com.yanzhen.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yanzhen.model.Notice;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 公告信息表 公布最新优质房源 Mapper 接口
 * </p>
 *
 * @author kappy
 * @since 2020-09-19
 */
@Component("noticeDao")
public interface NoticeMapper extends BaseMapper<Notice> {
    List<Notice> queryNoticeAll(@Param("Content") String Content);
}

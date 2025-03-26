package com.dao;

import com.entity.DiscussmiaoshashangpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussmiaoshashangpinVO;
import com.entity.view.DiscussmiaoshashangpinView;


/**
 * 抢购活动评论表
 * 
 * @author 
 * @email 
 * @date 2024-05-21 09:39:22
 */
public interface DiscussmiaoshashangpinDao extends BaseMapper<DiscussmiaoshashangpinEntity> {
	
	List<DiscussmiaoshashangpinVO> selectListVO(@Param("ew") Wrapper<DiscussmiaoshashangpinEntity> wrapper);
	
	DiscussmiaoshashangpinVO selectVO(@Param("ew") Wrapper<DiscussmiaoshashangpinEntity> wrapper);
	
	List<DiscussmiaoshashangpinView> selectListView(@Param("ew") Wrapper<DiscussmiaoshashangpinEntity> wrapper);

	List<DiscussmiaoshashangpinView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussmiaoshashangpinEntity> wrapper);
	
	DiscussmiaoshashangpinView selectView(@Param("ew") Wrapper<DiscussmiaoshashangpinEntity> wrapper);
	

}

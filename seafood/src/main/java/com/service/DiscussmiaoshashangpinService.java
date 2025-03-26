package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussmiaoshashangpinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussmiaoshashangpinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussmiaoshashangpinView;


/**
 * 抢购活动评论表
 *
 * @author 
 * @email 
 * @date 2024-05-21 09:39:22
 */
public interface DiscussmiaoshashangpinService extends IService<DiscussmiaoshashangpinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussmiaoshashangpinVO> selectListVO(Wrapper<DiscussmiaoshashangpinEntity> wrapper);
   	
   	DiscussmiaoshashangpinVO selectVO(@Param("ew") Wrapper<DiscussmiaoshashangpinEntity> wrapper);
   	
   	List<DiscussmiaoshashangpinView> selectListView(Wrapper<DiscussmiaoshashangpinEntity> wrapper);
   	
   	DiscussmiaoshashangpinView selectView(@Param("ew") Wrapper<DiscussmiaoshashangpinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussmiaoshashangpinEntity> wrapper);
   	

}


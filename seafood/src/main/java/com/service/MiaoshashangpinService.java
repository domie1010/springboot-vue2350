package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.MiaoshashangpinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.MiaoshashangpinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.MiaoshashangpinView;


/**
 * 抢购活动
 *
 * @author 
 * @email 
 * @date 2024-05-21 09:39:22
 */
public interface MiaoshashangpinService extends IService<MiaoshashangpinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MiaoshashangpinVO> selectListVO(Wrapper<MiaoshashangpinEntity> wrapper);
   	
   	MiaoshashangpinVO selectVO(@Param("ew") Wrapper<MiaoshashangpinEntity> wrapper);
   	
   	List<MiaoshashangpinView> selectListView(Wrapper<MiaoshashangpinEntity> wrapper);
   	
   	MiaoshashangpinView selectView(@Param("ew") Wrapper<MiaoshashangpinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MiaoshashangpinEntity> wrapper);
   	

}


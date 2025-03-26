package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscussmiaoshashangpinDao;
import com.entity.DiscussmiaoshashangpinEntity;
import com.service.DiscussmiaoshashangpinService;
import com.entity.vo.DiscussmiaoshashangpinVO;
import com.entity.view.DiscussmiaoshashangpinView;

@Service("discussmiaoshashangpinService")
public class DiscussmiaoshashangpinServiceImpl extends ServiceImpl<DiscussmiaoshashangpinDao, DiscussmiaoshashangpinEntity> implements DiscussmiaoshashangpinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussmiaoshashangpinEntity> page = this.selectPage(
                new Query<DiscussmiaoshashangpinEntity>(params).getPage(),
                new EntityWrapper<DiscussmiaoshashangpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussmiaoshashangpinEntity> wrapper) {
		  Page<DiscussmiaoshashangpinView> page =new Query<DiscussmiaoshashangpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussmiaoshashangpinVO> selectListVO(Wrapper<DiscussmiaoshashangpinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussmiaoshashangpinVO selectVO(Wrapper<DiscussmiaoshashangpinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussmiaoshashangpinView> selectListView(Wrapper<DiscussmiaoshashangpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussmiaoshashangpinView selectView(Wrapper<DiscussmiaoshashangpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

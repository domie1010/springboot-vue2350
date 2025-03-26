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


import com.dao.MiaoshashangpinDao;
import com.entity.MiaoshashangpinEntity;
import com.service.MiaoshashangpinService;
import com.entity.vo.MiaoshashangpinVO;
import com.entity.view.MiaoshashangpinView;

@Service("miaoshashangpinService")
public class MiaoshashangpinServiceImpl extends ServiceImpl<MiaoshashangpinDao, MiaoshashangpinEntity> implements MiaoshashangpinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MiaoshashangpinEntity> page = this.selectPage(
                new Query<MiaoshashangpinEntity>(params).getPage(),
                new EntityWrapper<MiaoshashangpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MiaoshashangpinEntity> wrapper) {
		  Page<MiaoshashangpinView> page =new Query<MiaoshashangpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<MiaoshashangpinVO> selectListVO(Wrapper<MiaoshashangpinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public MiaoshashangpinVO selectVO(Wrapper<MiaoshashangpinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<MiaoshashangpinView> selectListView(Wrapper<MiaoshashangpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MiaoshashangpinView selectView(Wrapper<MiaoshashangpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

package com.entity.view;

import com.entity.DiscussmiaoshashangpinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 抢购活动评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-05-21 09:39:22
 */
@TableName("discussmiaoshashangpin")
public class DiscussmiaoshashangpinView  extends DiscussmiaoshashangpinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussmiaoshashangpinView(){
	}
 
 	public DiscussmiaoshashangpinView(DiscussmiaoshashangpinEntity discussmiaoshashangpinEntity){
 	try {
			BeanUtils.copyProperties(this, discussmiaoshashangpinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;
import com.entity.OrdersEntity;
import com.service.OrdersService;

import com.entity.MiaoshashangpinEntity;
import com.entity.view.MiaoshashangpinView;

import com.service.MiaoshashangpinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 抢购活动
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-21 09:39:22
 */
@RestController
@RequestMapping("/miaoshashangpin")
public class MiaoshashangpinController {
    @Autowired
    private MiaoshashangpinService miaoshashangpinService;

    @Autowired
    private StoreupService storeupService;

    @Autowired
    private OrdersService ordersService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,MiaoshashangpinEntity miaoshashangpin,
                @RequestParam(required = false) Double pricestart,
                @RequestParam(required = false) Double priceend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shangjia")) {
			miaoshashangpin.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<MiaoshashangpinEntity> ew = new EntityWrapper<MiaoshashangpinEntity>();
                if(pricestart!=null) ew.ge("price", pricestart);
                if(priceend!=null) ew.le("price", priceend);

		PageUtils page = miaoshashangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, miaoshashangpin), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,MiaoshashangpinEntity miaoshashangpin, 
                @RequestParam(required = false) Double pricestart,
                @RequestParam(required = false) Double priceend,
		HttpServletRequest request){
        EntityWrapper<MiaoshashangpinEntity> ew = new EntityWrapper<MiaoshashangpinEntity>();
                if(pricestart!=null) ew.ge("price", pricestart);
                if(priceend!=null) ew.le("price", priceend);

		PageUtils page = miaoshashangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, miaoshashangpin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( MiaoshashangpinEntity miaoshashangpin){
       	EntityWrapper<MiaoshashangpinEntity> ew = new EntityWrapper<MiaoshashangpinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( miaoshashangpin, "miaoshashangpin")); 
        return R.ok().put("data", miaoshashangpinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MiaoshashangpinEntity miaoshashangpin){
        EntityWrapper< MiaoshashangpinEntity> ew = new EntityWrapper< MiaoshashangpinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( miaoshashangpin, "miaoshashangpin")); 
		MiaoshashangpinView miaoshashangpinView =  miaoshashangpinService.selectView(ew);
		return R.ok("查询抢购活动成功").put("data", miaoshashangpinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        MiaoshashangpinEntity miaoshashangpin = miaoshashangpinService.selectById(id);
		miaoshashangpin.setClicktime(new Date());
		miaoshashangpinService.updateById(miaoshashangpin);
        return R.ok().put("data", miaoshashangpin);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        MiaoshashangpinEntity miaoshashangpin = miaoshashangpinService.selectById(id);
		miaoshashangpin.setClicktime(new Date());
		miaoshashangpinService.updateById(miaoshashangpin);
        return R.ok().put("data", miaoshashangpin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MiaoshashangpinEntity miaoshashangpin, HttpServletRequest request){
    	miaoshashangpin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(miaoshashangpin);
        miaoshashangpinService.insert(miaoshashangpin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody MiaoshashangpinEntity miaoshashangpin, HttpServletRequest request){
    	miaoshashangpin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(miaoshashangpin);
        miaoshashangpinService.insert(miaoshashangpin);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody MiaoshashangpinEntity miaoshashangpin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(miaoshashangpin);
        miaoshashangpinService.updateById(miaoshashangpin);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        miaoshashangpinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<MiaoshashangpinEntity> wrapper = new EntityWrapper<MiaoshashangpinEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shangjia")) {
			wrapper.eq("zhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = miaoshashangpinService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,MiaoshashangpinEntity miaoshashangpin, HttpServletRequest request,String pre){
        EntityWrapper<MiaoshashangpinEntity> ew = new EntityWrapper<MiaoshashangpinEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = miaoshashangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, miaoshashangpin), params), params));
        return R.ok().put("data", page);
    }


        /**
     * 协同算法（按用户购买推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,MiaoshashangpinEntity miaoshashangpin, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String goodtypeColumn = "shangpinfenlei";
        List<OrdersEntity> orders = ordersService.selectList(new EntityWrapper<OrdersEntity>().eq("userid", userId).eq("tablename", "miaoshashangpin").orderBy("addtime", false));
        List<String> goodtypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<MiaoshashangpinEntity> miaoshashangpinList = new ArrayList<MiaoshashangpinEntity>();
	//去重
    	List<OrdersEntity> ordersDist = new ArrayList<OrdersEntity>();
    	for(OrdersEntity o1 : orders) {
    		boolean addFlag = true;
    		for(OrdersEntity o2 : ordersDist) {
    			if(o1.getGoodid()==o2.getGoodid() || o1.getGoodtype().equals(o2.getGoodtype())) {
    				addFlag = false;
    				break;
    			}
    		}
    		if(addFlag) ordersDist.add(o1);
    	}
        if(ordersDist!=null && ordersDist.size()>0) {
                for(OrdersEntity o : ordersDist) {
                        miaoshashangpinList.addAll(miaoshashangpinService.selectList(new EntityWrapper<MiaoshashangpinEntity>().eq(goodtypeColumn, o.getGoodtype())));
                }
        }
        EntityWrapper<MiaoshashangpinEntity> ew = new EntityWrapper<MiaoshashangpinEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = miaoshashangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, miaoshashangpin), params), params));
        List<MiaoshashangpinEntity> pageList = (List<MiaoshashangpinEntity>)page.getList();
        if(miaoshashangpinList.size()<limit) {
                int toAddNum = (limit-miaoshashangpinList.size())<=pageList.size()?(limit-miaoshashangpinList.size()):pageList.size();
                for(MiaoshashangpinEntity o1 : pageList) {
                    boolean addFlag = true;
                    for(MiaoshashangpinEntity o2 : miaoshashangpinList) {
                        if(o1.getId().intValue()==o2.getId().intValue()) {
                            addFlag = false;
                            break;
                        }
                    }
                    if(addFlag) {
                        miaoshashangpinList.add(o1);
                        if(--toAddNum==0) break;
                    }   
                }
        } else if(miaoshashangpinList.size()>limit) {
            miaoshashangpinList = miaoshashangpinList.subList(0, limit);
        }
        page.setList(miaoshashangpinList);
        return R.ok().put("data", page);
    }







}

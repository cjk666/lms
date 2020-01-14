package com.entor.controller;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.entor.entity.Cargo;
import com.entor.entity.Order;
import com.entor.entity.Result;
import com.entor.service.IOrderService;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cjk
 * @since 2020-01-06
 */
@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private IOrderService orderService;
	
	@RequestMapping("add")
	@ResponseBody
	public Result add(Order order) {
		order.setCreateTime(new Date());
		orderService.save(order);
		return new Result(0,"添加成功！");
	}
	
	@RequestMapping("addMore")
	public Result addMore() {
		return null;
	}
	
	@RequestMapping("update")
	@ResponseBody
	public Result update(Order order){
		orderService.updateById(order);
		return new Result(0,"修改成功！");
	}
	
	@RequestMapping("deleteById")
	@ResponseBody
	public Result deleteById(int id) {
		orderService.removeById(id);
		return new Result(0,"删除成功！");
	}
	
	@RequestMapping("deleteMore")
	@ResponseBody
	public Result deleteMore(String ids) {
		List<String> list = Arrays.asList(ids.split(","));
		orderService.removeByIds(list);
		return new Result(0,list.size()+"条数据删除成功！");
	}
	
	@RequestMapping("/queryByPage")
	@ResponseBody
	public Map<String, Object> queryByPage(@RequestParam(name = "limit",required = false, defaultValue = "1")int currentPage,
			@RequestParam(name = "page",required = false, defaultValue = "20" )int pageSize) {
		Page<Order> page = new Page<>(currentPage, pageSize);
		Page<Order> list = orderService.page(page);
		Map<String, Object> map = new HashMap<>();
		map.put("count", list.getTotal());
		map.put("code", 0);
		map.put("msg", "");
		map.put("data",list.getRecords());
		return map;
	}
	
	@RequestMapping("queryByMap")
	public Map<String, Object> queryByMap(String q, @RequestParam(name = "limit",required = false, defaultValue = "1")int currentPage,
			@RequestParam(name = "page",required = false, defaultValue = "20" )int pageSize){
		QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
		queryWrapper.like(true, "cargo_name", q);
		Page<Order> page = orderService.page(new Page<Order>(currentPage, pageSize), queryWrapper);
		Map<String, Object> map = new HashMap<>();
		map.put("count", page.getTotal());
		map.put("code", 0);
		map.put("msg", "");
		map.put("data",page.getRecords());
		return map;
	}
	
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		//如果客户端传递yyyy-MM-dd格式的字符串，就当做java.util.Date类型处理
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}


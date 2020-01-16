package com.entor.controller;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.entor.entity.Client;
import com.entor.entity.Result;
import com.entor.service.IClientService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cjk
 * @since 2020-01-06
 */
@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private IClientService clientService;
	
	
	@RequestMapping("add")
	public Result add(Client client) {
		client.setCreateTime(new Date());
		clientService.save(client);
		return new Result(0,"添加成功！");
	}
	
	@RequestMapping("addMore")
	public Result addMore() {
		return null;
	}
	
	@RequestMapping("update")
	@ResponseBody
	public Result update(Client client){
		clientService.updateById(client);
		return new Result(0,"修改成功！");
	}
	
	@RequestMapping("deleteById")
	public Result deleteById(String id) {
		clientService.removeById(id);
		return new Result(0,"删除成功！");
	}
	
	@RequestMapping("deleteMore")
	public Result deleteMore(String ids) {
		List<String> list = Arrays.asList(ids.split(","));
		clientService.removeByIds(list);
		return new Result(0,list.size()+"条数据删除成功！");
	}
	
	@RequestMapping("/queryByPage")
	public Map<String, Object> queryByPage(@RequestParam(value="limit",required=false,defaultValue="20") int pageSize,
			@RequestParam(value="page",required=false,defaultValue="1") int currentPage
			,String name, String phone) {
		QueryWrapper<Client> qw = new QueryWrapper<>();
		qw.like(is(name) ,"name", name);
		qw.like(is(phone),"phone", phone);
		qw.orderByAsc("create_time");
		Page<Client> page = new Page<>(currentPage, pageSize);
		Page<Client> list = clientService.page(page,qw);
		Map<String, Object> map = new HashMap<>();
		map.put("count", clientService.count(qw));
		map.put("code", 0);
		map.put("msg", "");
		map.put("data",list.getRecords());
		return map;
	}
	
	public boolean is(String str) {
		if (str != null && str != "") {
			return true;
		}
		return false;
	}
	
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		//如果客户端传递yyyy-MM-dd格式的字符串，就当做java.util.Date类型处理
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
	
	
	
}


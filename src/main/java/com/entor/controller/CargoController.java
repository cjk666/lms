package com.entor.controller;


import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.entor.entity.Cargo;
import com.entor.entity.Result;
import com.entor.service.ICargoService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cjk
 * @since 2020-01-06
 */
@RestController
@RequestMapping("/cargo")
public class CargoController {
	
	@Autowired
	private ICargoService cargoService;
	
	@RequestMapping("/add")
	public Result add(Cargo cargo) {
		cargo.setCreateTime(new Date());
		cargoService.save(cargo);
		return new Result(0,"添加成功");
	}
	
	@RequestMapping("/update")
	public Result update(Cargo cargo) {
		cargoService.updateById(cargo);
		return new Result(0,"修改成功");
	}
	
	@RequestMapping("/deleteById")
	public Result deleteById(String id) {
		cargoService.removeById(id);
			return new Result(0,"删除成功");
	}
	
	@RequestMapping("/deleteMore")
	public Result deleteMore(String[] ids) {
		cargoService.removeByIds(Arrays.asList(ids));
		return new Result(0,"删除成功");
	}
	
	@RequestMapping("queryByPage")
	public Map<String, Object> queryByPage(@RequestParam(defaultValue = "1", name = "page", required = false)int CurrentPage
			, @RequestParam(defaultValue = "1", name = "limit", required = false)int pageSize){
		Page<Cargo> page = cargoService.page(new Page<Cargo>(CurrentPage, pageSize));
		Map<String, Object> map = new HashMap<>();
		map.put("data", page.getRecords());
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", page.getTotal());
		return map;
	}
}


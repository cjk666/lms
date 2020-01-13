package com.entor.service;

import com.entor.entity.Emp;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cjk
 * @since 2020-01-06
 */
public interface IEmpService extends IService<Emp> {

	public Emp login(String username, String password);
	
}

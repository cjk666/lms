package com.entor.service.impl;

import com.entor.entity.Emp;
import com.entor.mapper.EmpMapper;
import com.entor.service.IEmpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cjk
 * @since 2020-01-06
 */
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements IEmpService {

	@Autowired
	private EmpMapper empMapper;
	
	
	@Override
	public Emp login(String username, String password) {
		return empMapper.login(username, password);
	}
	
}

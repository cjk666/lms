package com.entor.service.impl;

import com.entor.entity.ClientVip;
import com.entor.mapper.ClientVipMapper;
import com.entor.service.IClientVipService;
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
public class ClientVipServiceImpl extends ServiceImpl<ClientVipMapper, ClientVip> implements IClientVipService {

	@Autowired
	private ClientVipMapper clientVipMapper;
	
	@Override
	public ClientVip login(String username, String password) {
		return clientVipMapper.login(username, password);
	}

}

package com.entor.service;

import com.entor.entity.ClientVip;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cjk
 * @since 2020-01-06
 */
public interface IClientVipService extends IService<ClientVip> {

	public ClientVip login(String username, String password);
	
}

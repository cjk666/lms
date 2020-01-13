package com.entor.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.entor.entity.ClientVip;
import com.entor.service.IClientVipService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cjk
 * @since 2020-01-06
 */
@RestController
@RequestMapping("/client-vip")
public class ClientVipController {
	
	@Autowired
	private IClientVipService clientVipService;
	
	@RequestMapping("login")
	public String login(String username, String password) {
		ClientVip client = clientVipService.login(username, password);
		return null; 
	}
	
}


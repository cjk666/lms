package com.entor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Index {
	
	@RequestMapping("index")
	public String index() {
		return "index";
	}

	@RequestMapping("/order")
	public String order() {
		return "order";
	}
	
	@RequestMapping("/addOrder")
	public String addOrder() {
		return "addOrder";
	}
	
	@RequestMapping("/cargo")
	public String cargo() {
		return "cargo";
	}
	
	@RequestMapping("/client")
	public String client() {
		return "client";
	}
	
	@RequestMapping("/clientVip")
	public String clientVip() {
		return "clientVip";
	}
}

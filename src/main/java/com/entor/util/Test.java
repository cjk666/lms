package com.entor.util;

import java.util.Arrays;
import java.util.List;

public class Test {
	
	public static void main(String[] args) {
		String ids = "1,2,3,4";
		List<String> list = Arrays.asList(ids.split(","));
		
		for (String s : list) {
			System.out.println(s);
		}
		
		
	}
	
}

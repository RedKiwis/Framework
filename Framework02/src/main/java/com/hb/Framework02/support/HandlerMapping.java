package com.hb.Framework02.support;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {
	private static Map<String,String> map = new HashMap<String,String>();
	
	public static void setMap(String key,String value) {
		map.put(key, value);
	}
	
	public static MyController mapping(String uri) {
		MyController controller = null;
		try {
			Class clzz = Class.forName(map.get(uri));
			controller = (MyController) clzz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return controller;
	}

}

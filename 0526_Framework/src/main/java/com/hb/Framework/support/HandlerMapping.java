package com.hb.Framework.support;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {
	private static Map<String,String> map = new HashMap<String,String>();
	public static void setMap(String ukey,String cname){
		map.put(ukey,cname);
	}
	
	public static MyController mapping(String uri){
		MyController controller = null;
			try {
				Class classes = Class.forName(map.get(uri));
				controller = (MyController) classes.newInstance();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return controller;
	}
}

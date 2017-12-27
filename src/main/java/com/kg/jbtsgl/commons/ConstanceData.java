package com.kg.jbtsgl.commons;

import java.util.HashMap;
import java.util.Map;

public class ConstanceData {
	private static Map<String, Object> map = new HashMap<>();
	
	private static boolean reporting = false;
	
	public static void setIsReporting(){
		reporting = true;
	}
	
	public static void setIsNotReporting(){
		reporting = false;
	}
	
	public static boolean getReporting(){
		return reporting;
	}
	
	
	public static void setMapValue(String key ,Object value){
		if(map.containsKey(key)){
			map.remove(key);
			map.put(key, value);
		}else{
			map.put(key, value);
		}
	}
	
	public static Object getMapValue(String key){
		if(map.containsKey(key)){
			return map.get(key);
		}
		return null;
	}
	
	public static void removeMapValue(String key){
		if(map.containsKey(key)){
			map.remove(key);
		}
	}
	
}

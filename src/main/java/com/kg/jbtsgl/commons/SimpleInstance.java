package com.kg.jbtsgl.commons;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SimpleInstance {
	private static ReadWriteLock lock = new ReentrantReadWriteLock(); 
	private static final Map<String,String> timeZoneMap=new ConcurrentHashMap<String,String>();
	public static final Integer SYSTEM_CONFIG_ID=1;
	
	
	
	private SimpleInstance(){
		
	}
	public static ReadWriteLock getLock(){
		return lock;
	}
	private static class CachFactoryHolder{
	private static SimpleInstance CacheFactory=new SimpleInstance();
	    	
	}
	public static SimpleInstance getInstance(){
	   return CachFactoryHolder.CacheFactory;
	}
	public Map<String,String> getTimeZoneMap(){
	   return timeZoneMap;
	}
}

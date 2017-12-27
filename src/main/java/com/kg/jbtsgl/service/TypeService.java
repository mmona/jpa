package com.kg.jbtsgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kg.jbtsgl.dao.TypeDao;
import com.kg.jbtsgl.pojo.Type;

@Service
public class TypeService extends BaseService {
	@Autowired
	private TypeDao typeDao;
	public List<Type> getType(){
		
		return typeDao.getType();
	}
}

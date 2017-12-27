package com.kg.jbtsgl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.kg.jbtsgl.dao.CommonDao;
public abstract class BaseService {
	@Autowired
	protected CommonDao commonDao;

	protected CommonDao getCommonDao() {
		return commonDao;
	}

	protected void setCmmonDao(CommonDao commonDao) {
		this.commonDao = commonDao;
	}
	
	protected void transactionRollback() throws Exception{
		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		throw new Exception("option database failed, transaction had rollback!");
	}
}

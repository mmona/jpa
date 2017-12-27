package com.kg.jbtsgl.dao;

import java.util.List;

import org.apache.log4j.rolling.SizeBasedTriggeringPolicy;
import org.omg.PortableServer.THREAD_POLICY_ID;
import org.springframework.stereotype.Repository;

import com.kg.jbtsgl.pojo.Type;

@Repository
public class TypeDao extends CommonDao {
	/**
	 * @description  get type
	 * @author quadrangle
	 * @return List
	 */
	public List<Type> getType(){
		String sql="select t from Type t";
		List<Type> query =(List<Type>) this.query(sql);
		/*List<Type> query = this.query(Type.class);*/
		if(query!=null&&!query.isEmpty()){
			return query;
		}
		return null;
	}
}

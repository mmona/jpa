package com.kg.jbtsgl.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.print.attribute.standard.RequestingUserName;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.kg.jbtsgl.pojo.News;
import com.kg.jbtsgl.utils.Page;
import com.mysql.jdbc.StreamingNotifiable;


@Repository
public class NewsDao extends CommonDao {
	/**
	 * @descriptuion get news count 
	 * @author Mona
	 * @param
	 * @return the result of news count 
	 **/
	 public int getcountNews(){
		String sql="select COUNT(nid) from News n";
		List<Object> list = (List<Object>) this.queryByNative(sql);
		System.out.println(list);
	/*	List<Object> list = this.query(sql, null,null, null);*/
		Number number = (Number) list.get(0);
		
			return  number.intValue();
	
			
	}
	 public List<News> selectNews(){
		 String sql="select n from News n order by n.publishtime";
		 List<News> query = (List<News>) this.query(sql);
		 return query;
	 }
	
	/**
	 * @descriptuion delete news by id
	 * @author Mona
	 * @param id
	 * @return  the number of delete
	 **/
/*	@Transactional*/
	@Transactional
	public Integer deleteNewsById(Integer id) throws Exception{
		String sql="delete from News n where n.nid=:id";
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		int native1 = this.execRawSqlByNative(sql, params);
		return native1;
	}
	/**
	 * @description get news by nid
	 * @author Mona
	 * @param nid
	 * @return List
	 */
	public News getNewsInfo(Integer nid){
		String sql="select n from News n where n.nid=:nid";
		Map<String, Object> pramas = CommonDao.BuildParameterMap("nid",nid);
		List<News> query = this.query(sql, News.class, pramas);
		if (query!=null&&!query.isEmpty()) {
			return query.get(0);
		}
		return null  ;
	}
	/**
	 * @description  update news
	 * @author quadrangle
	 * 
	 */
	@Transactional
	public int updateNews(News news) throws Exception{
		String sql="update News n set n.title=:title,n.content=:content,n.tid=:tid,n.publishtime=:publishtime where n.nid=:nid";
		Map<String,Object> params = new HashMap<>();
		params.put("title", news.getTitle());
		params.put("content", news.getContent());
		params.put("tid", news.getTid());
		params.put("publishtime", news.getPublishtime());
		params.put("nid", news.getNid());
		int execRawSql = this.execRawSql(sql, params);
		return execRawSql;
	}
	 /**
	 * @descriptuion get news list page 
	 * @author Mona
	 * @param page 
	 * @return the result of news list page  
	 **/
public List<News> getListNews(Page page){
	List<News> news = this.query(News.class, page.getBeginIndex(), page.getPageSize());
/*	System.out.println(news);*/
	if(news!=null&&!news.isEmpty()){
		return news;
	}
	return null;
}
/**
 * @description get count by tid
 */
	public Integer countNewByTid(Integer tid){
		String sql="select COUNT(n.nid) from News n where n.tid=:tid";
		Map<String, Object> pramas = CommonDao.BuildParameterMap("tid",tid);
	
		List<Object> list = (List<Object>) this.query(sql, pramas);
		Number number = (Number) list.get(0);
		
		return  number.intValue();

	}
/**
 * @description  get newsList page by tid
 */
	
	public List<News> selectNewsByTid(Page page,Integer tid){
		String sql="select n from News n where n.tid=:tid";
		Map<String, Object> pramas = new HashMap<>();
		pramas.put("tid", tid);
		List<News> list = this.query(News.class,page.getBeginIndex(), page.getPageSize(),pramas);
		return list;
	}
 }


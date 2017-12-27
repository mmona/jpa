package com.kg.jbtsgl.service;

import java.util.List;
import java.util.concurrent.LinkedTransferQueue;

import javax.persistence.PersistenceContext;
import javax.transaction.Transaction;
import javax.transaction.TransactionScoped;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kg.jbtsgl.dao.NewsDao;
import com.kg.jbtsgl.dao.UserDao;
import com.kg.jbtsgl.pojo.News;
import com.kg.jbtsgl.utils.Page;
import com.kg.jbtsgl.utils.Result;

@Service
public class NewService extends BaseService{
	@Autowired
	private NewsDao newsDao;
	
	public Result<News> getNewsListPage(int curPage){
		Result<News> result = new Result<>();
		Page page  = new Page();
		int  countNews =newsDao.getcountNews();
		System.out.println(countNews);
		page.setBeginIndex((curPage-1)*10);
		page.setCurrentPage(curPage);
		page.setPageSize(10);
		page.setTotalCount(countNews);
		page.setTotalPage((countNews%10==0)?(countNews/10):(countNews/10+1));
		List<News> news = newsDao.getListNews(page);
		System.out.println(news);
		result.setList(news);
		result.setPage(page);
		return result;
	}
	public Result<News> selectNewsByTid(int curPage,Integer tid) throws Exception{
		Result<News> result = new Result<>();
		Page page  = new Page();
		Integer countNewByTid = newsDao.countNewByTid(tid);
		System.out.println(countNewByTid);
		page.setBeginIndex((curPage-1)*10);
		page.setCurrentPage(curPage);
		page.setPageSize(10);
		page.setTotalCount(countNewByTid);
		page.setTotalPage((countNewByTid%10==0)?(countNewByTid/10):(countNewByTid/10+1));
		List<News> selectNewsByTid = newsDao.selectNewsByTid(page, tid);
		System.out.println(selectNewsByTid);
		result.setList(selectNewsByTid);
		result.setPage(page);
		return result;
	}
	
	public List<News> selectNews(){
		return newsDao.selectNews();
	}
	/*@Transactional
	public boolean deleteNewsById(Integer id) throws Exception{
		return commonDao.delete(id, News.class);
	}*/
	@Transactional
	public boolean deleteNewsById(Integer id) throws Exception{
		Integer deleteNewsById = newsDao.deleteNewsById(id);
		if(deleteNewsById>0){
			return true;
		}
		return false;
	}
	public News getNewsInfo(Integer nid){
		
		return newsDao.getNewsInfo(nid);
	}
	@Transactional
	public boolean updateNews(News news) throws Exception{
	/*	News news2  = newsDao.getNewsInfo(news.getNid());
		if(news2!=null){
			return newsDao.update(news);
		}*/
		int updateNews = newsDao.updateNews(news);
		if(updateNews>0){
			return true;
		}
		return false;
	}
}

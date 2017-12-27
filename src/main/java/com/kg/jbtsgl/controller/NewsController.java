package com.kg.jbtsgl.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.print.attribute.standard.RequestingUserName;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.apache.xmlbeans.impl.xb.xsdschema.impl.PublicImpl;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.kg.jbtsgl.pojo.News;
import com.kg.jbtsgl.pojo.Type;
import com.kg.jbtsgl.utils.Page;
import com.kg.jbtsgl.utils.Result;
import com.mysql.jdbc.StreamingNotifiable;

import javassist.bytecode.Mnemonic;

@Controller
@RequestMapping(value="Manager/News")
public class NewsController extends BaseController{
	@RequestMapping(value="NewsList")
	public ModelAndView newslist(String curPage){
		int cPage = (curPage!=null)?Integer.parseInt(curPage):1;
		Page page =new Page();
		ModelAndView mvAndView = new ModelAndView();
		Result<News> listPage = newService.getNewsListPage(cPage);
		System.out.println(listPage);
		if(listPage!=null ){
			mvAndView.addObject("news",listPage);
			mvAndView.setViewName("NewsList.jsp");
		}
		return mvAndView;
	}
	@RequestMapping(value="selectNews")
	@ResponseBody
	public String  selectNews(){
		ModelAndView mvAndView = new ModelAndView();
		List<News> allNews = newService.selectNews();
		System.out.println(allNews);
		Gson gson = new Gson();
		String  json  = gson.toJson(allNews);
		System.out.println(json);
		return json;
	}
	@RequestMapping(value="newsdelete")
	@Transactional
	public ModelAndView newsdelete(String nid) throws  Exception{
		ModelAndView mvAndView = new ModelAndView();
		boolean isDelete = newService.deleteNewsById(Integer.parseInt(nid));
		if(isDelete){
			mvAndView.setViewName("NewsList.jsp");
		}
		return null;
	}
	@RequestMapping(value="NewsInfo")
	public ModelAndView newsInfo(String nid){
		ModelAndView mvAndView = new ModelAndView();
		News news = newService.getNewsInfo(Integer.parseInt(nid));
		mvAndView.addObject("news", news);
		mvAndView.setViewName("NewsModify.jsp");
		return mvAndView;
	}
	@RequestMapping(value="typeInfo")
	 @ResponseBody
	public  String typeInfo(){
		List<Type> type = typeService.getType();
		System.out.println(type);
		Gson gson = new Gson();
		String  json  = gson.toJson(type);
		System.out.println(json);
		return json;
	}
	@RequestMapping(value="NewsUpdate")
	@ResponseBody
	@Transactional
	public void  NewsUpdate(HttpServletRequest request ,HttpServletResponse response) throws Exception{
		News news =new News();
		String tid = request.getParameter("tid");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String nid = request.getParameter("nid");
		System.out.println(tid+title+content+nid);
		news.setTid(Integer.parseInt(tid));
		news.setTitle(title);
		news.setContent(content);
		news.setNid(Integer.parseInt(nid));
		news.setTitle(title);
		news.setContent(content);
		news.setTid(Integer.parseInt(tid));
		boolean updateNews = newService.updateNews(news);
		System.out.println(updateNews);
		if(updateNews){
			response.getWriter().print("{\"res\": 1, \"info\":\"修改成功\"}");
		}else{
			
			response.getWriter().print("{\"res\": -1, \"info\":\"修改失败\"}");
		}
	}
	@RequestMapping(value="selectNewsByTid")
	public ModelAndView selectNewsByTid(String curPage,String tid) throws Exception{
		ModelAndView mvAndView = new ModelAndView();
		int cPage = (curPage!=null)?Integer.parseInt(curPage):1;
		Page page =new Page();
		System.out.println(Integer.parseInt(tid));
		Result<News> selectNewsByTid = newService.selectNewsByTid(cPage, Integer.parseInt(tid));
		if(selectNewsByTid!=null){
			mvAndView.addObject("news", selectNewsByTid);
			mvAndView.setViewName("List.jsp");
		}
		return mvAndView;
	}
}

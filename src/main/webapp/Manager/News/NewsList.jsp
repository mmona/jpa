<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<base
	href="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Language" content="zh-CN" />

<title>新闻列表</title>
<link href="Manager/Style/Css.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<h3 class="subTitle">新闻资讯</h3>
	<ul class="button">
		<li><a href="News/toAddNews.do">添加新闻</a></li>
	</ul>

	<table width="90%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="table">
		<tr>
			<th width="8%" nowrap="nowrap">序号</th>
			<th nowrap="nowrap">标题</th>
			<th width="15%" nowrap="nowrap">日期</th>
			<th width="12%">修改</th>
			<th width="12%">删除</th>
		</tr>
		<c:forEach items="${news.list}" var="newn">
			<tr>
				<td align="center">${newn.nid}</td>
				<td align="center">${newn.title}</td>
				<td align="center">${newn.publishtime}</td>
				<td align="center"><a href="Manager/News/NewsInfo.do?nid=${newn.nid }">修改</a></td>
				<td align="center"><a href="Manager/News/newsdelete.do?nid=${newn.nid }">删除</a></td>
			</tr>
		</c:forEach>
	</table>

	<table width="90%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="page">
		<tr>
			<td width="50%" align="left">共有${news.page.totalCount }条记录，<span
				style="font-family: 宋体; font-size: 9.0pt; color: black;">第</span><span
				style="font-family: Tahoma; font-size: 9.0pt; color: black;">
					${news.page.currentPage}/${news.page.totalPage} </span><span
				style="font-family: 宋体; font-size: 9.0pt; color: black;">页</span></td>
			<td width="50%" align="right"><c:choose>
					<c:when test="${news.page.currentPage eq 1}">首页</c:when>
					<c:otherwise>
						<a href="Manager/News/NewsList.do">首页</a>
					</c:otherwise>
				</c:choose> <c:choose>
					<c:when test="${news.page.currentPage eq 1 }">上一页</c:when>
					<c:otherwise>
						<a href="Manager/News/NewsList.do?curPage=${news.page.currentPage-1}">上一页</a>
					</c:otherwise>
				</c:choose>
				 <c:choose>
					<c:when test="${news.page.currentPage eq news.page.totalPage }">下一页</c:when>
					<c:otherwise>
						<a href="Manager/News/NewsList.do?curPage=${news.page.currentPage+1 }">下一页</a>
					</c:otherwise>
				</c:choose> <c:choose>
					<c:when test="${news.page.currentPage eq news.page.totalPage }">尾页</c:when>
					<c:otherwise>
						<a href="Manager/News/NewsList.do?curPage=${news.page.totalPage-1 }">尾页</a>
					</c:otherwise>
				</c:choose></td>
	</table>

</body>
</html>

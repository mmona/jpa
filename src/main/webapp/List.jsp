<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<base
	href="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>京博书画网</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Language" content="zh-CN" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta name="Keywords" content="关键字" />
<meta name="Description" content="描述" />
<link rel="stylesheet" href="Style/Main.css" type="text/css" media="screen, projection"/>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<div id="logo"><a href="index.jsp" title="京博书画网">京博书画网</a></div>
		<!--[if !IE]>logo 结束<![endif]-->
		<div class="search">
			<form id="form1" method="post" action="search.jsp">
				<input type="text" name="textfield" id="textfield" class="iText" />
				<input type="submit" name="Submit" class="btn" value="搜索" />
			</form>
		</div>
		<!--[if !IE]>search 结束<![endif]-->
	</div>
	<!--[if !IE]>header 结束<![endif]-->
	<div id="main" class="wrapfix">
		<div id="mostlyCon">
			<div class="newslist">
				<div class="hd"><h3>主要新闻</h3></div>
				<div class="bd">
					<ul class="list">
					<c:forEach items="${news.list}" var="newn">
						<li><span class="category">[${newn.tid }]</span><a href="Info.jsp" target="_blank">${newn.content }</a><span class="date">${newn.publishtime }</span></li>
					</c:forEach>	
					</ul>
				</div>
			</div>
			<!--[if !IE]>newslist 结束<![endif]-->
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
						<a href="Manager/News/selectNewsByTid.do">首页</a>
					</c:otherwise>
				</c:choose> <c:choose>
					<c:when test="${news.page.currentPage eq 1 }">上一页</c:when>
					<c:otherwise>
						<a href="Manager/News/selectNewsByTid.do?curPage=${news.page.currentPage-1}">上一页</a>
					</c:otherwise>
				</c:choose>
				 <c:choose>
					<c:when test="${news.page.currentPage eq news.page.totalPage }">下一页</c:when>
					<c:otherwise>
						<a href="Manager/News/selectNewsByTid.do?curPage=${news.page.currentPage+1 }">下一页</a>
					</c:otherwise>
				</c:choose> <c:choose>
					<c:when test="${news.page.currentPage eq news.page.totalPage }">尾页</c:when>
					<c:otherwise>
						<a href="Manager/News/selectNewsByTid.do?curPage=${news.page.totalPage-1 }">尾页</a>
					</c:otherwise>
				</c:choose></td>
	</table>
			<!--[if !IE]>paging 结束<![endif]-->
		</div>
		<!--[if !IE]>mostlyCon 结束<![endif]-->
		<div id="sideCon">
			<div id="nav">
				<h3>新闻类别</h3>
				<ul>
					<li><a href="list.jsp">news.list.tid</a></li>
			</div>
		</div>
		<!--[if !IE]>sideCon 结束<![endif]-->
	</div>
	<!--[if !IE]>main 结束<![endif]-->
	<div id="footer">
		<p>版权所有 &copy;Mona</p>
	</div>
	<!--[if !IE]>main 结束<![endif]-->
</div>
</body>
</html>
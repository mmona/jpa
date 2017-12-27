<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<base href="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/"> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Language" content="zh-CN" />

<title>新闻类别管理</title>
<link href="../Style/Css.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<h3 class="subTitle">新闻类别</h3>

	<ul class="button">
		<li><a href="Manager/News/CategoryAdd.jsp">添加类别</a></li>
	</ul>

	<form id="form2" name="form2" method="post" action="">
		<table width="90%" border="0" align="center" cellpadding="0"
			cellspacing="0" class="table">
			<tr>
				<th width="8%" nowrap="nowrap">序号</th>
				<th nowrap="nowrap">类别名称</th>
				<th width="12%" nowrap="nowrap">修改</th>
				<th width="12%" nowrap="nowrap">删除</th>
			</tr>
			<c:forEach items="${page.data }" var="type">
				<tr>
					<td align="center">${type.t_id}</td>
					<td align="center">${type.t_name}</td>
					<td align="center"><a href="News/selectTypeById.do?id=${type.t_id}">修改</a></td>
					<td align="center"><a href="News/Categorydelete.do?id=${type.t_id}">删除</a></td>
				</tr>
			</c:forEach>

		</table>
		<table width="90%" border="0" align="center" cellpadding="0"
			cellspacing="0" class="page">
			<tr>
				<td width="50%" align="left">共有${page.rows }条记录，<span
					style="font-family: 宋体; font-size: 9.0pt; color: black;">第</span><span
					style="font-family: Tahoma; font-size: 9.0pt; color: black;">
						${page.curPage}/${page.totalPage} </span><span
					style="font-family: 宋体; font-size: 9.0pt; color: black;">页</span></td>
				<td width="50%" align="right">
				<c:choose>
						<c:when test="${page.curPage eq 1}">[首页]</c:when>
						<c:otherwise>
							<a href="News/CategoryList.do">首页</a>
						</c:otherwise>
					</c:choose> 
						<c:choose>
							<c:when test="${page.curPage eq 1 }">上一页</c:when>
							<c:otherwise>
								<a href="News/CategoryList.do?curPage=${page.curPage-1}">上一页</a>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${page.curPage eq page.totalPage }">下一页</c:when>
							<c:otherwise>
								<a href="News/CategoryList.do?curPage=${page.curPage+1 }">下一页</a>
							</c:otherwise>
						</c:choose>
						<c:choose>
						<c:when test="${page.curPage eq page.totalPage }">尾页</c:when>
						<c:otherwise>
							<a href="News/CategoryList.do?curPage=${page.totalPage-1 }">尾页</a>
						</c:otherwise>
					</c:choose> 
					
				</td>
		</table>
	</form>
</body>
</html>

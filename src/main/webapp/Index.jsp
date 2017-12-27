<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<base
	href="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>京博书画网</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="Content-Language" content="zh-CN" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta name="Keywords" content="关键字" />
<meta name="Description" content="描述" />
<link rel="stylesheet" href="Style/Main.css" type="text/css" media="screen, projection"/>
<script src="/jingbotushuguanli/jquery/jquery-2.2.4.min.js"
	type="text/javascript"></script> 
<script type="text/javascript">
	$(function() {
		selecttype();
		selectNews();
	});
	function selecttype() {
		$.ajax({
			url : "Manager/News/typeInfo.do",
			type : "post",
			dataType : "json",
			success : function(data) {
					$.each(data, function(index, element) {
						$(".type").append($("<li><a href='Manager/News/selectNewsByTid.do?tid="+element.tid+"'>"+element.name+"</a></li>"));
					})
			}
		});
		
	}
	function selectNews(){
		
		$.ajax({
			url : "Manager/News/selectNews.do",
			type : "post",
			dataType : "json",
			success : function(data) {
					$.each(data, function(index, element) {
						$(".list").append($("<li><span class='category'>"+[element.tid]+"</span><a href='selectReviewByNid.do?nid="+element.nid+"' target='_blank'>"+element.title+"</a><span class='date'>"+element.publishtime+"</span></li>"));
					})
			}
		});
		
	}

	</script>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<div id="logo"><a href="index.jsp" title="京博书画网">京博书画网</a></div>
		<!--[if !IE]>logo 结束<![endif]-->
		<div class="search">
			<form id="form1" method="post" action="search.jsp">
				<input type="text" name="textfield" id="textfield" class="iText" />
				<select name="select">
					<option selected="selected">标题</option>
					<option>内容</option>
				</select>
				<input type="submit" name="Submit" class="btn" value="搜索" />
			</form>
		</div>
		<!--[if !IE]>search 结束<![endif]-->
	</div>
	<!--[if !IE]>header 结束<![endif]-->
	<div id="main" class="wrapfix">
		<div id="mostlyCon">
			<div class="newslist">
				<div class="hd"><h3>新闻头条</h3></div>
				<div class="bd">
					<ul class="list">
						
						
					</ul>
				</div>
			</div>
			<!--[if !IE]>newslist 结束<![endif]-->
			<div class="newslist">
				<div class="hd"><h3>热点新闻</h3></div>
				<div class="bd">
					<ul class="list">
					
						
					</ul>
				</div>
			</div>
			<!--[if !IE]>newslist 结束<![endif]-->
		</div>
		<!--[if !IE]>mostlyCon 结束<![endif]-->
		<div id="sideCon">
			<div id="nav">
				<h3>新闻类别</h3>
				<ul class="type">
					
				</ul>
			</div>
		</div>
		<!--[if !IE]>sideCon 结束<![endif]-->
	</div>
	<!--[if !IE]>main 结束<![endif]-->
	<div id="footer">
		<p>版权所有 &copy;by Mona </p>
	</div>
	<!--[if !IE]>main 结束<![endif]-->
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <base
	href="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/">
<%-- 	<%
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ path;
		request.getSession().setAttribute("path", path);
		request.getSession().setAttribute("basePath", basePath);
	%>  --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Language" content="zh-CN" />
<title>修改新闻</title>
<link href="Manager/Style/Css.css" rel="stylesheet" type="text/css" />
<script src="${basePath}/jingbotushuguanli/jquery/jquery-2.2.4.min.js"
	type="text/javascript"></script> 
<script language="javascript">
  /* String.prototype.Trim  =  function()
  {
		return  this.replace(/(^\s*)|(\s*$)/g,"");  
	}
	
	function goto()
	{
		if(check()){
	    	document.form1.submit();
		}
	} */

	function check()
	{
		if(document.all.form1.title.value.Trim()==""){
			alert("请填写标题!");
			return false;
		 }

		 return true;
	}
	
	function back()
	{
		document.all.form1.action="Manager/News/NewsList.do";
		document.form1.submit();
	}
</script>
<script type="text/javascript">
	$(function() {
		selecttype();
	});
	function selecttype() {
		$.ajax({
			url : "Manager/News/typeInfo.do",
			type : "post",
			dataType : "json",
			success : function(data) {
					$.each(data, function(index, element) {
						$("select[name='column']").append($("<option value='"+element.tid+"'>"+element.name+"</option>"));
					})
			}
		});

	}
	function update(){
		var id= $("select[name='column']").val();
		var title=$("input[name='header']").val();
		var nid =$("input[name='nid']").val();
		alert(title);
		var content=$("input[name='text']").val();
		$.ajax({
			url : "Manager/News/NewsUpdate.do",
			type : "POST",
			async: false,
			data : {"tid":id, "title":title,"content":content,"nid":nid},
			dataType : "json",
			success : function(data) {
				if (data.res >= 1){
					alert("添加成功");
				}
				else {
					alert(data.info);
				}
			}
		});
		
		
		
	}
</script>
</head>
<body>
<h3 class="subTitle">修改新闻</h3>

<form id="form1" name="form1" action="#.do">
		<table width="90%" border="0" align="center" cellpadding="0" class="table2" cellspacing="0">
		    <tr>
          <th width="15%" align="right">新闻类别</th>
          <td>
          <input name="nid" type="hidden" class="input1" id="nid"  value="${news.nid }"/>
          	<select name="column">
							
						</select>
					</td>
      	</tr>
		    <tr>
		        <th align="right">文章标题</th>
		        <td><input name="header" type="text" class="input1" id="header" value="${news.title }"/></td>
		    </tr>
		    <tr>
		        <th align="right" valign="top">文章内容</th>
		        <td>
		        	<input name="text" type="text" class="input1" id="text"  value="${news.content }" />
		        	
		        </td>
		    </tr>
		</table>
    <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="yesno">
        <tr>
            <td height="50" align="center">
            	<input type="submit" name="Submit" value="修改"  onclick="update()" />
            	<input type="reset" name="Submit2" value="重置" />
            	<input type="button" name="Submit" value="取消" onclick="back()"/> 
           	</td>
        </tr>
    </table>
</form>
</body>
</html>

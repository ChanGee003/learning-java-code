<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE HTML>
<html>
<head>
    <title>后台管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="stylesheets/dpl-min.css" />
    <link rel="stylesheet" type="text/css" href="stylesheets/bui-min.css" />
    <link rel="stylesheet" type="text/css" href="stylesheets/main-min.css" />
    <script type="text/javascript" src="javascripts/jquery-1.8.1.min.js"></script>
	<script type="text/javascript" src="javascripts/bui-min.js"></script>
	<script type="text/javascript" src="javascripts/common/main-min.js"></script>
	<script type="text/javascript" src="javascripts/config-min.js"></script>
</head>
<body>

<div class="header">

    <div class="dl-title">
        <img src="images/logo2.png">
    </div>

    <div class="dl-log">
    	<span id="sysTime"></span>
    	&nbsp;
    	<span class="dl-log-user">欢迎您，${sessionScope.sessionUser.username }</span><a href="<%=request.getContextPath()%>/logout" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
</div>
<div class="content">
    <%-- <div class="dl-main-nav">
        <div class="dl-inform"><div class="dl-inform-title"></div></div>
        <ul id="J_Nav"  class="nav-list ks-clear">
        	<c:forEach var="node" items="${nodes }" varStatus="status">
        		<c:if test="${node.parentNodeID=='0' }">
	            	<li class="nav-item dl-selected"><div class="nav-item-inner ${node.nodeIcon} }">${node.nodeName }</div></li>		
        		</c:if>
        	</c:forEach>
        </ul>
    </div> --%>
    <ul id="J_NavContent" class="dl-tab-conten">

    </ul>
</div>
<script>
    BUI.use('common/main',function(){
        var config = ${menuNodes};
        new PageUtil.MainPage({
            modulesConfig : config
        });
    });
    
    $(document).ready(function(){
    	getTime();
    	window.setInterval(getTime, 1000);
    });
    
    function getTime(){
    	var date = new Date();
    	var y = date.getFullYear();
    	var m = date.getMonth()+1;
    	var d = date.getDate();
    	var h = date.getHours();
    	var i = date.getMinutes();
    	var s = date.getSeconds();
    	$("#sysTime").html(y+"年"+(m>9?m:("0"+m))+"月"+(d>9?d:("0"+d))+"日 "+(h>9?h:("0"+h))+":"+(i>9?i:("0"+i))+":"+(s>9?s:("0"+s)));
    }
</script>
<div style="text-align:center;">
<p>来源：<a href="http://www.xbsafe.cn" target="_blank">信邦安达</a></p>
</div>
</body>
</html>

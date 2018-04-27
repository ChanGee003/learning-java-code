<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="stylesheets/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="stylesheets/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="stylesheets/style.css" />
<script type="text/javascript" src="javascripts/jquery.js"></script>
<script type="text/javascript" src="javascripts/jquery.sorted.js"></script>
<script type="text/javascript" src="javascripts/bootstrap.js"></script>
<script type="text/javascript" src="javascripts/ckform.js"></script>
<script type="text/javascript" src="javascripts/common.js"></script>

<style type="text/css">
body {
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) {
	/* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
</style>
<script>
    $(function () {
		$('#addnew').click(function(){
			window.location.href="<%=request.getContextPath()%>/addMenu";
		 });
    });
</script>
</head>
<body>
	<form class="form-inline definewidth m20" action="<%=request.getContextPath()%>/searchMenu"
		method="get">
		菜单(节点)名称： <input type="text" name="menuname" id="menuname"
			class="abc input-default" placeholder="" value="">&nbsp;&nbsp;
		<button type="submit" class="btn btn-primary">查询</button>
		&nbsp;&nbsp;
		<button type="button" class="btn btn-success" id="addnew">新增菜单(节点)</button>
	</form>
	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th>主菜单(节点)</th>
				<th>上级菜单(节点)</th>
				<th>菜单(节点)标题</th>
				<th>ACTION</th>
				<th>管理操作</th>
			</tr>
		</thead>
		
		<c:forEach var="menuNode" items="${menuNodes }" varStatus="status">
			<c:if test="${menuNode.parentNodeID=='0' }">
				<tr>
					<td></td>
					<td></td>
					<td>${menuNode.nodeName }</td>
					<td>${menuNode.nodeAction }</td>
					<td><a href="<%=request.getContextPath()%>/editMenu?id=${menuNode.nodeID }">编辑</a></td>
				</tr>				
				<c:forEach var="menuNode1" items="${menuNodes }" varStatus="status">
					<c:if test="${menuNode1.parentNodeID==menuNode.nodeID }">
						<tr>
							<td></td>
							<td>${menuNode.nodeName }</td>
							<td>${menuNode1.nodeName }</td>
							<td>${menuNode1.nodeAction }</td>
							<td><a href="<%=request.getContextPath()%>/editMenu?id=${menuNode1.nodeID }">编辑</a></td>
						</tr>
						<c:forEach var="menuNode2" items="${menuNodes }" varStatus="status">
							<c:if test="${menuNode2.parentNodeID==menuNode1.nodeID }">
								<tr>
									<td>${menuNode.nodeName }</td>
									<td>${menuNode1.nodeName }</td>
									<td>${menuNode2.nodeName }</td>
									<td>${menuNode2.nodeAction }</td>
									<td><a href="<%=request.getContextPath()%>/editMenu?id=${menuNode2.nodeID }">编辑</a></td>
								</tr>
							</c:if>
						</c:forEach>
					</c:if>
				</c:forEach>
			</c:if>
		</c:forEach>
	</table>

</body>
</html>

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
	$(function() {
		$('#addnew').click(function() {
			window.location.href = "<%=request.getContextPath()%>/addRole";
		});
	});
	function del(id) {
		if (confirm("确定要删除吗？")) {
			var url = "index.html";
			window.location.href = url;
		}
	}
	
	
	
</script>
</head>
<body>
	<form class="form-inline definewidth m20" action="<%=request.getContextPath()%>/searchRole" method="get">
		角色名称： <input type="text" name="rolename" id="rolename"
			class="abc input-default" placeholder="" value="">&nbsp;&nbsp;
		<button type="submit" class="btn btn-primary">查询</button>
		&nbsp;&nbsp;
		<button type="button" class="btn btn-success" id="addnew">新增角色</button>
	</form>
	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th>角色ID</th>
				<th>角色名称</th>
				<th>可访问菜单(节点)</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<c:if test="${not empty roles}">
			<c:forEach var="role" items="${roles }" varStatus="status">
				<tr>
					<td>${role.roleID }</td>
					<td>${role.roleName }</td>
					<td>${role.roleMenus }</td>
					<td>
						<c:if test="${role.roleStatus=='1' }"><span style="color: green;">启用</span></c:if>
						<c:if test="${role.roleStatus=='0' }"><span style="color: red;">禁用</span></c:if>
					</td>
					<td><a href="<%=request.getContextPath()%>/editRole?id=${role.roleID}">编辑</a></td>
				</tr>		
			</c:forEach>
		</c:if>
	</table>
</body>
</html>

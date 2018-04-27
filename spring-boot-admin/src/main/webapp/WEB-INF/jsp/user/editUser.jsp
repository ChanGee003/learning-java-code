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
<!-- <script type="text/javascript" src="javascripts/jquery.sorted.js"></script> -->
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
		$('#backid').click(function() {
			window.location.href = "<%=request.getContextPath()%>/user_manage";
		});

	});
</script>
</head>
<body>
	<form action="<%=request.getContextPath()%>/editUser" method="post" class="definewidth m20">
		<input type="hidden" name="id" value="${user.userID }" />
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td width="10%" class="tableleft">登录名</td>
				<td><input type="text" name="username" value="${user.username}" /></td>
			</tr>
			<!-- <tr>
				<td class="tableleft">密码</td>
				<td><input type="password" name="password" /></td>
			</tr> -->
			<tr>
				<td class="tableleft">真实姓名</td>
				<td><input type="text" name="realname" value="${user.realname}" /></td>
			</tr>
			<tr>
				<td class="tableleft">邮箱</td>
				<td><input type="text" name="email" value="${user.email}" /></td>
			</tr>
			<tr>
				<td class="tableleft">状态</td>
				<td>
					<input type="radio" name="status" value="0" <c:if test="${user.status =='0'}">checked</c:if> /> 启用
					<input type="radio" name="status" value="1" <c:if test="${user.status =='1'}">checked</c:if> /> 禁用</td>
			</tr>
			<tr>
				<td class="tableleft">角色</td>
				<td>
					<label><input name="roleID" type="checkbox" value="0"  <c:if test="${user.roleID =='0'}">checked="checked"</c:if>/>管理员 </label>
					<label><input name="roleID" type="checkbox" value="1"  <c:if test="${user.roleID =='1'}">checked="checked"</c:if>/>用户</label>
				</td>
			</tr>
			<tr>
				<td class="tableleft"></td>
				<td>
					<button type="submit" class="btn btn-primary" type="button">保存</button>
					&nbsp;&nbsp;
					<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<form action="<%=request.getContextPath()%>/addUser" method="post" class="definewidth m20">
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td width="10%" class="tableleft">登录名</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td class="tableleft">密码</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td class="tableleft">真实姓名</td>
				<td><input type="text" name="realname" /></td>
			</tr>
			<tr>
				<td class="tableleft">邮箱</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td class="tableleft">状态</td>
				<td><input type="radio" name="status" value="1" checked /> 启用 <input
					type="radio" name="status" value="0" /> 禁用</td>
			</tr>
			<tr>
				<td class="tableleft">角色</td>
				<td>
					<label><input name="roleID" type="checkbox" value="0" />管理员 </label>
					<label><input name="roleID" type="checkbox" value="1" />用户</label>
				</td>
			</tr>
			<tr>
				<td class="tableleft"></td>
				<td>
					<button type="submit" class="btn btn-primary" type="button">保存</button>
					&nbsp;&nbsp;
					<button type="button" class="btn btn-success" name="backid"
						id="backid">返回列表</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>

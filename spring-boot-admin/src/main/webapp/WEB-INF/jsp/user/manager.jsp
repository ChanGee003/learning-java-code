<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="stylesheets/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="stylesheets/bootstrap-table.css" />
<link rel="stylesheet" type="text/css" href="stylesheets/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="stylesheets/style.css" />
<script type="text/javascript" src="javascripts/jquery.js"></script>
<script type="text/javascript" src="javascripts/bootstrap.min.js"></script>
<script type="text/javascript" src="javascripts/bootstrap-table.js"></script>
<script type="text/javascript" src="javascripts/bootstrap-table-zh-CN.js"></script>
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
    	usersTable();
		$('#addUser').click(function(){
			window.location.href="<%=request.getContextPath()%>/addUser";
		 });
    });
	function del(id) {
		if(confirm("确定要删除吗？")) {
			var url = "index.html";
			window.location.href=url;		
		}
	}
	
	function usersTable(){
		$('#usersTable').bootstrapTable('refresh');
        $('#usersTable').bootstrapTable({
            url: "<%=request.getContextPath()%>/users", //请求后台的URL（*）
            method: 'post',
            contentType: "application/x-www-form-urlencoded",
            height: $(window).height() - 50,
            striped: true,
            pagination: true,
            singleSelect: false,
            pageSize: 10,
            pageList: [10, 20, 30, 50, 100],
            sortable: true, //是否启用排序
            sortOrder: "desc", 
            search: false, //不显示 搜索框
            showColumns: false, //不显示下拉框（选择显示的列）
            sidePagination: "server", //服务端请求
            queryParamsType:"",
            queryParams: "",
            minimunCountColumns: 2,
            dataField: "rows",
            dataType: "json",
            columns: [
            	{
                    field: "userId",
                    title: "用户ID",
                    titleTooltip: "用户编号",
                    width: 100,
                    align: 'center',
                    valign: 'middle',
                    sortable: true
                },
                {
                    field: "loginname",
                    title: "登录用户",
                    align: 'center'
                },
                {
                    field: "username",
                    title: "用户名称",
                    align: 'center'
                },
                {
                    field: "rights",
                    title: "用户权限",
                    align: 'center'
                },
                {
                    field: "status",
                    title: "用户状态",
                    align: 'center',
                    formatter:statusFormatter()
                },
                {
                    field: "lastLogin",
                    title: "最后登录时间",
                    align: 'center'
                },
                {
                	title: "操作",
                    align: 'center',
                	events:eventDo,
                	formatter:eventFormatter()
                }
            ],
            locale: "zh-CN",//中文支持,
        });
	}
	
	
	function eventFormatter(value, row, index) {
		return [ '<a class="like" href="javascript:void(0)" title="Like">',
				'<i class="glyphicon glyphicon-user">查看</i>', '</a>  ','&nbsp; ',
				'<a class="remove" href="javascript:void(0)" title="Remove">',
				'<i class="glyphicon glyphicon-remove">删除</i>', '</a>' ].join('');
	}
	function eventFormatter(value, row, index) {
		return [ '<a class="like" href="javascript:void(0)" title="Like">',
				'<i class="glyphicon glyphicon-user">查看</i>', '</a>  ','&nbsp; ',
				'<a class="remove" href="javascript:void(0)" title="Remove">',
				'<i class="glyphicon glyphicon-remove">删除</i>', '</a>' ].join('');
	}
	window.eventDo = {
		'click .like' : function(e, value, row, index) {
			alert('You click like action, row: ' + JSON.stringify(row));
		},
		'click .remove' : function(e, value, row, index) {
			$('#usersTable').bootstrapTable('remove', {
				field : 'userId',
				values : [ row.userId ]
			});
		}
	}
</script>
</head>
<body>
	
	<%-- <form class="form-inline definewidth m20" action="<%=request.getContextPath()%>/searchUser" method="get">
		用户名称： <input type="text" name="username" id="username" class="abc input-default" placeholder="" value="">&nbsp;&nbsp;
		<button type="submit" class="btn btn-primary">查询</button> &nbsp;&nbsp;
		<button type="button" class="btn btn-success" id="addUser">新增用户</button>
	</form> --%>
	
	<table id="usersTable" class="table table-bordered table-hover definewidth m10"></table>


	<%--<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th>用户ID</th>
				<th>登录用户</th>
				<th>用户名称</th>
				<th>用户权限</th>
				<th>用户状态</th>
				<th>最后登录时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<c:if test="${not empty users}">
			<c:forEach var="user" items="${users }" varStatus="status">
				<tr>
					<td>${user.userId }</td> 
					<td>${user.loginname }</td> 
					<td>${user.username }</td>
					<td>${user.rights }</td>
					<td>${user.status }</td>
					<td>${user.lastLogin }</td>
					<td>
						<a href="<%=request.getContextPath()%>/editUser?id=${user.userId }">编辑</a>
						<a href="<%=request.getContextPath()%>/resetUserPassword?id=${user.userId }">重置密码</a>
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</table> --%>
</body>
</html>

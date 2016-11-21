<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jspf/taglibs.jspf"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!--<script type="text/javascript" src="${ctx}/js/base.js"></script>-->
		<link href="${ctx}/css/base.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" href="${ctx}/js/bootstrap/css/bootstrap.min.css">

		<!-- jQuery library -->
		<script src="${ctx}/js/jquery/jquery-1.12.4.min.js"></script>

		<!-- Latest compiled JavaScript -->
		<script src="${ctx}/js/bootstrap/js/bootstrap.min.js"></script>
		<style>
			.container {
				padding-right: 5px;
				padding-left: 5px;
			}
			
			a {
				color: #000;
			}
			
			body {
				font-size: 12px;
			}
		</style>
		<title>管理员页面</title>
	</head>

	<body>
		<div class="container">
			<div class="table-responsive">
				<table class="table">
					<caption style="text-align:center">后台管理系统</caption>
					<tbody>
						<tr>
							<td>用户注册数量</td>
							<td>
								<a href="${ctx}/admin/users/total.xhtml">${users.totalCount}</a>
							</td>
						</tr>
						<tr>
							<td>用户新增数量</td>
							<td>
								<a href="${ctx}/admin/users/new.xhtml">${newusers.totalCount}</a>
							</td>
						</tr>
						<tr>
							<td>问题数量</td>
							<td>
								<a href="${ctx}/admin/questions/total.xhtml">${questions.totalCount}</a>
							</td>
						</tr>
						<tr>
							<td>今日新增问题数量</td>
							<td>
								<a href="${ctx}/admin/questions/new.xhtml">${newquestions.totalCount}</a>
							</td>
						</tr>
						<tr>
							<td>未回答问题数量</td>
							<td>
								<a href="${ctx}/admin/questions/unanswered.xhtml">${unaquestions.totalCount}</a>
							</td>
						</tr>
						<tr>
							<td>今日访问量</td>
							<td>
								<a href="${ctx}/admin/views/today.xhtml">访问量xxx</a>
							</td>
						</tr>
						<tr style="text-align: center">
							<td colspan="2">
								<a href="${ctx}/admin/users/rank.xhtml">用户排名</a>
							</td>
						</tr>
						<tr style="text-align: center">
							<td colspan="2">
								<a href="${ctx}/admin/questions/unanswered.xhtml">未回答问题列表</a>
							</td>
						</tr>
						<tr style="text-align: center">
							<td colspan="2">
								<a href="${ctx}/admin/questions/top.xhtml">历史点击最高问题列表</a>
							</td>
						</tr>
						<tr style="text-align: center">
							<td colspan="2">
								<a href="${ctx}/admin/questions/todaytop.xhtml">今日点击最高问题列表</a>
							</td>
						</tr>
					</tbody>
				</table>
			</div>

		</div>

	</body>

</html>
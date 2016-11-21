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
			.badge {
				background-color: #ddd;
			}
			
			.list-group-item {
				padding: 6px 10px;
			}
			
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
			<div class="panel-group" id="accordion" style="margin-bottom: 55px;margin-top: 55px;">
				<%@include file="/WEB-INF/jspf/admin/queslist.jspf"%>
			</div>
		</div>
	</body>

</html>
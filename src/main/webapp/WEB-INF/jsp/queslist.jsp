<%-- 
    Document   : cities
    Created on : Oct 23, 2014, 2:28:35 PM
    Author     : Colin.You
--%>

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
		<title>问题列表</title>
	</head>

	<body>

		<div class="container">

			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="row">
						<div class="col-xs-6">家长互助</div>
						<div class="col-xs-3">明明妈</div>
						<div class="col-xs-3">[登陆/出]</div>
					</div>
				</div>
			</div>
			<div class="panel-group" id="accordion">
				<c:forEach var="question" items="${data.data}">
					<div class="panel panel-default">
						<div class="panel-heading">
							<a href="${ctx}/questions/${question.id}.xhtml">${question.qtitle}</a>
						</div>

						<div class="panel-body">
							<div class="row">
								<div class="col-xs-3">明明妈</div>
								<div class="col-xs-2">星级</div>
								<div class="col-xs-2">浏览</div>
								<div class="col-xs-5">2016年11月15日</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>

		</div>

	</body>

</html>
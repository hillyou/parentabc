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
		<style>
			.col-xs-2 {
				padding-left: 5px;
				padding-right: 0px;
			}
			
			.col-xs-3 {
				padding-left: 5px;
				padding-right: 0px;
			}
			
			.col-xs-5 {
				padding-left: 0px;
				padding-right: 0px;
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
		<title>问题列表</title>
	</head>

	<body>

		<div class="container">
			<div class="panel panel-default" style="position: fixed;width: 96.5%;z-index:999">
				<div class="panel-body">
					<div class="row">
						<div class="col-xs-6">家长互助</div>
						<div class="col-xs-3">明明妈</div>
						<div class="col-xs-3">
							<a href="#">[登陆/出]</a>
						</div>
					</div>
				</div>
			</div>
			<div class="panel-group" id="accordion" style="margin-bottom: 55px;margin-top: 55px;">

				<c:forEach var="question" items="${data.data}">
					<div class="panel panel-default">
						<div class="panel-heading">
							<a href="${ctx}/questions/${question.id}.xhtml">${question.qtitle}</a>
						</div>

						<div class="panel-footer">
							<div class="row">
								<div class="col-xs-2">明明妈</div>
								<div class="col-xs-2">星级</div>
								<div class="col-xs-3">浏览&nbsp;&nbsp;<span class="badge">39</span></div>
								<div class="col-xs-5">2016年11月15日</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="navbar-fixed-bottom" style="z-index: 999;background-color:white;width: 100%; border-top: solid 1px gainsboro;">
				<ul class="nav nav-tabs" style="width: 100%;">
					<li class="text-muted" style="width: 33%; margin-left: 1%;">
						<a href="#">我要求助</a>
					</li>
					<li class="text-muted" style="width: 33%;">
						<a href="#">我来答疑</a>
					</li>
					<li class="text-muted" style="width: 33%;">
						<a href="#">问题查询</a>
					</li>
				</ul>
			</div>

		</div>

	</body>

</html>
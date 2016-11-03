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
            <c:forEach var="question" items="${data.data}">
                <div class="row">
                    <span><a href="${ctx}/questions/${question.id}.xhtml">${question.qtitle}</a></span>
                </div>
            </c:forEach>
        </div>
    </body>
</html>

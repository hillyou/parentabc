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
        <title>提问</title>
    </head>
    <body>
        <form action="${ctx}/questions/ask.xhtml" method="post">
            <div class="container">
                <div class="row">
                    <input type="text" name="qtitle" placeholder="问题标题">
                </div>
                <div class="row">
                    <textarea rows="10" cols="60" name="qcontent" placeholder="问题详细描述"></textarea>
                </div>
                <div class="row">
                    <input type="hidden" name="creatorId" value="${currentUser}">
                    <input type="submit" value="提交">
                </div>
            </div>
        </form>
    </body>
</html>

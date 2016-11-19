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
        <title>管理员页面</title>
    </head>

    <body>
        <div class="container">
            <div class="panel-group" id="accordion" style="margin-bottom: 55px;margin-top: 55px;">
                <div class="row"><label>用户注册数量:</label><a href="${ctx}/admin/users/total.xhtml">${users.totalCount}</a></div>
                <div class="row"><label>用户新增数量:</label><a href="${ctx}/admin/users/new.xhtml">${newusers.totalCount}</a></div>
                <div class="row"><label>问题数量:</label><a href="${ctx}/admin/questions/total.xhtml">${questions.totalCount}</a></div>
                <div class="row"><label>今日新增问题数量:</label><a href="${ctx}/admin/questions/new.xhtml">${newquestions.totalCount}</a></div>
                <!--<div class="row"><label>今日回答问题数量:</label><a href="${ctx}/admin/questions/answered.xhtml">${users.totalCount}</a></div>-->
                <div class="row"><label>未回答问题数量:</label><a href="${ctx}/admin/questions/unanswered.xhtml">${unaquestions.totalCount}</a></div>
                <div class="row"><a href="${ctx}/admin/users/rank.xhtml">用户排名</a></div>
                <div class="row"><label>今日访问量:</label><a href="${ctx}/admin/views/today.xhtml">今日访问量</a></div>
                <div class="row"><a href="${ctx}/admin/questions/unanswered.xhtml">未回答问题列表</a></div>
                <div class="row"><a href="${ctx}/admin/questions/top.xhtml">历史点击最高问题列表</a></div>
                <div class="row"><a href="${ctx}/admin/questions/todaytop.xhtml">今日点击最高问题列表</a></div>
            </div>
            <div class="navbar-fixed-bottom" style="z-index: 999;background-color:white;width: 100%; border-top: solid 1px gainsboro;">
            </div>

        </div>

    </body>

</html>
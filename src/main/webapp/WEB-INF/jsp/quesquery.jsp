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
        <title>问题查询</title>
    </head>

    <body>

        <div class="container panel-group" id="accordion" style="margin-bottom: 55px;margin-top: 55px;">
            <div class="panel panel-default" style="position: fixed;width: 96.5%;z-index:999">
                <div class="panel-body panel-heading">
                    <div class="row">
                        <div class="col-xs-2"><strong><</strong>返回</div>
                        <div class="col-xs-10">问题查询</div>
                    </div>
                    <div class="row">
                        <form action="" method="post">
                            <div class="col-xs-3">
                                <select name="byType" id="byType">
                                    <option value="byContent" ${query.queryName eq 'byContent'?'selected=selected':''}>按内容</option>
                                    <option value="byName" ${query.queryName eq 'byName'?'selected=selected':''}>按姓名</option>
                                </select>
                            </div>
                            
                            <div class="col-xs-7"><input type="text" id="queryValueId" value="${query.queryValue}"  name="${((empty query.queryName) or (query.queryName eq 'byContent'))?'byContent':'byName'}"/></div>
                            <div class="col-xs-2"><input type="submit" value="查询"/></div>
                        </form>
                    </div>
                </div>
                <div class="panel-group" id="accordion" style="margin-bottom: 55px;margin-top: 55px;">
                    <c:choose>
                        <c:when test="${not empty data.data}">
                            <%@include file="/WEB-INF/jspf/queslist.jspf"%>
                        </c:when>
                        <c:when test="${not empty query}">
                            没有查询到相关问题
                        </c:when>
                        <c:otherwise>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </body>

    <script type="text/javascript">
        $(document).ready(function () {
            $("#byType").on("change", function () {
                $("#queryValueId").attr("name", $(this).val());
            });
        });
    </script>
</html>
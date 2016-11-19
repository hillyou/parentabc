<%-- 
    Document   : message
    Created on : Oct 28, 2014, 3:31:47 PM
    Author     : Colin.You
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jspf/taglibs.jspf"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>消息</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${not empty message}">
                <h1>${message}</h1>
            </c:when>
            <c:when test="${not empty param.message}">
                <h1>${param.message}</h1>
            </c:when>
            <c:otherwise>
                <h1>系统异常</h1>
            </c:otherwise>
        </c:choose>

        <h3><a href="${ctx}/questions.xhtml">返回问题列表</a></h3>
    </body>
</html>

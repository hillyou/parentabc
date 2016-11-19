<%@page contentType="text/html" pageEncoding="UTF-8"%>

<form action="${ctx}/answers/answerques.xhtml" method="post">
    <div class="container">
        <div class="row">
            <textarea rows="5" cols="40" name="acontent" placeholder="内容"></textarea>
        </div>
        <div class="row">
            <input type="hidden" name="Qid" value="${question.id}">
            <input type="hidden" name="creatorId" value="${currentUserId}">
            <input type="submit" value="提交">
        </div>
    </div>
</form>

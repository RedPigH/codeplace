<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Read</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h2>No : ${Question.oid}</h2>
    <div class="form-group">
        <label>TITLE: ${Question.title}</label>
    </div>
    <div class="form-group">
        <label>Writer: ${Question.user.name}</label>
    </div>
    <div class="form-group">
        <label>VIEW: ${Question.viewcnt}</label>
    </div>
    <div class="form-group">
        <label>LIKE: ${Question.likecnt}</label>
    </div>
    <div class="form-group">
        <label>CMT: ${Question.cmtcnt}</label>
    </div>
    <div class="form-group">
        <label>REPORT: ${Question.reportcnt}</label>
    </div>
    <div class="form-group">
        <label>TAG: ${Question.tag}</label>
    </div>
    <div class="form-group">
        <label>contents:</label>
        <textarea rows="20" cols="100" id="d.contents" readonly="readonly">${Question.contents}</textarea>
    </div>
    <div class="form-group">
        <label class="form">Created Time : ${Question.createdat} </label>
        <label class="form">Modified Time : ${Question.lastmodifiedat} </label>
    </div>
    <div>
        <a href="/questions/list"><button type="button" class="btn btn-info">Move to List</button></a>
        <a href="/questions/modify/${Question.oid}"><button type="button" class="btn btn-success">Update</button></a>
        <button type="button" id="deleteQuestion" class="btn btn-danger">Delete</button>
    </div>
</div>
<div class="container">
    <tbody>
    <c:forEach var="comment" items="${CommentList}">
        <tr>
            <td>${comment.creatoroid }</td>
            <td>${comment.contents}</td>
            <td>${comment.createdat}</td>
            <td>${comment.modifiedat}</td>
            <a href="/comment/delete-comment/${comment.oid}"><button type="button" class="btn btn-info">delete comment</button></a>
        </tr>
    </c:forEach>
    </tbody>
</div>
<form action="/comment/write-comment/${Question.oid}" method="post">
<%--    <input type="hidden" value="${Question.oid }" name="targetoid">--%>
    <div class="form-group">
        <label>contents:</label>
        <textarea rows="5" cols="50" id="contents"
                  placeholder="Enter contents" name="contents"></textarea>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
<script type="text/javascript">
    $("#deleteQuestion").click(function(){
        var result = confirm("Do you really want to delete your Board?");
        if(result){
            location.href = '/questions/delete/${Question.oid}';
        }
    });
</script>
</html>
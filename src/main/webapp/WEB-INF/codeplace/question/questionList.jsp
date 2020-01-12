<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Simple Spring Boot Board</title>
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
    <h2>Simple Spring Boot Board</h2>
    <p>TEST Simple Board</p>
    <div>
        <a href="/questions/create"><button type="button"
                                        class="btn btn-primary">Create</button></a>
    </div>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>OID</th>
            <th>TITLE</th>
            <th>DOCTYPE</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="question" items="${questionList.content}">
            <tr>
                <td>${question.oid }</td>
                <td><a href="/questions/view/${question.oid}">${question.title}</a></td>
                <td>${question.doctype}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <ul class="pager">
        <c:if test="${!question.first}">
            <li class="previous">
                <a href="?page=${question.number-1}">&larr; Newer Posts</a>
            </li>
        </c:if>
        <c:if test="${!question.last}">
            <li class="next">
                <a href="?page=${postPage.number+1}">Older Posts &rarr;</a>
            </li>
        </c:if>
    </ul>
</div>
</body>
</html>
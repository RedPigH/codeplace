<%@ page import="com.spring.codeplace.user.Entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.spring.codeplace.admin.pageMaker.PageMaker" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>관리자 페이지</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>

<h3>관리자 페이지 일반 유저 리스트</h3>

<!-- 네비게이션 -->
<div>
    <table>
        <thead>
        <tr>
            <td><a href="/adminBlackList"> 블랙 유저 리스트 </a></td>
            <td><a href="/adminCommentList"> 문의 사항 리스트 </a></td>
            <td><a href="/adminUserSearch"> 유저 검색 창 </a></td>
        </tr>
        </thead>
    </table>
</div>
<hr>

<div>

    <!-- 일반 리스트 -->
    <table>
        <thead>
        <tr>
            <th>OID</th>
            <th>ACCCOUNT</th>
            <th>NAME</th>
            <th>GRADE</th>
            <th>REPORTCNT</th>
        </tr>
        </thead>

        <%
            List<User> sessionList = (List) session.getAttribute("userList");
            pageContext.setAttribute("userList", sessionList);
        %>

        <tbody>
        <c:forEach var="users" items="${userList}">
            <tr>
                <td><span>${users.getOid()}</span></td>
                <td><a href="/adminUserInfo?oid=${users.getOid()}">${users.getAccount()}</a></td>
                <td><span>${users.getName()}</span></td>
                <td><span>${users.getGrade()}</span></td>
                <td><span>${users.getReportcnt()}</span></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>


    <!-- 페이지 번호    -->

    <%
        PageMaker pageMaker = (PageMaker) session.getAttribute("pageMaker");
        pageContext.setAttribute("pageMaker", pageMaker);
    %>

    <c:if test="${pageMaker.isPrev()}">
        <a href="/adminUserList?pageNum=${pageMaker.getStartPage()}">&laquo;</a>
    </c:if>
    <c:forEach var="pageNum" items="${pageMaker.getCountlist()}">
        &nbsp;<a href="/adminUserList?pageNum=${pageNum}">${pageNum}</a>&nbsp;
    </c:forEach>
    <c:if test="${pageMaker.isNext()}">
        <a href="/adminUserList?pageNum=${pageMaker.getEndPage()}">&raquo;</a>
    </c:if>

</div>
</body>
</html>


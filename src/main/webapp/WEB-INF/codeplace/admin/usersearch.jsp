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

<h3>관리자 페이지 유저 검색</h3>

<!-- 검색창 -->
<div>
    <form action="/adminUserSearch" method="get" >
        <input name="accountPart" type="text"/>
        <input type="submit" value="검색"/><br><br>
    </form>
</div>

<!-- 네비게이션 -->
<div>
    <table>
        <thead>
        <tr>
            <td><a href="/adminUserList">  모든 유저 리스트  </a></td>
            <td><a href="/adminBlackList">  블랙 유저 리스트  </a></td>
            <td><a href="/adminCommentList">  문의 사항 리스트  </a></td>
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
            List<User> sessionList = (List) session.getAttribute("searchList");
            pageContext.setAttribute("searchList", sessionList);
        %>

        <tbody>
        <c:forEach var="users" items="${searchList}">
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
        String accountPart = (String) session.getAttribute("accountPart");
        pageContext.setAttribute("accountPart", accountPart);
    %>

    <c:if test="${pageMaker.isPrev()}">
        <a href="/adminUserSearch?pageNum=${pageMaker.getStartPage()}&accountPart=${accountPart}">&laquo;</a>
    </c:if>
    <c:forEach var="pageNum" items="${pageMaker.getCountlist()}">
        &nbsp;<a href="/adminUserSearch?pageNum=${pageNum}&accountPart=${accountPart}">${pageNum}</a>&nbsp;
    </c:forEach>
    <c:if test="${pageMaker.isNext()}">
        <a href="/adminUserSearch?pageNum=${pageMaker.getEndPage()}&accountPart=${accountPart}">&raquo;</a>
    </c:if>

</div>
</body>
</html>


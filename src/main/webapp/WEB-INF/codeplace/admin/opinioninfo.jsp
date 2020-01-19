<%@ page import="com.spring.codeplace.admin.entity.Opinion" %>
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

<h3>관리자 페이지 문의 사항 정보</h3>

<!-- 네비게이션 -->
<div>
    <table>
        <thead>
        <tr>
            <td><a href="/adminUserList">  모든 유저 리스트  </a></td>
            <td><a href="/adminBlackList">  블랙 유저 리스트  </a></td>
            <td><a href="/adminCommentList">  문의 사항 리스트  </a></td>
            <td><a href="/adminUserSearch">  유저 검색 창  </a></td>
        </tr>
        </thead>
    </table>
</div>
<hr>

<div>

    <!-- 유저 정보 -->
    <%
        Opinion opinion = (Opinion)session.getAttribute("opinion");
        pageContext.setAttribute("opinion", opinion);
    %>

    <table>
        <thead>
        <th>
            <tr>
                <td><span>OID : </span> <span>${opinion.getOid()}</span></td>
            </tr>
            <tr>
                <td><span>ACCOUNT : </span> <span>${opinion.getAccount()}</span></td>
            </tr>
            <tr>
                <td><span>TITLE : </span> <span>${opinion.getTitle()}</span></td>
            </tr>
            <tr>
                <td><span>CONTENT : </span><br> <textarea readonly>${opinion.getContent()}</textarea></td>
            </tr>
        </th>
        </thead>
    </table>

</div>
</body>
</html>


<%@ page import="com.spring.codeplace.user.Entity.User" %>
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

<h3>관리자 페이지 일반 유저 정보</h3>

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
        User user = (User)session.getAttribute("user");
        pageContext.setAttribute("user", user);
    %>

    <table>
        <thead>
        <th>
            <tr>
                <td><span>OID : ${user.getOid()}</span></td>
            </tr>
            <tr>
                <td><span>ACCOUNT : ${user.getAccount()}</span></td>
            </tr>
            <tr>
                <td><span>NAME : ${user.getName()}</span></td>
            </tr>
            <tr>
                <td><span>NICKNAME : ${user.getNickname()}</span></td>
            </tr>
            <tr>
                <td><span>GRADE : ${user.getGrade()}</span></td>
            </tr>
            <tr>
                <td><span>GENDER : ${user.getGender()}</span></td>
            </tr>
            <tr>
                <td><span>E-MAIL : ${user.getEmail()}</span></td>
            </tr>
            <tr>
                <td>REPORTCNT : ${user.getReportcnt()}</td>
            </tr>
        </th>
        </thead>
    </table>

</div>
</body>
</html>


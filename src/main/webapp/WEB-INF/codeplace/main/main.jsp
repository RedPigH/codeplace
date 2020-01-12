<%@ page contentType="text/html;charset=utf-8"%>
<html>
<body>
<% out.println("hello jsp");%>
<%String a = "hello";%>
<%=a%>
<%
    for(int i = 0; i <= 10; i++){
        out.println("Hello World" + i + "<br/>");
    }
%>
<% for ( int j = 0; j <= 10; j++){%>
<%=j%><br/>
<%}%>
</body>
</html>
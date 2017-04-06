<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Public page</title>
</head>
<body>
    <h1>This is public JSP</h1>
    <h3>Today is <%=new Date()%></h3>
    <h3>Msg Parameter: ${param.msg}</h3>
    <h3>2 + 3 = ${2 + 3}</h3>
    <h3>5 > 10 ? ${5 > 10}</h3>
</body>
</html>

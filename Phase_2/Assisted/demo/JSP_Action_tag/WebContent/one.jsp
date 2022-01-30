<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>one.jsp</title>
    </head>
    <body>
        <h1>Entering one</h1>
        <jsp:forward page="two.jsp">
            <jsp:param name="msg" value="Hello World"/>
        </jsp:forward>
        <h1>Leaving one</h1>
    </body>
</html>


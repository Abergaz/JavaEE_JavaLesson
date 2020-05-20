<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- Комментарий в стиле HTML -->
<%-- Комментарий в стиле JSP --%>

<%-- переопределении методов init и destroy для  JSP --%>
<%!
    public void jspInit(){
        System.out.println("initializing jsp");
    };
    public void jspDestroy(){
        System.out.println("destroy jsp");
    };
%>

</body>
</html>

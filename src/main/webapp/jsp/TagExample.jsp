<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- подключаем дескриптор с кастомными тегами к данной jsp  --%>
<%@ taglib prefix="MyTagLib" uri="/WEB-INF/tld/MyTagDescriptor.tld" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%-- используем кастомный тег,
    сначала имя-ссылка на описание потом имя тега --%>
    <MyTagLib:MyTag name="Max"/>
</body>
</html>

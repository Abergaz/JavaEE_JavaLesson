<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- подключаем дескриптор с кастомными тегами к данной jsp  --%>
<%@ taglib prefix="MyTag" uri="/tld/MyTagDescriptor.tld" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%-- используем кастомный тег,
    сначала имя-ссылка на описание потом имя тега --%>
    <MyTag:MyTag name="Max"/>
</body>
</html>

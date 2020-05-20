<%-- Все JSP страницы компилируются в сервлеты --%>
<%-- Можно указывать множество @ page директив таких как :--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Заголовок</title>
</head>
<body>
<!-- Комментарий в стиле HTML -->
<%-- Комментарий в стиле JSP --%>

<%-- обращение к бину через Expression language сразу по имени --%>
${person.name}
<br>
${person.age}
<br>

<%-- или можно доставать бины прямо из нужного scope(request, session, apliaction --%>
<%-- напряму к обьету обращаемся --%>
${requestScope.person.name}
<br>
<%-- или достаем оьект по имени и берем свойство--%>
${requestScope.get("person").age}
<br>
<%-- обращение  к листу или мапе--%>
${list}
<br>
${list[1]}

</body>
</html>

<%-- Все JSP страницы компилируются в сервлеты --%>
<%-- Можно указывать множество @ page тиректив такких как :--%>
<%-- импорт JAVA класснов из пакетов--%>
<%@ page import="java.util.Date" %>
<%-- тип конетента, язык --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- включать или отключать сессию --%>
<%@ page session="false" %>
<%-- указать перенапрвление на страничку ошибок --%>
<%@ page errorPage="Error.jsp(html) и т.д." %>
<%-- укзать от какого класса наследуется сервлет, компилируемый из данной JSP --%>
<%@ page extends="MyHttpServlet" %>
<%-- и т.д. --%>

<html>
  <head>
    <title>Заголовок</title>
  </head>
  <body>
  <!-- Комментарий в стиле HTML -->
  <%-- Комментарий в стиле JSP --%>

  <%-- доступ к раздичным обьектам --%>

</html>

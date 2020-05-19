<%-- импорт JAVA класснов из пакетов--%>
<%@ page import="java.util.Date" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Заголовок</title>
  </head>
  <body>
  <!-- Комментарий в стиле HTML -->
  <%-- Комментарий в стиле JSP --%>

  <%-- доступ к раздичным обьектам --%>
  <%= request.getMethod()%>
  <% response.setStatus(HttpServletResponse.SC_OK); %>
  <%= session.getAttribute("nameAttribute")%>
  <%= application.getAttribute("nameAttribute")%>
  <%= application.getServerInfo()%>
  <%= application.getServletContextName()%>
  <%=config.getServletContext().getServerInfo()%>
  </body>
</html>

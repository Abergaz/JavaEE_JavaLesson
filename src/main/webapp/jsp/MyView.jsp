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
  <%-- во View получаем данные из контроллера и отображаем их --%>
  <jsp:useBean id="person1" class="ee.bean.Person" scope="request"></jsp:useBean>
  <jsp:useBean id="person2" class="ee.bean.Person" scope="session"></jsp:useBean>
  <jsp:useBean id="person3" class="ee.bean.Person" scope="application"></jsp:useBean>

  <jsp:getProperty name="person1" property="name"/>
  <jsp:getProperty name="person2" property="name"/>
  <jsp:getProperty name="person3" property="name"/>

  </body>
</html>

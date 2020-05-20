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
  <%-- подключаем bean, указываем id - это то как к нему обращаться и класс
       у бина есть области видимости:
       page - только на этой странице
       request - эта страницк+заинклюженные и форварденные
       session - все странцы в рамках работы сессии
       application - все странцы в рамках приложения, везе везде, самый широкий доступ
  --%>
  <%-- можно укзать тип type, например интерфейс,
   тогда будет создан обьект типа интерфейс, с реализацией указанного в class--%>
  <jsp:useBean id="person" class="ee.bean.Person" scope="request"></jsp:useBean>
  <%-- используем bean устанавливаем значения --%>
  <jsp:setProperty name="person" property="name" value="Макс"/>
  <jsp:setProperty name="person" property="age" value="18"/>
  <%--берем значение из bean, будет выведено на страницу --%>
  <jsp:getProperty name="person" property="name"/>
  <br>
  <jsp:getProperty name="person" property="age"/>


  <%-- в параметры можно подавать java переменные и резульат работы кода --%>
  <%! int age=25; %>
  <jsp:setProperty name="person" property="age" value="<%= age %>"/>
  <br>
  <jsp:getProperty name="person" property="age"/>


  <%-- в параметры можно ,брать из запроса --%>
  <jsp:setProperty name="person" property="age" value="<%= request.getParameter("name") %>"/>
</html>

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


  <%-- Вставляем JAVA код в JSP страницу --%>

  <%-- деклаативный код, начинается с <%! для обьявления переменных и ф-ий --%>
  <%! int i=5;%>
  <%! private void doJob(){
     System.out.println("hello");
  }%>
  <br>
  <%-- expression код, код который возвращает стринг, начинается с <%= --%>
  <%= "hello world"%>
  <br>
  <%-- можно возвращать результат работы выражений или ф-ций и т.д, главное чтобы рез. преобразовывался в строку --%>
  <%= i+1+3%>
  <br>
  <%= new Date()%>
  <br>
  <%-- scriptlet - код который встривается непосредственно в страницу, вложенный код начинается с <% --%>
  <%
    class Student {
      String name;
      public Student(String name) {
        this.name = name;
      }
      public String getName() {
        return name;
      }
      public void setName(String name) {
        this.name = name;
      }
    }
  %>
  <%= new Student("Serg").getName()%>
  <br>
  <% if (Math.random()*10>5){ %>
      <b>"if Math.random"</b>
  <% } %>
  <% doJob();%>
  </body>
</html>

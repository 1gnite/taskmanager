<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<tiles:insertDefinition name="page">
  <tiles:putAttribute name="page.title" value="Tasks: Авторизация"/>
  <tiles:putAttribute name="page.content">
      <p>Введите данные:</p>
        <c:url var="check" value="/security_check"/>
        <form:form action="${check}" method="post">
            <table cellspacing="0">
                <tr>
                    <td><label for="username_input">Логин:</label></td>
                    <td><input type="text" id="username_input" name="username"/></td>
                </tr>
                <tr>
                    <td><label for="userpassword_input">Пароль:</label></td>
                    <td><input type="password" id="userpassword_input" name="password"/></td>
                </tr>
                <tr>
                    <td><label for="remember_me_input">Запомнить:</label></td>
                    <td><input type="checkbox" id="remember_me_input" name="_spring_security_remember_me"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Вход"/></td>
                </tr>
            </table>
        </form:form>
  </tiles:putAttribute>
</tiles:insertDefinition>
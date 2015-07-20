<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<tiles:insertDefinition name="page">
  <tiles:putAttribute name="page.title" value="Tasks: Новый пользователь"/>
  <tiles:putAttribute name="page.content">
      <p>Введите данные:</p>
      <c:url var="check" value="/security_check"/>
      <form:form method="post"  modelAttribute="userForm" cssStyle="width: 98%; margin-left: 5px;">
          <table>
              <tr>
                  <td>Логин: </td>
                  <td>
                      <sf:input path="login" size="20" maxlength="32" id="user_login"/>
                      <sf:errors path="login" cssClass="error"/>
                      <sf:errors id="alreadyExistError" cssClass="error"/></td>
              </tr>
              <tr>
                  <td>Пароль: </td>
                  <td>
                      <sf:password path="password" size="20" maxlength="32" id="user_password"/>
                      <sf:errors path="password" cssClass="error"/>
                  </td>

              </tr>
              <tr>
                  <td>Почта: </td>
                  <td>
                      <sf:input path="email" size="20" maxlength="255" id="user_email"/>
                      <sf:errors path="email" cssClass="error"/>
                  </td>

              </tr>
              <tr>
                  <td></td>
                  <td><input type="submit" value="Регистрация"></td>
              </tr>
          </table>
      </form:form>
      &nbsp;
  </tiles:putAttribute>
</tiles:insertDefinition>


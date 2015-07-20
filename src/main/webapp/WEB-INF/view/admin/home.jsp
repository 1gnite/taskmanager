<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<tiles:insertDefinition name="page">
  <tiles:putAttribute name="page.title" value="Tasks: Сервисная панель"/>
  <tiles:putAttribute name="page.content">
    <div id="content" class="centerBar">
        <table>
            <thead>
            <tr>
                <th>
                    Имя пользователя
                </th>
                <th>
                    Адрес почты
                </th>
                <th>
                    Уровень доступа
                </th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${userList}">
                <tr>
                    <td>${user.login}</td>
                    <td>${user.email}</td>
                    <td>${user.role}</td>
                    <td></td>
                    <td>
                        <spring:url var="delUserUrl" value="/admin/users/{userLogin}?delete">
                            <spring:param name="userLogin" value="${user.login}" />
                        </spring:url>
                        <c:url var="delIconUrl" value="/resources/img/delicon.png"/>
                        <a href="${delUserUrl}"><img src="${delIconUrl}"/></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
      <ul>
      </ul>
    </div>
  </tiles:putAttribute>
</tiles:insertDefinition>
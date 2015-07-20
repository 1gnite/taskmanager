<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="security"  uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="header">
    <div id="header-menu-wrapper">
        <c:url var="managerUrl" value="/tasks/"/>
        <ul id="header-menu">
            <li><a href="#">Главная</a></li>
            <li><a href="${managerUrl}">Менеджер</a></li>
            <li><a href="#">О ресурсе</a></li>
        </ul>
    </div>

    <div id="header-account-wrapper">
        <security:authorize access="!isAuthenticated()">
            <c:url var="anonymPic" value="/resources/img/anonym.png"/>
            <div id="userpic"><img src="${anonymPic}"/></div>
                <div id="userform">
                    <c:url var="check" value="/security_check"/>
                    <form:form action="${check}" method="post" cssStyle="display: inline-block;">
                        <input type="text" name="username" size="20" placeholder="Логин" required/>
                        <input type="password" name="password" size="20" placeholder="Пароль" required/>
                        <%--<button type="submit">Войти</button>--%>
                        <input type="submit" id="sumbit" value="Войти"/>
                        <c:url var="registerUrl" value="/register"/>
                        <br/><small><a href="#">Вспомнить пароль</a></small> | <small><a href="${registerUrl}">Регистрация</a></small>
                </div>
                </form:form>
        </security:authorize>
        <security:authorize access="isAuthenticated()">
        <c:url var="anonymPic" value="/resources/img/anonym.png"/>
        <div id="userpic"><img src="${anonymPic}"/></div>
        <div id="userform">
            <c:url var="logoutUrl" value="/logout"/>
            <security:authentication var="login" property="principal.username"/>
            Вы зашли как ${login}. Настройки |
            <security:authorize access="hasRole('ROLE_ADMIN')">
                <c:url var="adminUrl" value="/admin/"/>
                <a href="${adminUrl}">Панель администратора</a>
            </security:authorize>
            <form action="${logoutUrl}" method="post" id="logoutForm" style="display: inline;">
                <input type="hidden"
                       name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>
                <input type="submit" value="Выход"/>
            </form>
        </div>
        </security:authorize>
    </div>
</div>


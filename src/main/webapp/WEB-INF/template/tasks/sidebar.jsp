<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="content-left-bar">
    <ul>
        <c:forEach var="category" items="${categoryList}">
            <li><a href="">${category.title}</a>
                <ul>
                    <c:if test="${category.childs.size() != 0}">
                        <c:forEach var="child" items="${category.childs}">
                            <li><a href="">${child.title}</a></li>
                        </c:forEach>
                    </c:if>
                    <spring:url var="createCategoryUrl" value="/tasks/category/new?id={parentId}">
                        <spring:param name="parentId" value="${category.id}"/>
                    </spring:url>
                    <li><a href="${createCategoryUrl}">Создать...</a></li>
                </ul>
            </li>
        </c:forEach>
        <c:url var="createRootCategoryUrl" value="/tasks/category/new"/>
        <li><a href="${createRootCategoryUrl}">Создать...</a></li>
    </ul>
</div>
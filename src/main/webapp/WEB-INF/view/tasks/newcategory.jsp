<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<tiles:insertDefinition name="tasks.page">
    <tiles:putAttribute name="page.title" value="Tasks: Создание категории"/>
    <tiles:putAttribute name="tasks.content" cascade="true">

        <c:url var="createPostForm" value="/tasks/category/new"/>
        <s:form action="${createPostForm}" method="post">
            <c:choose>
                <c:when test="${parentCategory != null}">
                    <input type="hidden" name="parentId" value="${parentCategory.id}"/>
                    Создать подраздел в разделе ${parentCategory.title} :
                </c:when>
                <c:otherwise>
                    <input type="hidden" name="parentId" value="0"/>
                    Создать корневой раздел :
                </c:otherwise>
            </c:choose>
            <input type="text" name="categoryName" placeholder="Название"/>
            <input type="submit" value="Создать">

        </s:form>
    </tiles:putAttribute>
</tiles:insertDefinition>
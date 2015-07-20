<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<tiles:insertDefinition name="tasks.page">
    <security:authentication var="login" property="principal.username"/>
    <tiles:putAttribute name="page.title" value="Tasks: ${login}"/>
    <tiles:putAttribute name="tasks.content" cascade="true">
        <table class="division" border="1" width="800">
            <tr>
                <td bgcolor="red">&nbsp;</td>
                <td>Задание</td>
                <td>Дата</td>
            </tr>
            Will be done soon
        </table>
    </tiles:putAttribute>
</tiles:insertDefinition>
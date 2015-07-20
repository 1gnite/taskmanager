<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<tiles:insertAttribute name="tasks.topbar"/>
<div id="content-bodycontent">
    <tiles:insertAttribute name="tasks.sidebar"/>
    <div id="content-right-bar">
        <tiles:insertAttribute name="tasks.content"/>
    </div>
</div>
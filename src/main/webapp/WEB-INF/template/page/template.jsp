<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <c:url var="styles" value="/resources/stylesheet.css"/>
    <link type="text/css" rel="stylesheet" href="${styles}"/>
    <title><tiles:getAsString name="page.title"/></title>
</head>
<body>
<div id="bodyWrapper">
    <tiles:insertAttribute name="page.header"/>
    <div id="content">
        <tiles:insertAttribute name="page.content"/>
    </div>
</div>
<tiles:insertAttribute name="page.footer"/>
</body>
</html>

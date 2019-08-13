<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="../../resources/static-content/header.jsp"/>
<link rel="stylesheet" href="../../resources/css/start-page-css.css"/>
<link rel="stylesheet" href="webjars/bootstrap/4.1.0/css/bootstrap.min.css"/>
<link rel="stylesheet" href="webjars/jquery/3.4.1/jquery.min.js"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<hr>
<div class="start-menu">
    <li><a class="button" href="#">Моя меню</a></li>
    <li><a class="button" href="foods">Еда</a></li>
    <li><a class="button" href="to-create">Создать меню</a></li>
</div>
</body>
</html>

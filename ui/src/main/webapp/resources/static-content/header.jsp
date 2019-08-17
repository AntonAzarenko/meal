<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="resources/css/header.css"/>
<link rel="stylesheet" href="webjars/font-awesome/5.10.1/css/all.css" type="text/css">


<nav class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow">
    <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">Meal</a>
    <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
    <c:if test="${login == null}">
        <ul class="navbar-nav px-3">
            <li class="nav-item text-nowrap">
                <a class="nav-link"  onclick="reg1()">Sign in</a>
            </li>
        </ul>
        <ul class="navbar-nav px-3">
            <li class="nav-item text-nowrap">
                <a class="nav-link"  onclick="log_in()">Log in</a>
            </li>
        </ul>
    </c:if>
    <c:if test="${login != null}">
        <ul class="navbar-nav px-3">
            <li class="nav-item text-nowrap">
                <a class="nav-link" href="logout">LogOut</a>
            </li>
        </ul>
    </c:if>
</nav>

<div class="dws-menu context-menu">
    <ui class="dws-ul">
        <li class="dws-li nav-link"><a href="start"><i class="fa fa-home" aria-hidden="true"></i>Главная</a></li>
        <li class="dws-li"><a href="to-create"><i class="fa fa-bars" aria-hidden="true"></i>Создать меню</a></li>
        <li class="dws-li"><a href="foods"><i class="fa fa-apple-alt" aria-hidden="true"></i>Еда</a></li>
        <li class="dws-li"><a href="#"><i class="fa fa-server" aria-hidden="true"></i>Профиль</a></li>
        <li class="dws-li"><a href="#"><i class="fa fa-calculator" aria-hidden="true"></i>Калькулятор каллорий</a></li>
    </ui>
</div>

<script type="text/javascript" src="resources/js/registration.js" defer></script>
<script type="text/javascript" src="webjars/jquery/3.4.1/jquery.min.js" defer></script>
<script type="text/javascript" src="webjars/bootstrap/4.1.0/js/bootstrap.min.js" defer></script>
<script type="text/javascript" src="/webjars/datatables/1.10.16/js/jquery.dataTables.min.js" defer></script>
<script type="text/javascript" src="/webjars/datatables/1.10.16/js/dataTables.bootstrap.min.js" defer></script>
<script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.18/b-1.5.2/b-html5-1.5.2/datatables.min.js" defer></script>


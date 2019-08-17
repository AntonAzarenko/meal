<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../../resources/static-content/header.jsp"/>
<link rel="stylesheet" href="resources/css/start-page-css.css"/>
<link rel="stylesheet" href="webjars/font-awesome/5.10.1/css/all.css" type="text/css">
<link rel="stylesheet" href="webjars/bootstrap/4.1.0/css/bootstrap.min.css"/>
<link rel="stylesheet" href="webjars/jquery/3.4.1/jquery.min.js"/>

<div class="row" style="padding: 10px 0 0 50px">
    <div class="jumbotron col-3">
        <div class="">
            <div>
                <form method="get" class="form-control" action="getMenuNames/">
                    <div class="row">
                        <div class="col-10">
                        <select class="form-control" name="foodId">
                            <c:forEach items="${menu}" var="title">
                                <option selected="" name="titleOfMenu" value="${title.toString()}">${title.toString()}</option>
                            </c:forEach>
                        </select>
                            <var d="titleOfMenu"/>
                        </div>
                        <div class="col-">
                            <button class="" type="submit"><i class="fa fa-address-book" aria-hidden="true"></i></button>
                        </div>
                    </div>
                </form>
            </div>
            <form method="post" class="form-control" action="addFoodToMenu/">
                <div class="">
                    <%--<div class="select">
                        <input type="text" class="form-control" placeholder="Название меню" value="${}"
                               name='setTitle'>
                    </div>--%>
                    <div class="select">
                        <select class="form-control" name="foodId">
                            <c:forEach items="${foods}" var="food">
                                <option value="${food.id}">${food.title}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="select">
                        <select class="form-control" name="dayId">
                            <c:forEach items="${days}" var="day">
                                <option value="${day.id}">${day.day}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="select">
                        <select class="form-control" name="mealId">
                            <c:forEach items="${meals}" var="meal">
                                <option value="${meal.id}">${meal.meal}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="select">
                        <select class="form-control" name="count">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                        </select>
                    </div>

                    <div>
                        <button class="" type="submit">Добавить</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="col">
        <jsp:include page="../../resources/static-content/own_menu.jsp"/>
    </div>
</div>


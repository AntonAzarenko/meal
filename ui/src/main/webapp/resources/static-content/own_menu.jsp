<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" href="resources/css/start-page-css.css"/>
<link rel="stylesheet" href="webjars/font-awesome/5.10.1/css/all.css" type="text/css">
<link rel="stylesheet" href="webjars/bootstrap/4.1.0/css/bootstrap.min.css"/>
<link rel="stylesheet" href="webjars/jquery/3.4.1/jquery.min.js"/>

<div class="col">
    <table class="table-striped" width="100%" border="0" cellpadding="7" cellspacing="2">
        <tr style="padding-top: 200px">
            <th>День</th>
            <th>время</th>
            <th>Продукт</th>
            <th>Кол-во</th>
            <th>Белки</th>
            <th>Жиры</th>
            <th>Углеводы</th>
            <th>Удалить</th>
            <th>Ред-вать</th>
        </tr>
        <c:forEach items="${menus}" var="menu">
            <tr>
                <th>${menu.day}</th>
                <th>${menu.meal}</th>
                <th>${menu.food}</th>
                <th>${menu.count}</th>
                <th>${menu.protein}</th>
                <th>${menu.fats}</th>
                <th>${menu.carbohydrates}</th>
                <th>
                    <form method="post" action="/remove/${menu.id}">
                        <button><i class="fa fa-recycle" aria-hidden="true"></i></button>
                    </form>
                </th>
                <th><a href="edit"><i class="fa fa-edit" aria-hidden="true"></i></a></th>
            </tr>
        </c:forEach>
    </table>
</div>

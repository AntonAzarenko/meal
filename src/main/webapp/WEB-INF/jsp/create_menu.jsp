<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="../../resources/static-content/header.jsp"/>
<link rel="stylesheet" href="../../resources/css/start-page-css.css"/>
<link rel="stylesheet" href="webjars/bootstrap/4.1.0/css/bootstrap.min.css"/>
<link rel="stylesheet" href="webjars/jquery/3.4.1/jquery.min.js"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row" style="padding: 50px 0 0 50px">
    <div class="form jumbotron col-3">
        <div class="header">
            <form method="post" class="form-body" action="addMenu/">
                <div class="select">
                    <select class="text" name="foodId">
                        <c:forEach items="${foods}" var="food">
                            <option value="${food.id}">${food.title}</option>
                        </c:forEach>
                    </select>
                    <div class="select">
                        <select class="text" name="day">
                            <option value="Monday">Понедельник</option>
                            <option value="Tuesday">Вторник</option>
                            <option value="Wednesday">Среда</option>
                            <option value="Thursday">Thursday</option>
                            <option value="Friday">Пятница</option>
                            <option value="Saturday">Суббота</option>
                        </select>
                    </div>
                    <div class="select">
                        <select class="text" name="meal">
                            <option value="Breakfast">Завтрак</option>
                            <option value="Lunch">Обед</option>
                            <option value="Second_Lunch">Полдник</option>
                            <option value="Dinner">Ужин</option>
                        </select>
                    </div>
                    <div class="select">
                        <select class="text" name="count">
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
        <table width="100%" border="1" cellpadding="7" cellspacing="2">
            <tr style="padding-top: 200px">
                <th>День</th>
                <th>время</th>
                <th>Продукт</th>
                <th>Кол-во</th>
                <th>Белки</th>
                <th>Жиры</th>
                <th>Углеводы</th>
            </tr>
            <c:forEach items="${foods}" var="food">
                <tr>
                    <th>${food.title}</th>
                    <th>${food.weight}</th>
                    <th>${food.protein}</th>
                    <th>${food.fats}</th>
                    <th>${food.carbohydrates}</th>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>


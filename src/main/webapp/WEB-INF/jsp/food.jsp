<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="../../resources/static-content/header.jsp"/>
<link rel="stylesheet" href="../../resources/css/start-page-css.css"/>
<link rel="stylesheet" href="webjars/bootstrap/4.1.0/css/bootstrap.min.css"/>
<link rel="stylesheet" href="webjars/jquery/3.4.1/jquery.min.js"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<div style="padding-top: 50px" class="table-striped">
    <table width="100%" border="1" cellpadding="7" cellspacing="2">
        <tr style="padding-top: 200px">
            <th>Продукт</th>
            <th>Кол-во</th>
            <th>Мера</th>
            <th>Каллории</th>
            <th>Белки</th>
            <th>Жиры</th>
            <th>Углеводы</th>
        </tr>
        <c:forEach items="${foods}" var="food">
            <tr>
                <th>${food.title}</th>
                <th>${food.weight}</th>
                <th>${food.content}</th>
                <th>${food.calories}</th>
                <th>${food.protein}</th>
                <th>${food.fats}</th>
                <th>${food.carbohydrates}</th>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

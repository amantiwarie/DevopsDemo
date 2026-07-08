<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Currency Converter</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div class="container">
    <h1>INR Currency Converter</h1>

    <form action="${pageContext.request.contextPath}/convert" method="post">
        <label for="amount">Amount in INR:</label>
        <input type="number" step="0.01" id="amount" name="amount" required
               value="${not empty amount ? amount : ''}"/>

        <label for="targetCurrency">Convert to:</label>
        <select id="targetCurrency" name="targetCurrency">
            <c:forEach var="cur" items="${currencies}">
                <option value="${cur}" ${cur == targetCurrency ? 'selected' : ''}>${cur}</option>
            </c:forEach>
        </select>

        <button type="submit">Convert</button>
    </form>

    <c:if test="${not empty result}">
        <div class="result">
            <p>${amount} INR = <strong>${result} ${targetCurrency}</strong></p>
        </div>
    </c:if>
</div>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>CRM Home</title>
    <link type="text/css" rel="stylesheet" href="./css/style.css">
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h1>Customer Relationship Management Application</h1>
        </div>
        <div id="container">
            <div id="content">
                <input type="button" value="Register here!" onclick="window.location.href='/crm/newCustomer'" class="add-button"/>
                <table border="1">
                    <tr>
                        <th>Name</th>
                        <th>City</th>
                        <th>Salary</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                    <c:forEach var="cust" items="${customers}">
                    <c:url var="UpdateLink" value="/updatecustomer">
                        <c:param name="customerId" value="${cust.getId()}"></c:param>
                    </c:url>
                    <c:url var="DeleteLink" value="/deletecustomer">
                        <c:param name="customerId" value="${cust.getId()}"></c:param>
                    </c:url>
                    <tr>
                        <td>${cust.getName()}</td>
                        <td>${cust.getCity()}</td>
                        <td>${cust.getSalary()}</td>
                        <td><a href="${UpdateLink}">Update</a></td>
                        <td><a href="${DeleteLink}">Delete</a></td>
                    </tr>
                    </c:forEach>
                </table>

            </div>
        </div>
    </div>

</body>
</html>
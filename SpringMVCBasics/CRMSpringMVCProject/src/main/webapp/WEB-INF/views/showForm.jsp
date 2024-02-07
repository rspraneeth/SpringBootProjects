<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>CRM Home</title>
    <link type="text/css" rel="stylesheet" href="./css/style.css">
    <link type="text/css" rel="stylesheet" href="./css/add-customer-style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h1>Customer Relationship Management Registration Form!</h1>
    </div>

    <form:form action="addNewCustomer" modelAttribute="customer">
        <table>
            <form:hidden path="id" />
            <tr>
                <td>Name</td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>City</td>
                <td><form:input path="city" /></td>
            </tr>
            <tr>
                <td>Salary</td>
                <td><form:input path="salary" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="Register" /></td>
            </tr>
        </table>

    </form:form>

</div>

</body>
</html>
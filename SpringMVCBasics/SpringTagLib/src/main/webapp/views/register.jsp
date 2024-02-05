<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <center>
        <h1 style="color: bisque; text-align: center">Implementers Registration Application</h1>

        <form:form method="post" modelAttribute="request">
            <table>
                <tr>
                    <th>Implementer ID</th>
                    <td><input type="text" path="id"></td>
                </tr>

                <tr>
                    <th>Implementer Name</th>
                    <td><form:input path="name"/></td>
                </tr>

                <tr>
                    <th>Implementer City</th>
                    <td><form:input path="city"/></td>
                </tr>

                <tr>
                    <th>Implementer Salary</th>
                    <td><form:input path="salary"/></td>
                </tr>

                <tr>
                    <td><input type="submit" value="Register"></td>
                </tr>

            </table>

        </form:form>
    </center>
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Course Details</title>
</head>
<body>
<c:forEach var="book" items="${books}">${book}</c:forEach>

<c:forEach  var="c" items="${cs}">${c}</c:forEach>
</body>
</html>
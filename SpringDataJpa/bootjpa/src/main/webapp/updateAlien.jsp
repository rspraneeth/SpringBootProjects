<%@ page language="java" contentType="text/html; ISO-8859-1; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset = UTF-8">
    <title>Alien</title>
</head>
<body>
<p>Old ${alien}</p>
<p>You can only edit name and tech...</p>
<form action="saveUpdatedAlien">
    <label>Id:
        <input type="text" name="aid" value="${alien.aid}" readonly>
    </label><br>
    <label>Name:
        <input type="text" name="aname">
    </label><br>
    <label>Tech:
        <input type="text" name="tech">
    </label><br>
    <input type="submit" value="Update Alien"><br>
</form>
</body>
</html>
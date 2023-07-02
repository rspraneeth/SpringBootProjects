<%@ page language="java" contentType="text/html; ISO-8859-1; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset = UTF-8">
    <title>Alien</title>
</head>
<body>
<p>Old ${alien}</p>
<form action="addAlien">
    <label>Id:
        <input type="text" name="aid">
    </label><br>
    <label>Name:
        <input type="text" name="aname">
    </label><br>
    <label>Tech:
        <input type="text" name="tech">
    </label><br>
    <input type="submit" value="Add Alien"><br>
</form>
</body>
</html>
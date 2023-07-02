<%@ page language="java" contentType="text/html; ISO-8859-1; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset = UTF-8">
    <title>Alien</title>
</head>
    <body>
        <h1>Add Alien...</h1>
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
        <br>
        <h1>Wanna Fetch Alien?...</h1>
        <form action="getAlien">
            <label>Enter Id:
                <input type="text" name="aid"><br>
            </label>
            <input type="submit" value="Fetch Alien">
            <input type="submit" value="Delete Alien" formaction="deleteAlien">
            <input type="submit" value="Update Alien" formaction="updateAlien">
        </form>

    </body>
</html>
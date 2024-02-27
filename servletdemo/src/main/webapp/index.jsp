<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<div class="row">
    <div class="container">
        <form action="hello-servlet" method="post">
            <label>Enter your name:</label><input type="text" name="myName"  >
            <br>
            <br>
            <label>Enter your password </label><input type="password" name="password">
            <input type="submit" value="login">
        </form>
    </div>
</div>
</body>
</html>
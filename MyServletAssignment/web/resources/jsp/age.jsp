<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Enter your page</title>
    <style>
        div {
            border: solid 2px blue;
            width: 450px;
            padding: 5px;
            margin-left: 20px;
        }
        span {
            color: red;
            font-weight: bold;
        }
    </style>
</head>
<body>
<h1>Enter your age please.</h1>
<p>You should enter the number between 4 and 100</p>
<p>${msg}</p>
<form method="post">
    <input type="text" name="age" width="3">
    <input type="submit" value="submit age">
</form>
<br/>
<p>This is a number quiz. You have to answer the question and give the right next number in the sequence.</p>
</body>
</html>
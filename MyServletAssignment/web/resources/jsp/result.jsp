<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Result, your age is <span>${age}</span></title>
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
<h2>Your current grade is <span>${grade}</span></h2>
<p>You have completed the number quiz, with a score of ${score} out of ${questions}.</p>
</body>
</html>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" %>
    
<html>
<head>
<title>Insert title here</title>
</head>
	<body>
			<fieldset>
			    <legend>The Number Quiz</legend>
			    <div class="input_line">
			        <h3>Your Current Score is ${sessionScope.quiz.score} </h3>
			        <h3>You Have Completed The quiz with score  ${sessionScope.quiz.score} out of 5 </h3>
			    </div>
			 </fieldset>
</body>
</html>
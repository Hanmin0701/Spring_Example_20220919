<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Core 라이브러리(2)</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>
	<h1>1. 조건문 (c:choose, c:when, c:otherwise) </h1>
	<c:set var="weight" value="65"/>
	<c:choose>
		<c:when test="${weight < 60}">
			치킨 먹자<br>
		</c:when>
		<%-- 61 ~ 69 --%>
		<c:when test="${weight < 70}">
			샐러드 먹자<br>
		</c:when>
		<%-- 70 이상 --%>
		<c:otherwise>
			굶자<br>
		</c:otherwise>
	</c:choose>
	
	<h1>2. 반복문 (c:forEach)</h1>
	<%-- 0 ~ 5 => 6번 1씩 증가하고 val1에 저장한다. --%>
	<c:forEach begin="0" end="5" step="1" var="val1">
		${val1} <br>
	</c:forEach>
	
	<%-- 16 ~ 20 =>5 varStatus=> 반복문에 대한 정보가 있다. --%>
	<c:forEach begin="16" end="20" step="1" var="val2" varStatus="status">
		val: ${val2} current:${status.current} first:${status.first} last:${status.last} 
			count:${status.count} index:${status.index} <br>
	</c:forEach>
	
	
	<%-- 서버에서 가져온 List<String>출력 --%>
	<!-- count는 1부터 시작, index는 찍힌 그대로 나오는 것이다. -->
	
	<%-- for(항목 : 리스트) --%>
	<c:forEach var="fruit" items="${fruits}" varStatus="status">
		${fruit} ::::: 	${status.count} ::  ${status.index} <br>
	</c:forEach>
	
	
	<%-- 서버에서 가져온 List<Map>출력 --%>
	<c:forEach var="user" items="${users}" varStatus="status">
		<h4>${status.count}번째 사람 정보</h4>
		이름: ${user.name} <br>
		나이: ${user.age} <br>
		나이: ${user.hobby}
	</c:forEach>	
	
	<%-- 테이블 구성 List<Map>출력 --%>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>나이</th>
				<th>취미</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="user" itmes="${users}" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${user.name}</td>
				<td>${user.age}</td>
				<td>${user.hobby}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>
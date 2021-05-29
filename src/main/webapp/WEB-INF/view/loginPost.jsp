<%@page import="com.cos.domain.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page session="false" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>   
<html> 
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<H1>${loginUser.uname}</H1>        
<%-- <H1><%=((User)session.getAttribute("loginUser")).getUid()%></H1> --%>
</body>
</html>
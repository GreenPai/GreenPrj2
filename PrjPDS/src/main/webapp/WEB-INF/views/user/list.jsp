<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/x-icon" href="/img/favicon.ico">
<link rel="stylesheet" href="/css/common.css" />
<title>Insert title here</title>
<style>
   ul { margin:20px;  }
</style>
</head>
<body>
  <main>
    <h2>사용자 목록</h2>
    <c:forEach  var="user"  items="${ userList  }">
    <ul>
       <li>아이디 : ${ user.userid }</li>
       <li>이름   : <a href="/User/View?userid=${ user.userid }">${ user.username }</a></li>
       <li>가입일 : ${ user.indate }</li>
    </ul>
    </c:forEach>    
    
    <div><a href="/">Home</a></div>
    
    <div style="height: 200px"></div>
  </main>  
</body>
</html>











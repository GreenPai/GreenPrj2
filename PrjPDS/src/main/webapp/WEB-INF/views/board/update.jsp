<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>게시물 등록</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="icon" type="image/x-icon" href="/img/favicon.ico">
<link rel="stylesheet" href="/css/common.css" />

<style>
   input  { height: 32px;  }
   
   #table   th       {  width : 20%;  }  
   #table   td       {  width : 80%;  }  
   input[type=text]  {  width : 100%;  }  
   textarea          {  width : 100%; height: 300px; padding:10px; }  
</style>

<script></script>

</head>
<body>
  <main>
  
  <!-- 메뉴 목록 -->
  <%@include file="/WEB-INF/include/menus.jsp" %>

  <form action="/Board/Update" method="POST">
  <input type="hidden" name="menu_id" value="${ vo.menu_id }" />
  <table id="table">
   <caption>
  	  <h2>게시물 수정</h2>  	     
   </caption>
   <tr>
    <th>글번호</th>
    <td><input type="text" name="idx" value="${ vo.idx }" readonly /></td>
   </tr>
   <tr>
    <th>제목</th>
    <td><input type="text" name="title" value="${ vo.title }"/></td>
   </tr>
   <tr>
    <th>글쓴이</th>
    <td><input type="text"  value="${ vo.writer }"  readonly /></td>
   </tr>
   <tr>
    <th>날짜</th>
    <td><input type="text"  value="${ vo.regdate }" readonly /></td>
   </tr>
   <tr>
    <th>조회수</th>
    <td><input type="text"  value="${ vo.readcount }" readonly /></td>
   </tr> 
   <tr>
    <th>내용</th>
    <td><textarea name="cont">${ vo.cont }</textarea></td>
   </tr>  
   <tr>
    <td colspan="2">
      <input type="submit"  value="수정" />
      <input type="button"  value="목록" 
         onclick="location.href='/Board/List?menu_id=${ vo.menu_id }'" />
      <input type="button"  value="이전으로" onclick="history.back()" />
    </td>
   </tr>
    
  </table>
  </form> 
  
  </main>
</body>
</html>



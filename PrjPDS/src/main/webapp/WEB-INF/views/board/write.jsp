<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%@taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %> 
    
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
  
<%--   <form action="/Board/Write?menu_id=${ vo.menu_id }" method="POST"> --%>
  <form action="/Board/Write" method="POST">
  <input type="hidden" name="menu_id" value="${ vo.menu_id }" />
  <input type="hidden" name="idx"     value="${ vo.idx     }" />
  <input type="hidden" name="bnum"    value="${ vo.bnum    }" />
  <input type="hidden" name="lvl"     value="${ vo.lvl     }" />
  <input type="hidden" name="step"    value="${ vo.step    }" />
  <input type="hidden" name="nref"    value="${ vo.nref    }" />
  <table id="table">
   <caption>
     <c:choose>
      <c:when test="${ vo.bnum == 0 }">
  	    <h2>게시물 등록</h2>
  	  </c:when>
  	  <c:otherwise>  	     
  	    <h2>답글 등록</h2>
  	  </c:otherwise>
  	 </c:choose>   	     
   </caption>
   <tr>
    <th>제목</th>
    <td><input type="text" name="title" value="${ vo.title }"  /></td>
   </tr>
   <tr>
    <th>글쓴이</th>
    <td><input type="text" name="writer" /></td>
   </tr>
   <tr>
    <th>내용</th>
    <td><textarea name="cont">${ vo.cont }</textarea></td>
   </tr>  
   <tr>
    <td colspan="2">
      <input type="submit"  value="가입" />
    </td>
   </tr>
    
  </table>
  </form> 
  
  </main>
</body>
</html>



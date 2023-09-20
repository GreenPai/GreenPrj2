<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>게시물 조회</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="icon" type="image/x-icon" href="/img/favicon.ico">
<link rel="stylesheet" href="/css/common.css" />

<style>
   input  { height: 32px;  }
   
   #table   th:nth-of-type(1)   {  width : 15%;  }     
   #table   td:nth-of-type(1)   {  width : 35%;  }
   #table   th:nth-of-type(2)   {  width : 15%;  }     
   #table   td:nth-of-type(2)   {  width : 35%;  }
        
   input[type=text]  {  width  : 100%;  }  
   textarea          {  width  : 100%; height: 300px; padding:10px; }
   #td_ta            {  height : 300px;
        vertical-align: baseline;
   }   
</style>

<script></script>

</head>
<body>
  <main>
  
  <!-- 메뉴 목록 -->
  <%@include file="/WEB-INF/include/menus.jsp" %>
  
  <table id="table">
   <caption>
  	  <h2>게시물 내용보기</h2>   
   </caption>
   <tr>
    <th>글번호</th>
    <td>${ vo.idx       }</td>
    <th>조회수</th>
    <td>${ vo.readcount }</td>
   </tr>
   <tr>
    <th>작성자</th>
    <td>${ vo.writer   }</td>
    <th>날짜</th>
    <td>${ vo.regdate  }</td>
   </tr>
   <tr>
    <th>제목</th>
    <td colspan="3">${ vo.title }</td>
   </tr>
   <tr>
    <th>내용</th>
    <td colspan="3" id="td_ta">${ vo.cont }</td>
   </tr>  
   <tr>
    <td colspan="4" style="text-align:center">
      [<a href="/Board/WriteForm?menu_id=${ vo.menu_id }&bnum=0">새글쓰기</a>] 
      [<a href="/Board/WriteForm?menu_id=${ vo.menu_id }&idx=${ vo.idx }&bnum=${ vo.bnum }&lvl=${ vo.lvl }&step=${ vo.step }&nref=${ vo.nref }">답글쓰기</a>] 
      [<a href="/Board/UpdateForm?menu_id=${ vo.menu_id }&idx=${ vo.idx }">수정</a>] 
      [<a href="/Board/Delete?menu_id=${ vo.menu_id }&idx=${ vo.idx }">삭제</a>] 
      [<a href="/Board/List?menu_id=${ vo.menu_id }">목록으로</a>] 
      [<a href="javascript:history.back()">이전으로</a>] 
    </td>
   </tr>
    
  </table>
   </main>
</body>
</html>



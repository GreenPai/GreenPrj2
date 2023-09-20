<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%@taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head>
<title>${ menuname } 자료실 내용보기</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="icon" type="image/x-icon" href="/img/favicon.ico">
<link rel="stylesheet" href="/css/common.css" />

<style>
   input  { height: 32px;  }
   
   #table  th                      {  width  : 15%;  }  
   #table  td                      {  width  : 35%;  }  
   #table  tr:nth-of-type(4)       {  height : 300px;  vertical-align: top; }  
   #table  tr:nth-of-type(5)       {  height : 200px;  vertical-align: top; }  
   #table  tr:nth-of-type(6)  td   {  text-align: center;  }  
     
</style>

<script src="https://code.jquery.com/jquery.min.js"></script>

<script>
   
   $( function() {
	   let num = 1;
	   $('#btnAddFile').on('click', function() {		   
		   let tag = '<input type="file" name="upfile' + num + '" class="upfile" /><br>';
		   $('#tdfile').append( tag );
		   num++;
	   })
   })

</script>

</head>
<body>
  <main>
  
  <!-- 메뉴 목록 -->
  <%@include file="/WEB-INF/include/pdsmenus.jsp" %>
  
  <table id="table">
   <caption>
     <h2>${ menuname } 자료실 내용 보기</h2>
   </caption>
   
   <tr>
   	<th>글번호</th>
   	<td>${ vo.idx }</td>
   	<th>조회수</th>
   	<td>${ vo.readcount }</td>
   </tr>
   <tr>
   	<th>작성자</th>
   	<td>${ vo.writer }</td>
   	<th>작성일</th>
   	<td>${ vo.regdate }</td>
   </tr>
   <tr>
    <th>제목</th>
    <td colspan="3">
       ${ vo.title }
    </td>
   </tr>   
   <tr>
    <th>내용</th>
    <td colspan="3">
       ${ vo.cont }
    </td>
   </tr>  
   <tr>
    <th>파일</th>
    <td id="tdfile" colspan="3">
      
      <c:forEach var="file" items="${ fileList }">
        <div>
          <a href="/Pds/download/external/${ file.sfilename }">
            ${ file.filename } 
          </a>        
        </div>
      </c:forEach>
      
    </td>
   </tr>
   <tr>
    <td colspan="4">
      <a href="/Pds/WriteForm?menu_id=${ map.menu_id }&bnum=${ map.bnum }">새글쓰기</a>&nbsp;&nbsp;
      <a href="/Pds/WriteForm?menu_id=${ map.menu_id }&idx=${ vo.idx }&bnum=${ vo.bnum }&lvl=${ vo.lvl }&step=${ vo.step }&nref=${ vo.nref }">답글쓰기</a>&nbsp;&nbsp;
      <a href="/Pds/UpdateForm?menu_id=${ map.menu_id }&idx=${ vo.idx }">수정</a>&nbsp;&nbsp;
      <a href="/Pds/Delete?menu_id=${ map.menu_id }&idx=${ vo.idx }">삭제</a>&nbsp;&nbsp;
      <a href="/Pds/List?menu_id=${ map.menu_id }">목록으로</a>&nbsp;&nbsp;
      <a href="/">Home</a>
    </td>
   </tr>
    
  </table>
  
  </main>
</body>
</html>



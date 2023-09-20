<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%@taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core"   %>
  <%@taglib  prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>  
    
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/x-icon" href="/img/favicon.ico">
<link rel="stylesheet"  href="/css/common.css" />
<style>

 #PdsList  td:nth-of-type(1) { width:70px;  text-align: center; }
 #PdsList  td:nth-of-type(2) { width:300px; text-align: left; }
 #PdsList  td:nth-of-type(3) { width:80px;  text-align: center; }
 #PdsList  td:nth-of-type(4) { width:80px;  text-align: center; }
 #PdsList  td:nth-of-type(5) { width:100px; text-align: center; }
 #PdsList  td:nth-of-type(6) { width:100px; text-align: center; }
 
 #PdsList  tr:nth-of-type(2) td {
     text-align : center; 
     font-weight: bold;
 }

</style>

<script></script>
</head>
<body>
  <main>    
    <!-- 메뉴 목록 -->
	<%@include file="/WEB-INF/include/pdsmenus.jsp" %>
		
    <!--  자료실 목록 -->
    <table id="PdsList">
      <caption>
        <h2>${ map.menuname } 자료실</h2>
      </caption>
      <tr>
      	<td colspan="6" style="text-align:right">
      	  <a href="/Pds/WriteForm?menu_id=${ map.menu_id }&bnum=0">[새 글 쓰기]</a>
      	</td>
      </tr>
   	  <tr>
   		<td>번호</td>
   		<td>제목</td>
   		<td>작성자</td>
   		<td>조회수</td>
   		<td>첨부파일수</td>
   		<td>작성일</td>
   	  </tr>
   	  
   	 <c:forEach  var="pds" items="${ pdsList }">
   	 <tr>
   	    <!-- 번호 -->
   	    <td>
   	      <c:if  test="${ pds.lvl == 0 }" >  
   	        ${ pds.idx }
   	      </c:if>
   	    </td>
   	    
   	    <!-- 제목 -->
   		<td>
   		  <b style="display:inline-block;width:${(pds.lvl-1)*20}px"></b> 
   		  <c:choose>
   		    <c:when test="${ pds.lvl eq 0 }">
   		       <a href="/Pds/View?menu_id=${ pds.menu_id }&idx=${ pds.idx }">
   		       ${ pds.title }
   		       </a>
   		    </c:when>
   		    <c:otherwise>
   		      <a href="/Pds/View?menu_id=${ pds.menu_id }&idx=${ pds.idx }">
   		       [답글] ${ pds.title }
   		      </a>   
   		    </c:otherwise>
   		  </c:choose>    
   		</td>
   		  
   		<!-- 작성자 -->   		
   		<td>${ pds.writer }</td>
   		
   		<!-- 조회수 -->
   		<td>${ pds.readcount }</td>
   		
   		<!-- 첨부파일수 -->
   		<td>
   		 <c:choose>
   		  <c:when test="${ pds.filescount ne 0 }"> 
   		    ${ pds.filescount }
   		  </c:when>
   		  <c:otherwise>
   		    &nbsp;
   		  </c:otherwise> 
   		 </c:choose>
   		</td>
   		
   		<!-- 작성일 -->
   		<td>${fn:substring( pds.regdate, 0, 10 ) }</td>
   	 </tr>
   	 </c:forEach>
   	  
   	  
    </table>
  </main>
</body>
</html>









<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%@taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>  
    
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/x-icon" href="/img/favicon.ico">
<link rel="stylesheet"  href="/css/common.css" />
<style>
  #table  th:nth-of-type(1) { width : 100px;   }
  #table  th:nth-of-type(2) { width : 500px;   }
  #table  th:nth-of-type(3) { width : 100px;   }
  #table  th:nth-of-type(4) { width : 100px;   }
  #table  th:nth-of-type(5) { width : 100px;   }
  
  #table  td                { text-align: center;  }
  #table  td:nth-of-type(2) { text-align: left;  }

</style>
<script></script>
</head>
<body>
	<main>
		
	<!-- 메뉴 목록 -->
	<%@include file="/WEB-INF/include/menus.jsp" %>
		
	<!-- 게시물 목록 -->
	<table id="table">
	<caption>
	  <h2>${ menu_name  } 게시판</h2>
	</caption>
	<tr>
	  <th>번호</th>
	  <th>제목</th>
	  <th>글쓴이</th>
	  <th>날짜</th>
	  <th>조회수</th>
	</tr>
	
	<tr>
	  <td colspan="5" style="text-align:right">
	    <a href="/Board/WriteForm?menu_id=${ param.menu_id }&bnum=0">
	    [새글 쓰기]
	    </a>
	  </td>
	</tr>
	
	<c:forEach  var="board"  items="${ boardList }">
	<tr>
	  <td>
	     <c:if  test="${ board.lvl == 0  }" >
	     ${ board.idx }
	     </c:if>
	  </td>
	  <td>
	   <b style="display:inline-block;width:${(board.lvl-1)*20}px"></b> 
	  
	   <c:choose>
	    <c:when test="${ board.lvl eq 0  }">
		   <a href="/Board/View?idx=${ board.idx }&menu_id=${ board.menu_id  }">
		     ${ board.title }
		   </a>
	    </c:when>
	    <c:otherwise>
	       [답글]     
	       <a href="/Board/View?idx=${ board.idx }&menu_id=${ board.menu_id  }">
		     ${ board.title }
		   </a>
	    </c:otherwise>	  
	  </c:choose>
	  </td>
	  <td>${ board.writer }</td>
	  <td>${ board.regdate }</td>
	  <td>${ board.readcount }</td>
	</tr>
	</c:forEach>
	
	</table>	
	
	</main>
</body>
</html>






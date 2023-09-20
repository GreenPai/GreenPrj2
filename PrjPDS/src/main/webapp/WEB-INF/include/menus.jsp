<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>  

<table  id="menu">

<tr>
  
  <c:forEach var="menuVo" items="${ menuList }">
   <td>
      <a href="/Board/List?menu_id=${ menuVo.menu_id }">
      ${ menuVo.menu_name }
      </a> 
   </td>
  </c:forEach> 

</tr>

</table>




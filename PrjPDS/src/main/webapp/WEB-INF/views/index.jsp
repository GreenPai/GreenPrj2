<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/x-icon" href="/img/favicon.ico">
<link rel="stylesheet"  href="/css/common.css" />

<title>Insert title here</title>
</head>
<body>
  <main>
     <h2>Hello World!!!</h2>
     <br>
     <div><a href="/User/List">사용자 목록</a></div>
     <div><a href="/User/WriteForm">사용자 등록</a></div>
     <br>
     <div><a href="/Menus/List">메뉴 목록</a></div>
     <div><a href="/Menus/WriteForm">메뉴 등록</a></div>
     <div><a href="/Menus/WriteForm2">메뉴 등록2</a></div>
     <br>
     <div><a href="/Board/List?menu_id=MENU01">게시물 목록</a></div>
     <div><a href="/Board/WriteForm?menu_id=MENU01&bnum=0">새글쓰기</a></div>
     <br>
     <div><a href="/Pds/List?menu_id=MENU01">자료실 목록</a></div>
     <div><a href="/Pds/WriteForm?menu_id=MENU01&bnum=0">자료실 등록</a></div>
  </main> 
</body>
</html>










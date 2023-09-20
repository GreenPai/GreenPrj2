<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/x-icon" href="/img/favicon.ico">
<link rel="stylesheet" href="/css/common.css" />
<title>회원등록</title>

</head>
<body>
  <main>
  <h2>회원가입</h2>
  <form action="/User/Write" method="POST">
  <table>
   <tr>
    <td>아이디</td>
    <td><input type="text" name="userid" /></td>
   </tr>
   <tr>
    <td>암호</td>
    <td><input type="password" name="passwd" /></td>
   </tr>
   <tr>
    <td>이름</td>
    <td><input type="text" name="username" /></td>
   </tr>
   <tr>
    <td>이메일</td>
    <td><input type="text" name="email" /></td>
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



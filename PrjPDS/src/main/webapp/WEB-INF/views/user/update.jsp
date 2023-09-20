<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/x-icon" href="/img/favicon.ico">
<link rel="stylesheet" href="/css/common.css" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

<title>회원수정</title>

</head>
<body>
  <main>
  <h2>회원수정</h2>
  <form id="updateForm" action="/User/Update" method="POST">
  <table class="table table-striped-columns" >
   <tr>
    <td>아이디</td>
    <td><input type="text" name="userid" value="${ user.userid }" readonly /></td>
   </tr>
   <tr>
    <td>암호</td>
    <td><input type="password" name="passwd" value="${ user.passwd }"/></td>
   </tr>
   <tr>
    <td>이름</td>
    <td><input type="text" name="username" value="${ user.username }" /></td>
   </tr>
   <tr>
    <td>이메일</td>
    <td><input type="text" name="email" value="${ user.email }" /></td>
   </tr>
   <tr>
    <td>가입일</td>
    <td><input type="text" name="indate" value="${ user.indate }" readonly /></td>
   </tr>
   <tr>
    <td colspan="2">
      <a href="/User/Update" class="btn btn-primary" id="aUpdate">수정</a>
      <input type="submit" class="btn btn-primary" value="수정" />
    </td>
   </tr>
    
  </table>
  </form> 
  
  </main>
  
  <script>
     const  aUpdateEl = document.querySelector('#aUpdate');     
     aUpdateEl.addEventListener('click', function(e) {    	 
    	 e.preventDefault() ; // 기본이벤트를 동작하지 못하게 한다
    	 e.stopPropagation();
    	 const updateFormEl  = document.querySelector('#updateForm');
    	 updateFormEl.action = aUpdateEl.href;
    	 updateFormEl.submit();
     });
     
     
  </script>
  
  
</body>
</html>



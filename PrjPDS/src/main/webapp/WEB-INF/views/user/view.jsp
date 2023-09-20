<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/x-icon" href="/img/favicon.ico">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="/css/common.css" />
<style>
   td[colspan] { text-align: center;}
   td[colspan] > a:hover {  text-decoration: none;  }
</style>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

<title>회원정보조회</title>

</head>
<body>
  <main>
  <h2>회원정보</h2> 
  <table  class="table table-striped-columns">
   <tr>
    <td>아이디</td>
    <td>${ user.userid }</td>
   </tr>
   <tr>
    <td>암호</td>
    <td>${ user.passwd }</td>
   </tr>
   <tr>
    <td>이름</td>
    <td>${ user.username }</td>
   </tr>
   <tr>
    <td>이메일</td>
    <td>${ user.email }</td>
   </tr>
   <tr>
    <td>가입일</td>
    <td>${ user.indate }</td>
   </tr>
   <tr>
    <td colspan="2">
      <a  class="btn btn-primary btn-sm" 
           href="/User/WriteForm" >회원추가</a>
      <a  class="btn btn-warning btn-sm" 
           href="/User/UpdateForm?userid=${ user.userid }">회원수정</a>
      <a  class="btn btn-danger btn-sm"
          data-bs-toggle="modal" data-bs-target="#exampleModal" 
           href="/User/Delete/${ user.userid }" >회원삭제</a>
      <a  class="btn btn-success btn-sm"
           href="/User/List">회원목록</a>
      <a  class="btn btn-info btn-sm"   
           href="/">홈으로</a>            
    </td>
   </tr>
    
  </table>
  
  <!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">삭제 확인</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	         ${ user.userid } 를  삭제하시겠습니까?
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
	        <button type="button" class="btn btn-primary" 
	           id="deleteOk">확인</button>
	      </div>
	    </div>
	  </div>
	</div>
 
  </main>
  
  <script>
     const deleteOkEl = document.querySelector('#deleteOk');
     deleteOkEl.addEventListener('click', function() {
    	 const   aDeleteEl = document.querySelector('[href*=Delete]');
    	 console.dir(aDeleteEl)
    	 location.href = aDeleteEl.href;
     })
  
  </script>
  
  
  
</body>
</html>











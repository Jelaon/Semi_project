<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="resources/CSS/searchPwdviewform.css">
</head>
<body>
    
    <div id="searchPwd-wrap">
        <div id="searchPwd-form">
      <div id="home-logo">
                    <img src="resources/IMG/로고이미지.png" alt="로고이미지">
                </div>
           <p>메일 전송 완료</p>
           <button id="login-form-btn">로그인</button> <br>
           <p>메일 전송 실패</p>
           
           <button id="searchPwd-form-btn">다시 비밀번호찾기 폼으로 이동</button> <br>
        
         
       
</div>
    </div>
    
     <script>
    
    document.getElementById("login-form-btn").addEventListener("click",function(){
        location.href = "<%= request.getContextPath() %>/login.me";
    })
    
    document.getElementById("searchPwd-form-btn").addEventListener("click",function(){
        location.href = "<%= request.getContextPath() %>/searchPwd.me";
    })


    
    </script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="resources/CSS/searchIdviewform.css">
     <link rel="stylesheet" href="resources/CSS/base.css">
</head>
<body>
    
    <div id="searchId-wrap">
        <div id="searchId-form">
            <form action="">
                <div id="home-logo">
                    <img src="resources/IMG/로고이미지.png" alt="로고이미지">
                </div>
           <p>고객님의 아이디는</p>
           <p>user01</p>
           <p>입니다.</p>

           
           <button id="login-form-btn">로그인</button> <br>
            <div id="searchPwd"> <div>비밀번호 찾기</div></div>
        </form>
           <div id="searchId-footer">
            <div>
            <p>아직 회원이 아니신가요   
             <a href="<%= request.getContextPath() %>/enroll.me">회원가입</a>
             </p>
          </div>
          </div>
       
</div>
    </div>
</body>
</html>
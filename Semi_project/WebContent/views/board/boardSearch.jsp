<%@ page import = "java.util.ArrayList,com.khtime.board.model.vo.Board" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/CSS/header.css">
    <link rel="stylesheet" href="resources/CSS/body.css">
    <link rel="stylesheet" href="resources/CSS/footer.css">
    <link rel="stylesheet" href="resources/CSS/boardlistpage.css">
     <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <title>KH_TIME 메인페이지</title>
</head>
<style>
    /* * {
        border: 1px solid rgba(128, 128, 128, 0.568);
    } */

    div {
        display: inline-block;
        box-sizing: border-box;
    }

    a {
        text-decoration: none;
        color: black;
    }

    #wrapper {
        width: 100%;
        min-width: 1180px;

    }
</style>

<body>
    <div id="wrapper">
        <div id="header">
            <div id="header-content">
                <div id="home-logo">
                    <img src="resources/IMG/로고이미지.png" alt="로고이미지">
                </div>
                <div id="navbar">
                    <div>게시판</div>
                    <div>친구목록</div>
                    <div>중고책방</div>
                    <div>To Do List</div>
                    <div>관리</div>
                </div>
                <div id="header-right">
                    <button id="login-btn">로그인</button>
                    <button id="enrollment-btn">회원가입</button>
                </div>
            </div>
        </div>
        <div id="body">
            <div id="main-banner">
            </div>
            <div id="content">
                <form id="boardmake">
                    <div>
                        <div><input type="text" name="name" placeholder="게시판 검색" id="Board"></div>
                        <button type="button"  onclick="searchBoard();" >검색</button> <br>
                    </div>

                    <br>
                    <div id="searchresult">'게시판 검색 결과'</div>
                 
                        <div  id="keyword">
                     
                        </div>
                   
                   
                    <button>게시판 생성 요청</button>
                </form>
            </div>
        </div>
        <div id="footer">



        </div>
    </div>
	
	    <script>
		function searchBoard(){

			let searchBoard = document.getElementById("Board").value;
			
			$.ajax({
				
				url : "<%= request.getContextPath()%>/board.do",
				data : {Board : searchBoard},
				success :function(result){
									$('#searchresult').html(searchBoard+"   검색결과");
							 if(result.length == 0){		
									$('#keyword').html("조회된 게시판은 존재하지 않습니다.");
							 }else{
								 $('#keyword').html('');
								 $(result).each(function(index , item){
									 console.log(item);
									 $('#keyword').append(`<div id="category\${index}">\${item.categoryName}</div>`);
									 $('#category'+index).click(function(){
										 location.href="<%=request.getContextPath() %>/boardDetail.bo?cNo="+item.categoryNo;
									 })
								 })
							 }
							 
						 }	 
					 });
				 }
			
		</script>
                    




</body>
</html>
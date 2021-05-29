<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<form action="/hangulTest" method="post">
	<input type="hidden" name="id"  value="test">
	<input type="hidden" name="name" value="테스트">
	<button type="submit">한글깨짐전송</button>
</form>
<form action=/setVo method="post">
	<input type="hidden" name="id" value="test">
	<input type="hidden" name="name" value="VO 테스트">
	<button type="submit">vo전송</button>
</form>

<form name="jsonForm" id="jsonForm">
	<input type="hidden" name="id" id="id" value="test">
	<input type="hidden" name="name" id="name" value="VO 테스트">
	<button type="button" id="jsonBtn">json전송</button>
</form>
<a href="javascript:to_ajax()">json전송</a>
</body>
<script>

 	function to_ajax(){
		alert('to_ajax 함수호출');
		//var queryString = $("form[name=jsonForm]").serialize();
		var jsonData = {
			id: document.querySelector("#id").value,
			name:document.querySelector("#name").value
		}
		$.ajax({
			type : 'POST',
			url : "/paramJson",
			//data:queryString,
			data:JSON.stringify(jsonData),
			dataType : 'json',
			contentType : "application/json; charset=utf-8"
		}).done(function(r){
			if (r.statusCode == 200){
				alert("성공!");
			}else{
				alert("실패!");
			}
		})
	} 
	
/* var artice = {
	init : function(){
		var _this = this;
		const createBtn = document.querySelector("#jsonBtn");
		createBtn.addEventListener('click', _this.create);
	},
	create:function(){
		var data = {
			id: document.querySelector("#id").value,
			name:document.querySelector("#name").value
		}
		
		fetch("/paramJson",{ 
			method:'POST',
			body:JSON.stringify(data),
			//body:data,
			headers:{
				//'Content-Type':'text/plain;charset=UTF-8'
				'Content-Type':'application/json'
			}
		}).then(function(response){ 
			if (response.ok){
				alert("json 응답성공!");
			}else{
				alert("json 응답실패!");
			}
		});
	}
} 

artice.init();
*/
</script>
</html>
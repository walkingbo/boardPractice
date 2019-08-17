<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSB.COM: 로그인</title>
</head>
<body>
	<form accept-charset="UTF-8" role="form" method="post">
		<legend>로그인</legend>
		<div >
			<label for="id">아이디 </label> 
			<input type="text" name="id" id="id" required="required" placeholder="아이디를 입력하세요"  />
		</div>
		<div >
			<label for="password">비밀번호</label> 
			<input type="password" name="pw" id="pw" placeholder="비밀번호를 입력하세요" class="form-control" />
		</div>
		<div id=reLoginMsg>${msg}</div>
		<div>
		<input type="submit" value="로그인"  id="loginSubmit"/>
		</div>
		<div>
			<a href="register" >회원가입</a>
		</div>
		<div >
			<a href="../" >메인으로</a>
		</div>
	</form>
	
	<%@ include file="../include/footer.jsp"%>
	
	
	
	
</body>

<script>

document.getElementById("loginSubmit").addEventListener("click",function(e){
	 
})

</script>
	
</html>
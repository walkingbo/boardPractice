<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<section class="content">
<!-- 회원가입 폼 :  유효성 검사를 위해서 id를 부여 최근에는 form의 전송 방식은 거의 post 조회할 때 입력받는 부분만 get  -->
	<form id="registerform" method="post">
		
		<!-- accept 속성은 파일 선택을 제한 : 확장자를 가지고 제한  
		<input type="file" id="image" name="image" accept=".jpg,.jpeg,.gif,.png" /><br />
		-->
		<div><h2>회원가입</h2></div><br/>
		
		<h3>아이디</h3>
		<input type="text" name="id" id="id" size="30" maxlength=50 pattern="([a-z, 0-9]){5,12}" 
		required="required"/>
		<div id="idcheckdiv">아이디는 5~12자의 영문 소문자, 숫자만 사용 가능합니다.</div><br/><br/>
		
		<h3>비밀번호</h3>
		<input type="password" name="pw" id="pw" size="30" maxlength=50 required="required"/>
		<div id="pwdiv">비밀번호는 8자 이상이고 숫자, 영어 대소문자 그리고 특수문자가 1개 이상 포함되어 있어야 합니다.</div><br/><br/>
		<h3>비밀번호 재확인</h3>
		<input type="password" name="repw" id="repw" size="30" maxlength=50 required="required"/>
		<div id="repwdiv"></div><br/><br/>
		
		<h3>이름</h3>
		<input type="text" name="realname" id="realname" size="30" pattern="([a-z, A-Z, 가-힣]){2,}" required="required"
					title="이름은 문자 2자 이상입니다." /><br/><br/>
		
		<h3>생년월일</h3>
		<input type="text" id="yy" name="yy" placeholder="년(4자)" maxlength="4">
						
		
				<select id="MM" name="MM" aria-label="월">
						<option>월</option>
						<option value="01">1</option>
						<option value="02">2</option>
						<option value="03">3</option>
						<option value="04">4</option>
						<option value="05">5</option>
						<option value="06">6</option>
						<option value="07">7</option>
						<option value="08">8</option>
						<option value="09">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
				</select>
				
			
				<input type="text" id="dd" name="dd" placeholder="일(예시 - 01 ~ 31)" maxlength="2">
		
		<br/><br/>
		
		<h3>성별</h3>
		<div class="sex">
			<div class="ps_box gender_code">
				<select id="gender" name="gender" aria-label="성별">
					<option value="" selected>성별</option>
					<option value="M">남자</option>
					<option value="F">여자</option>
				</select>
			</div>
		</div>
		<br/><br/>
		
		<h3>이메일</h3>
		<input type="email" name="email" id="email" size="30" maxlength=50 required="required" /><br/><br/>
		
		<h3>휴대전화</h3>
		<input type="tel" id="phone" name="phone" placeholder="전화번호(ex01000000000)" maxlength="16"><br/><br/>
		<input type="submit" value="회원가입" class="btn btn-warning" />

	</form>
</section>

<%@include file="../include/footer.jsp"%>



<script>


	//아이디 중복 검사 여부를 통과했는지를 저장할 변수를 생성
	var idcheck = false;
	//ID 입력 란에서 포커스가 떠나면 
	document.getElementById("id").addEventListener("focusout", function(e) {
		var id = document.getElementById("id").value;
		if (id.trim().length > 0) {
			$.ajax({
				url : 'idcheck',
				data : {
					'id' : id
				},
				dataType : 'json',
				success : function(data) {
					var idcheckdiv = document.getElementById("idcheckdiv")
					if (data.result == true) {
						idcheckdiv.innerHTML = "사용 가능한 아이디 입니다."
						idcheckdiv.style.color = 'green'
						idcheck = true
					} else {
						idcheckdiv.innerHTML = "사용 불가능한 아이디 입니다."
						idcheckdiv.style.color = 'red'
						idcheck = false
					}
				}
			})
		}
	})
	
	//pw 입력 란에서 포커스가 떠나면 
	document.getElementById("pw").addEventListener("focusout", function(e) {
		var pw = document.getElementById("pw");
		
		//숫자, 소문자, 대문자, 특수문자의 정규식 패턴 생성  
		var p1 = /[0-9]/
		var p2 = /[a-z]/
		var p3 = /[A-Z]/
		var p4 = /[!@#$%^&*()]/
		//pw에 위 4개의 패턴이 등장하지 않거나 8자보다 글자수가 작으면 전송하지 않음 
		if(!p1.test(pw.value) || !p2.test(pw.value) || !p3.test(pw.value) || !p4.test(pw.value) || pw.value.length < 8){
		document.getElementById("pwdiv").innerHTML = "비밀번호는 8자 이상이고 숫자, 영어 대소문자 그리고 특수문자가 1개 이상 포함되어 있어야 합니다."
		document.getElementById("pwdiv").style.color = 'red'
		}
		else{
			document.getElementById("pwdiv").innerHTML = ""
		}
		
	})
	
	//repw 입력 란에서 포커스가 떠나면 
	document.getElementById("repw").addEventListener("focusout", function(e) {
		var pw = document.getElementById("pw");
		var repw = document.getElementById("repw");
		if(pw.value != repw.value){
			document.getElementById("repwdiv").innerHTML = "비밀번호와 비밀번호 확인의 값은 같아야 합니다."
			document.getElementById("repwdiv").style.color = 'red'
			}
		else{
			document.getElementById("repwdiv").innerHTML = ""
			}
})
	
	//registerform 에 submit 이벤트가 발생했을 때 처리
	document.getElementById("registerform").addEventListener("submit",function(e){
		if(idcheck == false){
			document.getElementById("idcheckdiv").innerHTML = "아이디 중복검사를 통과하지 못하였습니다." 
			document.getElementById("idcheckdiv").style.color = 'red'
			document.getElementById("id").focus()
			e.preventDefault()
			return 
		}
})
	
	
	
	
	
</script>

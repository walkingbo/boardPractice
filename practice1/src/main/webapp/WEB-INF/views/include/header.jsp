<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jstl의 core 기능을 사용하기 위한 설정 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSB.COM</title>
<!-- 모바일에서 접속했을 때 화면의 너비를 디바이스의 크기만큼으로 출력하기 위한 설정 -->
<meta
content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
name='viewport'>
<!-- jquery 사용을 위한 설정 -->
<script src="/resources/jquery/jquery.min.js"></script>
<!-- 부트스트랩을 사용하기 위한 설정 -->
<link href="/resources/bootstrap4.3.1/css/bootstrap.min.css" rel="stylesheet"
type="text/css" />
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="/">SSB.COM</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link" href="#">메인화면</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="/board/list">게시글목록</a></li>
				<c:if test="${user==null}">
					<li class="nav-item"><a class="nav-link disabled" href="#" aria-disabled="true" >게시글작성</a></li>
				</c:if>
				<c:if test="${user!=null}">
					<li class="nav-item"><a class="nav-link" href="/board/register" aria-disabled="false" >게시글작성</a></li>
					</c:if>
				<li class="nav-item"><a class="nav-link disabled" href="#"
					tabindex="-1" aria-disabled="true">서비스 예정</a></li>
			</ul>
		</div>
		<c:if test="${user==null}">
			<a class="nav-link" href="http://localhost:8091/user/register" tabindex="-1">
				<button class="btn btn-secondary">회원가입</button>
			</a>
			<a class="nav-link" href="http://localhost:8091/user/login" tabindex="-1">
				<button class="btn btn-primary">로그인</button>
			</a>
		</c:if>
		<c:if test="${user!=null}">
			<a class="nav-link" tabindex="-1">
				<div>${user.id} 님 환영합니다.</div>
			</a>
			<a class="nav-link" href="user/logout" tabindex="-1">
				<button class="btn btn-primary">로그아웃</button>
			</a>
		</c:if>
	</nav>
</body>




</html>

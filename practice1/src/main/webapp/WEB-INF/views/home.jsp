<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 다른 파일의 내용을 가져오기  -->
<%@include file="include/header.jsp"%>
<!-- jquery 사용을 위한 설정 -->
<script src="/resources/jquery/jquery.min.js"></script>
<!-- 부트스트랩을 사용하기 위한 설정 -->
<link href="/resources/bootstrap4.3.1/css/bootstrap.min.css" rel="stylesheet"
type="text/css" />

<section class="content">
<div class="box">
<div class="box-header with-border">
<a href="#"><h3 class="box-title">회원가입</h3></a>
</div>
</div>



	${insert}
	<c:if test="${insert!=null}">
		<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">회원가입 완료</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="닫기">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	       	 회원가입에 성공하셨습니다.이제 로그인하고 사용하시면 됩니다.
	      </div>
	      <div class="modal-footer">
	        
	        <button type="button" class="btn btn-primary">닫기</button>
	      </div>
	    </div>
	  </div>
	</div>
		
	</c:if>
	





</section>
<%@include file="include/footer.jsp"%>

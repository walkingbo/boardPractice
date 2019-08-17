package kr.co.myapp.service;

import javax.servlet.http.HttpServletRequest;

import kr.co.myapp.domain.User;

public interface UserService {
	//로그인 처리 
	public User login(HttpServletRequest request);
	//아이디 중복체크
	public String idcheck(String id);
	//회원가입 처리 
	public int register(HttpServletRequest request);

}

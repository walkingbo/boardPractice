package kr.co.myapp.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.myapp.domain.User;

@Repository
public class UserDao {

	@Autowired
	private SqlSession sqlSession;
	
	//로그인시 정보를 가져오기 위한 메소드 
	public User login(String id) {
		return sqlSession.selectOne("user.login",id);
		}
	
	//회원가입시 아이디 중복검사를 하기 위하 메소드
	public String idcheck(String id) {
		return sqlSession.selectOne("user.idcheck",id);
		}
	
	//회원가입을 위한 메소드 (성공 실패를 int로 받는다.)
	public int register(User user) {
		return sqlSession.insert("user.register",user);
		}

}

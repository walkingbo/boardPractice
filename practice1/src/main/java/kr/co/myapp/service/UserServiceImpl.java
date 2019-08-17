package kr.co.myapp.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.myapp.dao.UserDao;
import kr.co.myapp.domain.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public User login(HttpServletRequest request) {
		User user = null;
		try {
			request.setCharacterEncoding("utf-8");
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			// 로그인 관련된 DAO 메소드 호출 
			user = userDao.login(id);
			System.out.printf("serviceImpl에서 userid: %s\n",id);
			System.out.printf("serviceImpl에서 userpw: %s\n",pw);
			System.out.printf("메소드 호출 후 있는부분 user:%s\n", user);
			// email 에 해당하는 데이터가 있다면 
			if (user != null) {
				System.out.printf("해당데이터가 null이 아니라면 부분 user:%s\n", user);
				System.out.printf("해당데이터가 null이 아니라면 부분 user.getPW:%s\n", user.getPw());
				// 비밀번호가 일치하면 로그인 성공 
				// 그렇지 않으면 로그인 실패 
				if(pw.equals(user.getPw())){
					user.setPw(null);
					System.out.printf("해당데이터가 있는부분 user:%s\n", user);
				}else{
					System.out.printf("비밀번호가 일치하지 않은 부분 %s\n:", user.getPw());
					user = null;
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.printf("serviceimpl 마지막:%s\n",user);

		return user;
	}

	@Override
	public String idcheck(String id) {
		return userDao.idcheck(id);
	}

	@Override
	public int register(HttpServletRequest request) {
		int result = -1;
		// 파라미터 읽기 
		try {
			// 파라미터 인코딩 설정 
			request.setCharacterEncoding("utf-8");
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("realname");
			String yy = request.getParameter("yy");
			String MM = request.getParameter("MM");
			String dd = request.getParameter("dd");
			String gender = request.getParameter("gender");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			System.out.println(yy);
			System.out.println(MM);
			System.out.println(dd);
			String birth = yy + MM + dd ;
			System.out.println(birth);
			
			// DAO의 파라미터 만들기 
			User user = new User();
			// DAO 메소드 호출 
			user.setId(id);
			user.setPw(pw);
			user.setName(name);
			user.setBirth(birth);
			user.setGender(gender);
			user.setEmail(email);
			user.setPhone(phone);
			
			result = userDao.register(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

}

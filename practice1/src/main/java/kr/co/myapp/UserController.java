package kr.co.myapp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.myapp.domain.User;
import kr.co.myapp.service.UserService;

//Controller를 만들기 위한 어노테이션
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "user/register", method = RequestMethod.GET)
	public String register(Model model) {
		return "user/register";
	}
	
	@RequestMapping(value = "user/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "user/login";
	}
	
	// login.jsp 에서 login 요청을 했을 때 처리하는 메소드 
	@RequestMapping(value = "user/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpSession session, Model model, RedirectAttributes attr) {
		User user = userService.login(request);
		System.out.printf("Controller초입에서 값:%s\n",user);
		// 로그인에 실패한 경우 
		if (user == null) {
			attr.addFlashAttribute("msg", "없는 이메일 이거나 잘못된 비밀번호입니다.");
			return "redirect:login";
		} else {
			// 로그인 성공했을 때는 로그인 정보를 세션에 저장 
			session.setAttribute("user", user);
			return "redirect:/";
		}
	}
	
	//home.jsp 에서 logout 요청을 했을 때 처리하는 메소드 
	@RequestMapping(value="user/logout", method=RequestMethod.GET)
	public String logout (HttpSession session) {
	//세션 초기화 
	session.invalidate(); //session.removeAttribute("user")
	return "redirect:/";
	}
	
	
	//로그인 처리 하는 메소드 
	@RequestMapping(value="user/register", method=RequestMethod.POST)
	public String login(Model model, HttpServletRequest request, RedirectAttributes attr) {
	int result = userService.register(request);
	//회원가입에 성공한 경우 
	if(result>0) {
	System.out.printf("컨트롤러 부분 회원가입성공 :%d\n",result);
	//성공했을 메시지를 저장
	attr.addFlashAttribute("insert", "success");
	return "redirect:/";
	}else {
	return "redirect:register";
	}
	}


}

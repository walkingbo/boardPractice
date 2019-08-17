package kr.co.myapp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.myapp.domain.Reply;
import kr.co.myapp.service.ReplyService;
import kr.co.myapp.service.UserService;

@RestController
public class JSONController {
	@Autowired
	private UserService userService;
	private ReplyService replyService;
	
	//아이디 중복 검사 요청을 처리할 메소드
	@RequestMapping(value="user/idcheck",method=RequestMethod.GET)
	public Map<String,Object> idcheck(
	@RequestParam("id") String id){
	//서비스 메소드 호출 
	String result = userService.idcheck(id);
	//출력할 데이터 만들기
	Map<String,Object> map = new HashMap<String,Object>();
	//중복된 아이디가 없으면 result라는 키 true를 저장하고
	//중복된 아이디이면 result라는 키에 false 가 저장
	map.put("result", result == null);
	return map;
	}
	
	// 댓글 작성을 위한 Method
	@RequestMapping(value = "/reply/register", method = RequestMethod.GET)
	public Map<String, Object> replyRegister(HttpServletRequest request) {
		int result = replyService.register(request);
		Map<String, Object> map = new HashMap<String, Object>();
		if (result > 0) {
			map.put("result", true);
		} else {
			map.put("result", false);
		}
		return map;
}
	//글번호에 해당하는 댓글 목록을 가져오는 메소드
	@RequestMapping(value="/reply/list", method=RequestMethod.GET)
	public List<Reply> replyList(@RequestParam("bno") int bno){
	return replyService.list(bno);
	}
	
	//댓글 번호에 해당하는 댓글을 삭제하는 메소드 
	@RequestMapping(value="/reply/delete", method=RequestMethod.GET)
	public Map<String, Object> delete(@RequestParam("rno") int rno){
	int result = replyService.delete(rno);
	Map<String, Object> map = new HashMap<String,Object>();
	map.put("result", result>0);
	return map;
	}
	
	@RequestMapping(
			value="/reply/update",  method=RequestMethod.GET)
	public Map<String, Object> update(Reply reply){
		Map<String, Object> map = new HashMap<String, Object>();
		
		int result = replyService.update(reply);
		if(result > 0) {
			map.put("result",true);
		}else {
			map.put("result", false);
		}
		
		return map;
}
	
}

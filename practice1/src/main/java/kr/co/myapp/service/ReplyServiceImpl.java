package kr.co.myapp.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.myapp.dao.ReplyDao;
import kr.co.myapp.domain.Reply;
import kr.co.myapp.domain.User;
@Service
public class ReplyServiceImpl implements ReplyService {
	@Autowired
	private ReplyDao replyDao;
	
	@Override
	public int register(HttpServletRequest request) {
		int result = -1;
		// Parameter 읽어오기
		String replyText = request.getParameter("replyText");
		int bno = Integer.parseInt(request.getParameter("bno"));
		// 접속 중인 User의 Email과 Nickname 가져오기
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String id = user.getId();
		
		// DAO 매개변수 만들기
		Reply reply = new Reply();
		reply.setBno(bno);
		reply.setId(id);
		reply.setReplytext(replyText);

		result = replyDao.register(reply);

		return result;

	}

	@Override
	public List<Reply> list(int bno) {
		return replyDao.list(bno);
	}

	@Override
	public int delete(int rno) {
		return replyDao.delete(rno);
	}

	@Override
	public int update(Reply reply) {
		return replyDao.update(reply);
	}

}

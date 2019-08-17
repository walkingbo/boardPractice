package kr.co.myapp.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.myapp.dao.BoardDao;
import kr.co.myapp.domain.Board;
import kr.co.myapp.domain.SearchCriteriaEX;
import kr.co.myapp.domain.User;
import kr.co.myapp.domain.Criteria.Criteria;
import kr.co.myapp.domain.PageMaker.PageMaker;
@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public int register(HttpServletRequest request) {
		int result = -1;
		// 파라미터 읽기 
		//request.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		// ip주소 찾아오기 
		String ip = request.getRemoteAddr();
		// 로그인 한 유저의 email 찾아오기 
		User user = (User) request.getSession().getAttribute("user");
		String id = user.getId();
		// Dao 의 파라미터 만들기 
		Board board = new Board();
		if (title.trim().length() == 0) {
			title = "제목없음";
		}
		board.setTitle(title);
		if (content.trim().length() == 0) {
			content = "내용없음";
		}
		board.setContent(content);
		board.setIp(ip);
		board.setId(id);
		// Dao 메소드 호출  
		result = boardDao.register(board);

		return result;
	}
	
	/*
	@Override
	public List<Board> list() {
		List<Board> list = boardDao.list();
		// 최근의 게시판에서는 현재날짜와 동일한 날짜에 작성된 게시글들은
		// 시간을 출력하고 이전 날짜에 작성된 것들은 날짜를 출력하는 경우가 많습니다.
		// Board 객체의 dispdate 항목에 위처럼 저장 
		// 오늘날짜를 가져 오기 
		Calendar cal = new GregorianCalendar();
		java.sql.Date today = new java.sql.Date(cal.getTimeInMillis());
		// 오늘 작성된 글은 dispdate에 시간과 분을 
		// 그게 아니면 월과 일을 저장 
		for (Board board : list) {
			String regdate = board.getRegdate().toString();
			board.setTitle(board.getTitle().trim());
			if (today.toString().equals(regdate.substring(0, 10))) {
				board.setDispdate(regdate.substring(11, 16));
			} else {
				board.setDispdate(regdate.substring(5, 10));
			}
		}
		return list;

	}
	*/
	
	@Override
	public Board detail(int bno) {
		Board board = null;
		// 조회수 1 증가 
		int result = boardDao.updateReadcnt(bno);
		// 조회수 1 증가에 성공했으면 데이터를 가져오기
		if (result >= 0) {
			board = boardDao.detail(bno);
			board.setTitle(board.getTitle().trim());
			//댓글 개수를 저장 
			board.setReplycnt(boardDao.replycnt(bno));
			}
		return board;
	}

	@Override
	public Board updateView(int bno) {
		Board board = null;
		board= boardDao.detail(bno);
		if(board !=null) {
		board.setTitle(board.getTitle().trim());
		}
		return board;
		
	}

	@Override
	public int update(Board board) {
		return boardDao.update(board);
	}

	@Override
	public int delete(int bno) {
		return boardDao.delete(bno);
	}

	@Override
	public Map<String, Object> list(SearchCriteriaEX criteria) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 페이지 번호에 해당하는 데이터 목록 가져오기
		List<Board> list = boardDao.list(criteria);
		// 데이터가 1개도 없다면
		if (list.size() == 0) {
		// 페이지 번호를 출력하지 않기 위해서 페이지 번호를 하나 감소 시켜서
		// 데이터를 가져옵니다.
		criteria.setPage(criteria.getPage() - 1);
		list = boardDao.list(criteria);
		}
		// 날짜 출력 부분 설정
		// 오늘 날짜를 가져오기 - 문자열로 만들기
		Calendar cal = new GregorianCalendar();
		
		java.util.Date today = new java.sql.Date(cal.getTimeInMillis());

		System.out.println(today);
		// 오늘 작성된 글은 dispdate에 시간과 분을
		// 그게 아니면 월과 일을 저장
		for (Board board : list) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String regdate = sdf.format(board.getRegdate());
		System.out.println(regdate);
		board.setTitle(board.getTitle().trim());
		if (today.toString().equals(regdate.substring(0, 10))) {
		board.setDispdate(regdate.substring(11, 16));
		} else {
		board.setDispdate(regdate.substring(5, 10));
		}
		//글번호를 가지고 댓글 개수를 가져와서 저장하기
		board.setReplycnt(boardDao.replycnt(board.getBno()));

		}
		
		//데이터 목록을 저장
		map.put("list", list);
		System.out.println("서비스 impl부분:"+map);
		//출력할 페이지 번호 연산
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(criteria);
		pageMaker.setTotalCount(boardDao.totalCount(criteria));
		map.put("pageMaker", pageMaker);
		return map;
		}

}

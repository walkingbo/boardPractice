package kr.co.myapp.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kr.co.myapp.domain.Board;
import kr.co.myapp.domain.SearchCriteriaEX;
import kr.co.myapp.domain.Criteria.Criteria;

public interface BoardService {
		//게시글 작성 처리  
		public int register(HttpServletRequest request);
		
		//게시글 전체 목록을 가져오는 메소드 
		//public List<Board> list();
		
		//게시글 상세보기 
		public Board detail(int bno);
		
		//게시물 수정을 위해서 데이터를 찾아오는 메소드 
		public Board updateView(int bno);

		
		//게시글 수정을 위한 메소드 
		public int update(Board board);
		
		//게시글 삭제를 위한 메소드 
		public int delete(int bno);
		
		//리스트를 가져오는 메소드 
		public Map<String, Object> list(SearchCriteriaEX criteria);

}

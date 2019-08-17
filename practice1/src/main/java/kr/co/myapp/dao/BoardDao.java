package kr.co.myapp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.myapp.domain.Board;
import kr.co.myapp.domain.SearchCriteriaEX;
import kr.co.myapp.domain.Criteria.Criteria;

@Repository
public class BoardDao {
	@Autowired
	private SqlSession sqlSession;

	public int register(Board board) {
		return sqlSession.insert("board.register", board);
	}
	
	//게시글 전체를 가져오는 메소드 
	public List<Board> list(){
	return sqlSession.selectList("board.list");
	}

	//조회수를 1증가시키는 메소드 
	public int updateReadcnt(int bno) {
	return sqlSession.update("board.updatereadcnt",bno);
	}

	//글번호를 가지고 데이터를 1개 찾아오는 메소드 
	public Board detail(int bno) {
	return sqlSession.selectOne("board.detail",bno);
	}

	
	//게시글 수정을 위한 메소드 
	public int update(Board board) {
	return sqlSession.update("board.update",board);
	}
	
	//게시글 삭제를 위한 메소드 
	public int delete(int bno) {
	return sqlSession.delete("board.delete",bno);
	}
	
	//데이터 개수를 가져오는 메소드 - 페이징 구현
	public int totalCount(SearchCriteriaEX criteria) {
	return sqlSession.selectOne("board.totalCount",criteria);
	}

	public List<Board> list(SearchCriteriaEX cri){
		return sqlSession.selectList("board.list", cri);
		}

	
	//글번호에 해당하는 댓글 개수를 가져오는 메소드
	public int replycnt(int bno) {
	return sqlSession.selectOne("board.replycnt",bno);
	}

	
	
}



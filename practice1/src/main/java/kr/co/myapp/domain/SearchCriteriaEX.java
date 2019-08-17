package kr.co.myapp.domain;

import kr.co.myapp.domain.Criteria.Criteria;

public class SearchCriteriaEX extends Criteria {
	//검색조건을 저장할 변수
	private String searchType;
	//검색어를 저장할 변수
	private String keyword;
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	@Override
	public String toString() {
		return "SearchCriteriaEX [searchType=" + searchType + ", keyword=" + keyword + "]";
	}
	
}

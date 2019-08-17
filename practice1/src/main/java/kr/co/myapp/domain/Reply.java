package kr.co.myapp.domain;

public class Reply {
	private int rno;
	private String replytext;
	// Date Type은 연산할 때는 편리하지만 출력 할 때는 불편하기 때문에 String으로
	private String regdate;
	// 출력할 날짜 Format을 저장할 Property
	private String datedisp;
	private String id;
	private int bno;
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getReplytext() {
		return replytext;
	}
	public void setReplytext(String replytext) {
		this.replytext = replytext;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getDatedisp() {
		return datedisp;
	}
	public void setDatedisp(String datedisp) {
		this.datedisp = datedisp;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	@Override
	public String toString() {
		return "Reply [rno=" + rno + ", replytext=" + replytext + ", regdate=" + regdate + ", datedisp=" + datedisp
				+ ", id=" + id + ", bno=" + bno + "]";
	}
	
	
	
	
}

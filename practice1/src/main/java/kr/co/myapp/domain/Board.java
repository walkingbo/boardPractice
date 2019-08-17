package kr.co.myapp.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Board {
	
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	private int bno;
	private String title;
	private String content; 
	private int readcnt;
	private Date regdate ;
	private Date updatedate;
	private String ip;
	private String id;
	
	private String dispdate;

	private int replycnt;
	
	
	
	public int getReplycnt() {
		return replycnt;
	}

	public void setReplycnt(int replycnt) {
		this.replycnt = replycnt;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReadcnt() {
		return readcnt;
	}

	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}

	public Date getRegdate() {
		
		return regdate;
	}

	public void setRegdate(Date regdate) {
		
		this.regdate = regdate;
	}

	public Date getUpdatedate() {
		
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		
		this.updatedate = updatedate;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDispdate() {
		return dispdate;
	}

	public void setDispdate(String dispdate) {
		this.dispdate = dispdate;
	}

	@Override
	public String toString() {
		return "Board [bno=" + bno + ", title=" + title + ", content=" + content + ", readcnt=" + readcnt + ", regdate="
				+ regdate + ", updatedate=" + updatedate + ", ip=" + ip + ", id=" + id + ", dispdate=" + dispdate
				+ ", replycnt=" + replycnt + "]";
	}
	
	
	
	
	
}

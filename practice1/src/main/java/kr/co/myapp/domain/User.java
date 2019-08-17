package kr.co.myapp.domain;

public class User {
	private int regno;
	private String id;
	private String pw;
	private String name;
	private String birth;
	private String gender;
	private String email;
	private String phone;
	
	public int getRegno() {
		return regno;
	}
	public void setRegno(int regno) {
		this.regno = regno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "User [regno=" + regno + ", id=" + id + ", pw=" + pw + ", name=" + name + ", birth=" + birth
				+ ", gender=" + gender + ", email=" + email + ", phone=" + phone + "]";
	}
	
	

	
	
	//아이디, 비밀번호, 비밀번호 확인, 이름, 생년월일(선택형으로), 성별, 본인확인 이메일, 휴대전화
	
	
	
	
	
	
	
	
	
}

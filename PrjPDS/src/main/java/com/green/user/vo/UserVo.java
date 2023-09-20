package com.green.user.vo;

// UserDTO
public class UserVo {
	// Fields
	private String  userid;
	private String  passwd;
	private String  username;
	private String  email;
	private String  indate;
	
	//Constructor
	public UserVo() {}
	public UserVo(String userid, String passwd, String username, String email, String indate) {
		this.userid = userid;
		this.passwd = passwd;
		this.username = username;
		this.email = email;
		this.indate = indate;
	}
	
	// Getter / Setter
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	
	// toString
	@Override
	public String toString() {
		return "UserVo [userid=" + userid + ", passwd=" + passwd + ", username=" + username + ", email=" + email
				+ ", indate=" + indate + "]";
	}	
}

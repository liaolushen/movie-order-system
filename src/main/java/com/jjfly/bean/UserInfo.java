package com.jjfly.bean;
public class UserInfo {
	private String username;
	private String password;
	private String phone;
	//private String role;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String tel) {
		this.phone = tel;
	}

	public String toString() {
		return "username: " + username + " password: " + password;
	}
	/*public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}*/
}

package webp.four.common.Model;

import java.util.Date;

public class User {
	private int userId;
	private String userName;
	private String pass;
	private String fullName;
	private int wallet;
	private Date dob;
	private String phone;
	private String creditCard;
	private Date createDate;
	private int roleId;
	private String avatar;
	private String address;
	public User() {
		super();
	}
	public User(int userId, String userName, String pass, String fullName, int wallet, Date dob, String phone,
			String creditCard, Date createDate, int roleId, String avatar, String address) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.pass = pass;
		this.fullName = fullName;
		this.wallet = wallet;
		this.dob = dob;
		this.phone = phone;
		this.creditCard = creditCard;
		this.createDate = createDate;
		this.roleId = roleId;
		this.address = address;
		this.avatar = avatar;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address) {
		this.address =address;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getWallet() {
		return wallet;
	}
	public void setWallet(int wallet) {
		this.wallet = wallet;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
}

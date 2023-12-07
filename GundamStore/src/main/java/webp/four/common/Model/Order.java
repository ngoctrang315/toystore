package webp.four.common.Model;

import java.util.Date;

public class Order {
	private int orderId;
	private int userId;
//	private String code;
	private int total;
	private int statusId;
	private Date createDate;
	private Date latestUpdate;
	public Order() {
		super();
	}
	public Order(int orderId, int userId, int total, int statusId, Date createDate, Date latestUpdate) {
		super();
		this.orderId = orderId;
		this.userId = userId;
//		this.code = code;
		this.total = total;
		this.statusId = statusId;
		this.createDate = createDate;
		this.latestUpdate = latestUpdate;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getLatestUpdate() {
		return latestUpdate;
	}
	public void setLatestUpdate(Date latestUpdate) {
		this.latestUpdate = latestUpdate;
	}
	/*
	 * public String getCode() { return code; } public void setCode(String code) {
	 * this.code = code; }
	 */
	
}

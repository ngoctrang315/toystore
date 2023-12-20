package webp.four.common.Model;

public class OrderStatus {
	private int statusId;
	private String statusDesc;
	public OrderStatus() {
		super();
	}
	public OrderStatus(int statusId, String statusDesc) {
		super();
		this.statusId = statusId;
		this.statusDesc = statusDesc;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public String getStatusDesc() {
		return statusDesc;
	}
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}
	
}

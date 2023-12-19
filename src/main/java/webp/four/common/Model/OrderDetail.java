package webp.four.common.Model;

public class OrderDetail {
	private int orderDetailId;
	private int orderId;
	private int gunplaId;
	public OrderDetail() {
		super();
	}
	public OrderDetail(int orderDetailId, int orderId, int gunplaId) {
		super();
		this.orderDetailId = orderDetailId;
		this.orderId = orderId;
		this.gunplaId = gunplaId;
	}
	public int getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getGunplaId() {
		return gunplaId;
	}
	public void setGunplaId(int gunplaId) {
		this.gunplaId = gunplaId;
	}
	
}

package webp.four.common.Model;

public class Coupon {
	private String code;
	private float discount;
	public Coupon() {
		super();
	}
	public Coupon(String code, float discount) {
		super();
		this.code = code;
		this.discount = discount;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	
}

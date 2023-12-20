package webp.four.common.Model;

import java.util.Date;

public class Review {
	private int reviewId;
	private int userId;
	private int gunplaId;
	private int orderId;
	private String comment;
	private int rating;
	private Date createDate;
	public Review() {
		super();
	}
	public Review(int reviewId, int userId, int gunplaId, int orderId, String comment, int rating,
			Date createDate) {
		super();
		this.reviewId = reviewId;
		this.userId = userId;
		this.gunplaId = gunplaId;
		this.orderId = orderId;
		this.comment = comment;
		this.rating = rating;
		this.createDate = createDate;
	}
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getGunplaId() {
		return gunplaId;
	}
	public void setGunplaId(int gunplaId) {
		this.gunplaId = gunplaId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}

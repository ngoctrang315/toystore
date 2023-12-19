package webp.four.common.Model;

import java.util.Date;

public class Gunpla {
	private int gunplaId;
	private String gunplaName;
	private String desc;
	private int price;
	private String gradeId;
	private String image;
	private int stock;
	private Date createDate;
	private Date upadateDate;
	private byte status;
	private int storeId;
	private int ratingTotal;
	private int ratingNum;
	public Gunpla() {
		super();
	}
	public Gunpla(int gunplaId, String gunplaName, String desc, int price, String gradeId, String image, int stock,
			Date createDate, Date upadateDate, byte status,int storeId,int ratingTotal,int ratingNum) {
		super();
		this.gunplaId = gunplaId;
		this.gunplaName = gunplaName;
		this.desc = desc;
		this.price = price;
		this.gradeId = gradeId;
		this.image = image;
		this.stock = stock;
		this.createDate = createDate;
		this.upadateDate = upadateDate;
		this.status = status;
		this.storeId = storeId;
		this.ratingTotal = ratingTotal;
		this.ratingNum = ratingNum;
	}
	public int getRatingTotal() {
		return ratingTotal;
	}
	public void setRatingTotal(int ratingTotal) {
		this.ratingTotal = ratingTotal;
	}
	public int getRatingNum() {
		return ratingNum;
	}
	public void setRatingNum(int ratingNum) {
		this.ratingNum = ratingNum;
	}
	public int getGunplaId() {
		return gunplaId;
	}
	public void setGunplaId(int gunplaId) {
		this.gunplaId = gunplaId;
	}
	public String getGunplaName() {
		return gunplaName;
	}
	public void setGunplaName(String gunplaName) {
		this.gunplaName = gunplaName;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getGradeId() {
		return gradeId;
	}
	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpadateDate() {
		return upadateDate;
	}
	public void setUpadateDate(Date upadateDate) {
		this.upadateDate = upadateDate;
	}
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public float getRatingAvg()
	{
		return (float)this.ratingTotal/this.ratingNum;
	}
}

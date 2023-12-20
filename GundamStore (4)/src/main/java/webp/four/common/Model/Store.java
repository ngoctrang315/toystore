package webp.four.common.Model;

import java.util.Date;

public class Store {
	private int storeId;
	private String storeName;
	private int userId;
	private boolean isActive;
	private int wallet;
	private String bioStore;
	private Date createDate;
	public Store() {
		super();
	}
	public Store(int storeId, String storeName, int userId, boolean isActive, int wallet, String bioStore,
			Date createDate) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
		this.userId = userId;
		this.isActive = isActive;
		this.wallet = wallet;
		this.bioStore = bioStore;
		this.createDate = createDate;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public int getWallet() {
		return wallet;
	}
	public void setWallet(int wallet) {
		this.wallet = wallet;
	}
	public String getBioStore() {
		return bioStore;
	}
	public void setBioStore(String bioStore) {
		this.bioStore = bioStore;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}

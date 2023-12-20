package webp.four.common.Model;

public class FavoriteStore {
	private int ufsId;
	private int userId;
	private int storeId;
	public FavoriteStore() {
		super();
	}
	public FavoriteStore(int ufsId, int userId, int storeId) {
		super();
		this.ufsId = ufsId;
		this.userId = userId;
		this.storeId = storeId;
	}
	public int getUfsId() {
		return ufsId;
	}
	public void setUfsId(int ufsId) {
		this.ufsId = ufsId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
}

package webp.four.common.Model;

public class FavoriteGunpla {
	private int ufgId;
	private int userId;
	private int gunplaId;
	public FavoriteGunpla() {
		super();
	}
	public FavoriteGunpla(int ufgId, int userId, int gunplaId) {
		super();
		this.ufgId = ufgId;
		this.userId = userId;
		this.gunplaId = gunplaId;
	}
	public int getUfgId() {
		return ufgId;
	}
	public void setUfgId(int ufgId) {
		this.ufgId = ufgId;
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
	
}

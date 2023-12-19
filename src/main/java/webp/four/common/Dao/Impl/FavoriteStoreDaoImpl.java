package webp.four.common.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import webp.four.common.Connection.DBConnection;
import webp.four.common.Dao.Interface.IFavoriteStoreDao;
import webp.four.common.Model.FavoriteGunpla;
import webp.four.common.Model.FavoriteStore;
import webp.four.common.Model.Store;
import webp.four.common.Model.User;

public class FavoriteStoreDaoImpl extends DBConnection implements IFavoriteStoreDao {
	@Override
	public List<FavoriteStore> getFrom(User user) {
		 List<FavoriteStore> listFavS = new ArrayList<FavoriteStore>();
		
		String sql = "SELECT * FROM UserFavoriteStore where userId=?";

		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getUserId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				FavoriteStore fav  = new FavoriteStore();
				fav.setUfsId(rs.getInt("ufsId"));
				fav.setUserId(rs.getInt("userId"));
				fav.setStoreId(rs.getInt("storeId"));
				listFavS.add(fav);
			}
			conn.close();
			return listFavS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void insert(User user, Store store)
	{
		String sql = "INSERT INTO UserFavoriteStore VALUES(?,?)";

		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getUserId());
			ps.setInt(2, store.getStoreId());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

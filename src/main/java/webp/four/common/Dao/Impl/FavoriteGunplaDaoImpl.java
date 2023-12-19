package webp.four.common.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import webp.four.common.Connection.DBConnection;
import webp.four.common.Dao.Interface.IFavoriteGunplaDao;
import webp.four.common.Model.FavoriteGunpla;
import webp.four.common.Model.Gunpla;
import webp.four.common.Model.Store;
import webp.four.common.Model.User;

public class FavoriteGunplaDaoImpl extends DBConnection implements IFavoriteGunplaDao {
	@Override
	public List<FavoriteGunpla> getFrom(User user) {
		 List<FavoriteGunpla> listFavG = new ArrayList<FavoriteGunpla>();
		
		String sql = "SELECT * FROM UserFavoriteGunpla where userId=?";

		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getUserId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				FavoriteGunpla fav  = new FavoriteGunpla();
				fav.setUfgId(rs.getInt("ufgId"));
				fav.setUserId(rs.getInt("userId"));
				fav.setGunplaId(rs.getInt("gunplaId"));
				listFavG.add(fav);
			}
			conn.close();
			return listFavG;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void insert(User user, Gunpla gunpla)
	{
		String sql = "INSERT INTO UserFavoriteGunpla VALUES(?,?)";

		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getUserId());
			ps.setInt(2, gunpla.getGunplaId());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

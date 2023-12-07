package webp.four.common.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import webp.four.common.Connection.DBConnection;
import webp.four.common.Dao.Interface.IStoreDao;
import webp.four.common.Model.Grade;
import webp.four.common.Model.Gunpla;
import webp.four.common.Model.Store;
import webp.four.common.Model.User;

public class StoreDaoImpl extends DBConnection implements IStoreDao{
	@Override
	public Store get(int id) {
		Store store = new Store();
		String sql = "SELECT * FROM Store where storeId=?";

		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				store.setStoreId(rs.getInt("storeId"));
				store.setStoreName(rs.getString("storeName"));
				store.setUserId(rs.getInt("userId"));
				store.setActive(rs.getBoolean("isActive"));
				store.setWallet(rs.getInt("wallet"));
				store.setBioStore(rs.getString("bioStore"));
				store.setCreateDate(rs.getDate("createDate"));
			}
			conn.close();
			return store;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	@Override
	public void insert(Store store) {
		// TODO Auto-generated method stub
		java.time.LocalDateTime dtm = java.time.LocalDateTime.now();
		java.sql.Date date = java.sql.Date.valueOf(dtm.toLocalDate());
		String sql = "INSERT INTO Store VALUES(?,?,?,?,?,?)";

		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, store.getStoreName());
			ps.setInt(2, store.getUserId());
			ps.setInt(3,0);
			ps.setInt(4, 0);
			ps.setString(5, store.getBioStore());
			ps.setDate(6, date);
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(Store store) {
		// TODO Auto-generated method stub
		String sql = "UPDATE Store set storeName = ?, wallet = ?, bioStore = ?,createDate = ? where storeId = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, store.getStoreName());
			ps.setInt(2, store.getWallet());
			ps.setString(3, store.getBioStore());
			ps.setDate(4, new java.sql.Date(store.getCreateDate().getTime()));
			ps.setInt(5, store.getStoreId());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "Delete from Store where storeId = ?";

		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<Store> getAll() {
		// TODO Auto-generated method stub
		List<Store> stores = new ArrayList<Store>();
		String sql = "SELECT * FROM Store";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Store store = new Store();
				store.setStoreId(rs.getInt("storeId"));
				store.setStoreName(rs.getString("storeName"));
				store.setUserId(rs.getInt("userId"));
				store.setActive(rs.getBoolean("isActive"));
				store.setWallet(rs.getInt("wallet"));
				store.setBioStore(rs.getString("bioStore"));
				store.setCreateDate(rs.getDate("createDate"));
				stores.add(store);
			}
			conn.close();
			return stores;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Store> search(String keyword) {
		List<Store> stores = new ArrayList<Store>();
		String sql = "SELECT * FROM Gunpla where storeName LIKE '%"+keyword+"%' or bioStore LIKE '%"+keyword+"%'";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			//ps.setString(1, keyword);
			//ps.setString(2, keyword);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Store store = new Store();
				store.setStoreId(rs.getInt("storeId"));
				store.setStoreName(rs.getString("storeName"));
				store.setUserId(rs.getInt("userId"));
				store.setActive(rs.getBoolean("isActive"));
				store.setWallet(rs.getInt("wallet"));
				store.setBioStore(rs.getString("bioStore"));
				store.setCreateDate(rs.getDate("createDate"));
				stores.add(store);
			}
			conn.close();
			return stores;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void Active(Store store)
	{
		String sql = "UPDATE Store set isActive = ? where storeId = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setBoolean(1, true);
			ps.setInt(2, store.getStoreId());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void Deactive(Store store)
	{
		String sql = "UPDATE Store set isActive = ? where storeId = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setBoolean(1, false);
			ps.setInt(2, store.getStoreId());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public int getThisMonthJoinStore() {
		// TODO Auto-generated method stub
		Date date = new Date();  
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);

		//List<Store> stores = new ArrayList<Store>();
		int numofnewstore = 0;
		String sql = "SELECT * FROM Store WHERE MONTH(createDate) = ? and YEAR(createDate) = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, month);
			ps.setInt(2, year);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				numofnewstore = numofnewstore + 1;
			}
			conn.close();
			return numofnewstore;
		} catch (Exception e) {
				e.printStackTrace();}
		return 0;
	}

	@Override
	public void deactiveStoreOfUser(User user) {
		// TODO Auto-generated method stub
		String sql = "UPDATE Store set isActive = ? where userId = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setBoolean(1, false);
			ps.setInt(2, user.getUserId());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void editWallet(Store store) {
		// TODO Auto-generated method stub
		String sql = "UPDATE Store set wallet = ? where storeId = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, store.getWallet());
			ps.setInt(2, store.getStoreId());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public Store getStoreByUserId(int userId) {
		// TODO Auto-generated method stub
		Store store = new Store();
		String sql = "SELECT * FROM Store where userId=?";

		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				store.setStoreId(rs.getInt("storeId"));
				store.setStoreName(rs.getString("storeName"));
				store.setUserId(rs.getInt("userId"));
				store.setActive(rs.getBoolean("isActive"));
				store.setWallet(rs.getInt("wallet"));
				store.setBioStore(rs.getString("bioStore"));
				store.setCreateDate(rs.getDate("createDate"));
			}
			conn.close();
			return store;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean checkExist(int uid) {
		String sql = "SELECT COUNT(storeId) FROM Store where userId=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);
				if (count > 0)
					return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}

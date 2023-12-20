package webp.four.common.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import webp.four.common.Connection.DBConnection;
import webp.four.common.Dao.Interface.IGunplaDao;
import webp.four.common.Model.Gunpla;
import webp.four.common.Model.User;

public class GunplaDaoImpl extends DBConnection implements IGunplaDao{
	@Override
	public Gunpla get(int id) {
		Gunpla gunpla = new Gunpla();
		String sql = "SELECT * FROM Gunpla where gunplaId=?";

		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				gunpla.setGunplaId(rs.getInt("gunplaId"));
				gunpla.setGunplaName(rs.getString("gunplaName"));
				gunpla.setGradeId(rs.getString("gradeId"));
				gunpla.setDesc(rs.getString("desc"));
				gunpla.setPrice(rs.getInt("price"));
				gunpla.setImage(rs.getString("image"));
				gunpla.setStock(rs.getInt("stock"));
				gunpla.setCreateDate(rs.getDate("createDate"));
				gunpla.setUpadateDate(rs.getDate("updateDate"));
				gunpla.setStoreId(rs.getInt("storeId"));
				gunpla.setRatingTotal(rs.getInt("ratingTotal"));
				gunpla.setRatingNum(rs.getInt("ratingNumber"));
			}
			conn.close();
			return gunpla;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void insert(Gunpla gunpla) {
		// TODO Auto-generated method stub
		java.time.LocalDateTime dtm = java.time.LocalDateTime.now();
		java.sql.Date date = java.sql.Date.valueOf(dtm.toLocalDate());
		String sql = "INSERT INTO Gunpla VALUES(?,?,?,?,?,?,?,?,?,?,?)";

		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, gunpla.getGunplaName());
			ps.setString(2,gunpla.getGradeId());
			ps.setString(3, gunpla.getDesc());
			ps.setInt(4, gunpla.getPrice());
			ps.setString(5, gunpla.getImage());
			ps.setInt(6, gunpla.getStock());
			ps.setDate(7, date);
			ps.setDate(8, date);
			ps.setInt(9, gunpla.getStoreId());
			ps.setInt(10, 0);
			ps.setInt(11, 0);
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(Gunpla gunpla) {
		// TODO Auto-generated method stub
		java.time.LocalDateTime dtm = java.time.LocalDateTime.now();
		java.sql.Date date = java.sql.Date.valueOf(dtm.toLocalDate());
		String sql = "UPDATE Gunpla set gunplaName = ?, gradeId = ?,[desc] = ?,price = ?,[image] = ?,stock = ?,createDate = ?,updateDate = ?,storeId = ?,ratingTotal = ?,ratingNumber = ? where gunplaId = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, gunpla.getGunplaName());
			ps.setString(2,gunpla.getGradeId());
			ps.setString(3, gunpla.getDesc());
			ps.setInt(4, gunpla.getPrice());
			ps.setString(5, gunpla.getImage());
			ps.setInt(6, gunpla.getStock());
			ps.setDate(7, date);
			ps.setDate(8, date);
			ps.setInt(9, gunpla.getStoreId());
			ps.setInt(10, gunpla.getGunplaId());
			ps.setInt(11, gunpla.getRatingTotal());
			ps.setInt(12, gunpla.getRatingNum());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Gunpla gunpla) {
		// TODO Auto-generated method stub
		String sql = "Delete from Gunpla where gunplaId = ?";

		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, gunpla.getGunplaId());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<Gunpla> getAll() {
		// TODO Auto-generated method stub
		List<Gunpla> gunplas = new ArrayList<Gunpla>();
		String sql = "SELECT * FROM Gunpla";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Gunpla gunpla = new Gunpla();
				gunpla.setGunplaId(rs.getInt("gunplaId"));
				gunpla.setGunplaName(rs.getString("gunplaName"));
				gunpla.setGradeId(rs.getString("gradeId"));
				gunpla.setDesc(rs.getString("desc"));
				gunpla.setPrice(rs.getInt("price"));
				gunpla.setImage(rs.getString("image"));
				gunpla.setStock(rs.getInt("stock"));
				gunpla.setCreateDate(rs.getDate("createDate"));
				gunpla.setUpadateDate(rs.getDate("updateDate"));
				gunpla.setStoreId(rs.getInt("storeId"));
				gunpla.setRatingTotal(rs.getInt("ratingTotal"));
				gunpla.setRatingNum(rs.getInt("ratingNumber"));
				gunplas.add(gunpla);
			}
			conn.close();
			return gunplas;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Gunpla> search(String keyword) {
		List<Gunpla> gunplas = new ArrayList<Gunpla>();
		String sql = "SELECT * FROM Gunpla where gunplaName LIKE '%"+keyword+"%' or [desc] LIKE '%"+keyword+"%'";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			//ps.setString(1, keyword);
			//ps.setString(2, keyword);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Gunpla gunpla = new Gunpla();
				gunpla.setGunplaId(rs.getInt("gunplaId"));
				gunpla.setGunplaName(rs.getString("gunplaName"));
				gunpla.setGradeId(rs.getString("gradeId"));
				gunpla.setDesc(rs.getString("desc"));
				gunpla.setPrice(rs.getInt("price"));
				gunpla.setImage(rs.getString("image"));
				gunpla.setStock(rs.getInt("stock"));
				gunpla.setCreateDate(rs.getDate("createDate"));
				gunpla.setUpadateDate(rs.getDate("updateDate"));
				gunpla.setStoreId(rs.getInt("storeId"));
				gunpla.setRatingTotal(rs.getInt("ratingTotal"));
				gunpla.setRatingNum(rs.getInt("ratingNumber"));
				gunplas.add(gunpla);
			}
			conn.close();
			return gunplas;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Gunpla> getFrom(int id) {
		
		String sql = "SELECT * FROM Gunpla where storeId=?";
		List<Gunpla> gunplas = new ArrayList<Gunpla>();
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Gunpla gunpla = new Gunpla();
				gunpla.setGunplaId(rs.getInt("gunplaId"));
				gunpla.setGunplaName(rs.getString("gunplaName"));
				gunpla.setGradeId(rs.getString("gradeId"));
				gunpla.setDesc(rs.getString("desc"));
				gunpla.setPrice(rs.getInt("price"));
				gunpla.setImage(rs.getString("image"));
				gunpla.setStock(rs.getInt("stock"));
				gunpla.setCreateDate(rs.getDate("createDate"));
				gunpla.setUpadateDate(rs.getDate("updateDate"));
				gunpla.setStoreId(rs.getInt("storeId"));
				gunpla.setRatingTotal(rs.getInt("ratingTotal"));
				gunpla.setRatingNum(rs.getInt("ratingNumber"));
				gunplas.add(gunpla);
			}
			conn.close();
			return gunplas;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Gunpla> findAll(int page) {
		List<Gunpla> gunplas = new ArrayList<Gunpla>();
		String sql = "SELECT * FROM Gunpla ORDER BY gunplaId DESC OFFSET ? rows fetch next 6 rows only";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, page);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Gunpla gunpla = new Gunpla();
				gunpla.setGunplaId(rs.getInt("gunplaId"));
				gunpla.setGunplaName(rs.getString("gunplaName"));
				gunpla.setGradeId(rs.getString("gradeId"));
				gunpla.setDesc(rs.getString("desc"));
				gunpla.setPrice(rs.getInt("price"));
				gunpla.setImage(rs.getString("image"));
				gunpla.setStock(rs.getInt("stock"));
				gunpla.setCreateDate(rs.getDate("createDate"));
				gunpla.setUpadateDate(rs.getDate("updateDate"));
				gunpla.setStoreId(rs.getInt("storeId"));
				gunpla.setRatingTotal(rs.getInt("ratingTotal"));
				gunpla.setRatingNum(rs.getInt("ratingNumber"));
				gunplas.add(gunpla);
			}
			conn.close();
			return gunplas;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int countAll()
	{
		String sql = "SELECT count(*) FROM Gunpla";

		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			int count = 0;
			if (rs.next()) {
				count = rs.getInt(1);
			}
			conn.close();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public List<Gunpla> findNewest() {
		List<Gunpla> gunplas = new ArrayList<Gunpla>();
		String sql = "SELECT * FROM Gunpla ORDER BY gunplaId DESC OFFSET 0 rows fetch next 3 rows only";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Gunpla gunpla = new Gunpla();
				gunpla.setGunplaId(rs.getInt("gunplaId"));
				gunpla.setGunplaName(rs.getString("gunplaName"));
				gunpla.setGradeId(rs.getString("gradeId"));
				gunpla.setDesc(rs.getString("desc"));
				gunpla.setPrice(rs.getInt("price"));
				gunpla.setImage(rs.getString("image"));
				gunpla.setStock(rs.getInt("stock"));
				gunpla.setCreateDate(rs.getDate("createDate"));
				gunpla.setUpadateDate(rs.getDate("updateDate"));
				gunpla.setStoreId(rs.getInt("storeId"));
				gunpla.setRatingTotal(rs.getInt("ratingTotal"));
				gunpla.setRatingNum(rs.getInt("ratingNumber"));
				gunplas.add(gunpla);
			}
			conn.close();
			return gunplas;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Gunpla> findCheapest() {
		List<Gunpla> gunplas = new ArrayList<Gunpla>();
		String sql = "SELECT * FROM Gunpla ORDER BY price ASC OFFSET 0 rows fetch next 3 rows only";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Gunpla gunpla = new Gunpla();
				gunpla.setGunplaId(rs.getInt("gunplaId"));
				gunpla.setGunplaName(rs.getString("gunplaName"));
				gunpla.setGradeId(rs.getString("gradeId"));
				gunpla.setDesc(rs.getString("desc"));
				gunpla.setPrice(rs.getInt("price"));
				gunpla.setImage(rs.getString("image"));
				gunpla.setStock(rs.getInt("stock"));
				gunpla.setCreateDate(rs.getDate("createDate"));
				gunpla.setUpadateDate(rs.getDate("updateDate"));
				gunpla.setStoreId(rs.getInt("storeId"));
				gunpla.setRatingTotal(rs.getInt("ratingTotal"));
				gunpla.setRatingNum(rs.getInt("ratingNumber"));
				gunplas.add(gunpla);
			}
			conn.close();
			return gunplas;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public Gunpla findTopPrice() {
		Gunpla gunpla = new Gunpla();
		String sql = "SELECT * FROM Gunpla ORDER BY price DESC OFFSET 0 rows fetch next 1 rows only";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				gunpla.setGunplaId(rs.getInt("gunplaId"));
				gunpla.setGunplaName(rs.getString("gunplaName"));
				gunpla.setGradeId(rs.getString("gradeId"));
				gunpla.setDesc(rs.getString("desc"));
				gunpla.setPrice(rs.getInt("price"));
				gunpla.setImage(rs.getString("image"));
				gunpla.setStock(rs.getInt("stock"));
				gunpla.setCreateDate(rs.getDate("createDate"));
				gunpla.setUpadateDate(rs.getDate("updateDate"));
				gunpla.setStoreId(rs.getInt("storeId"));
				gunpla.setRatingTotal(rs.getInt("ratingTotal"));
				gunpla.setRatingNum(rs.getInt("ratingNumber"));
			}
			conn.close();
			return gunpla;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Gunpla> findAll(int page, String gid) {
		List<Gunpla> gunplas = new ArrayList<Gunpla>();
		String sql = "SELECT * FROM Gunpla where gradeId =? ORDER BY gunplaId DESC OFFSET ? rows fetch next 6 rows only";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(2, page);
			ps.setString(1, gid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Gunpla gunpla = new Gunpla();
				gunpla.setGunplaId(rs.getInt("gunplaId"));
				gunpla.setGunplaName(rs.getString("gunplaName"));
				gunpla.setGradeId(rs.getString("gradeId"));
				gunpla.setDesc(rs.getString("desc"));
				gunpla.setPrice(rs.getInt("price"));
				gunpla.setImage(rs.getString("image"));
				gunpla.setStock(rs.getInt("stock"));
				gunpla.setCreateDate(rs.getDate("createDate"));
				gunpla.setUpadateDate(rs.getDate("updateDate"));
				gunpla.setStoreId(rs.getInt("storeId"));
				gunpla.setRatingTotal(rs.getInt("ratingTotal"));
				gunpla.setRatingNum(rs.getInt("ratingNumber"));
				gunplas.add(gunpla);
			}
			conn.close();
			return gunplas;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int countAll(String gid)
	{
		String sql = "SELECT count(*) FROM Gunpla where gradeId = ?";

		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, gid);
			ResultSet rs = ps.executeQuery();
			int count = 0;
			if (rs.next()) {
				
				count = rs.getInt(1);
			}
			conn.close();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public List<Gunpla> search(String keyword, int page) {
		List<Gunpla> gunplas = new ArrayList<Gunpla>();
		String sql = "SELECT * FROM Gunpla where gunplaName LIKE '%"+keyword+"%' or [desc] LIKE '%"+keyword+"%' ORDER BY gunplaId DESC OFFSET ? rows fetch next 6 rows only";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, page);
			//ps.setString(2, keyword);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Gunpla gunpla = new Gunpla();
				gunpla.setGunplaId(rs.getInt("gunplaId"));
				gunpla.setGunplaName(rs.getString("gunplaName"));
				gunpla.setGradeId(rs.getString("gradeId"));
				gunpla.setDesc(rs.getString("desc"));
				gunpla.setPrice(rs.getInt("price"));
				gunpla.setImage(rs.getString("image"));
				gunpla.setStock(rs.getInt("stock"));
				gunpla.setCreateDate(rs.getDate("createDate"));
				gunpla.setUpadateDate(rs.getDate("updateDate"));
				gunpla.setStoreId(rs.getInt("storeId"));
				gunpla.setRatingTotal(rs.getInt("ratingTotal"));
				gunpla.setRatingNum(rs.getInt("ratingNumber"));
				gunplas.add(gunpla);
			}
			conn.close();
			return gunplas;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int countAllKey(String keyword)
	{
		String sql = "SELECT count(*) FROM Gunpla where gunplaName LIKE '%" + keyword+"%' or [desc] LIKE '%"+keyword+"%'";

		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			//ps.setString(1, gid);
			ResultSet rs = ps.executeQuery();
			int count = 0;
			if (rs.next()) {
				count = rs.getInt(1);
			}
			conn.close();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public List<Gunpla> getAllGunplaOfStore(int storeId) {
		// TODO Auto-generated method stub
		List<Gunpla> gunplas = new ArrayList<Gunpla>();
		String sql = "SELECT * FROM Gunpla WHERE storeId = ? ";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, storeId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Gunpla gunpla = new Gunpla();
				gunpla.setGunplaId(rs.getInt("gunplaId"));
				gunpla.setGunplaName(rs.getString("gunplaName"));
				gunpla.setGradeId(rs.getString("gradeId"));
				gunpla.setDesc(rs.getString("desc"));
				gunpla.setPrice(rs.getInt("price"));
				gunpla.setImage(rs.getString("image"));
				gunpla.setStock(rs.getInt("stock"));
				gunpla.setCreateDate(rs.getDate("createDate"));
				gunpla.setUpadateDate(rs.getDate("updateDate"));
				gunpla.setStoreId(rs.getInt("storeId"));
				gunpla.setRatingTotal(rs.getInt("ratingTotal"));
				gunpla.setRatingNum(rs.getInt("ratingNumber"));
				gunplas.add(gunpla);
			}
			conn.close();
			return gunplas;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

package webp.four.common.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import webp.four.common.Connection.DBConnection;
import webp.four.common.Dao.Interface.IUserDao;
import webp.four.common.Model.User;

public class UserDaoImpl extends DBConnection implements IUserDao {
	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO Users VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPass());
			ps.setString(3, user.getFullName());
			ps.setInt(4, user.getWallet());
			ps.setDate(5, new java.sql.Date(user.getDob().getTime()));
			ps.setString(6, user.getAddress());
			ps.setString(7, user.getPhone());
			ps.setString(8, user.getCreditCard());
			ps.setDate(9, new java.sql.Date(user.getCreateDate().getTime()));
			ps.setInt(10, user.getRoleId());
			ps.setString(11, user.getAvatar());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(User user) {
		// TODO Auto-generated method stub
		String sql = "UPDATE Users set pass = ?, fullName = ?,wallet = ?,dob = ?,address = ?,phone = ?,creditCard = ?,createDate = ?,roleId = ?,avatar = ? where userName = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getPass());
			ps.setString(2, user.getFullName());
			ps.setInt(3, user.getWallet());
			ps.setDate(4, new java.sql.Date(user.getDob().getTime()));
			ps.setString(5, user.getAddress());
			ps.setString(6, user.getPhone());
			ps.setString(7, user.getCreditCard());
			ps.setDate(8, new java.sql.Date(user.getCreateDate().getTime()));
			ps.setInt(9, user.getRoleId());
			ps.setString(10, user.getAvatar());
			ps.setString(11, user.getUserName());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String username) {
		// TODO Auto-generated method stub
		String sql = "Delete from Users where userName = ?";

		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public User get(String username) {
		User user = new User();
		String sql = "SELECT * FROM Users where userName=?";

		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user.setUserId(rs.getInt("userId"));
				user.setUserName(username);
				user.setPass(rs.getString("pass"));
				user.setFullName(rs.getString("fullName"));
				user.setWallet(rs.getInt("wallet"));
				user.setDob(rs.getDate("dob"));
				user.setAddress(rs.getString("address"));
				user.setPhone(rs.getString("phone"));
				user.setCreditCard(rs.getString("creditCard"));
				user.setCreateDate(rs.getDate("createDate"));
				user.setRoleId(rs.getInt("roleId"));
				user.setAvatar(rs.getString("avatar"));
			}
			conn.close();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<User>();
		String sql = "SELECT * FROM Users";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt("userId"));
				user.setUserName(rs.getString("userName"));
				user.setPass(rs.getString("pass"));
				user.setFullName(rs.getString("fullName"));
				user.setWallet(rs.getInt("wallet"));
				user.setDob(rs.getDate("dob"));
				user.setAddress(rs.getString("address"));
				user.setPhone(rs.getString("phone"));
				user.setCreditCard(rs.getString("creditCard"));
				user.setCreateDate(rs.getDate("createDate"));
				user.setRoleId(rs.getInt("roleId"));
				user.setAvatar(rs.getString("avatar"));
				users.add(user);
			}
			conn.close();
			return users;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> search(String keyword) {
		List<User> users = new ArrayList<User>();
		String sql = "SELECT * FROM Users where userName LIKE %?% or fullName LIKE %?%";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, keyword);
			ps.setString(2, keyword);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt("userId"));
				user.setUserName(rs.getString("userName"));
				user.setPass(rs.getString("pass"));
				user.setFullName(rs.getString("fullName"));
				user.setWallet(rs.getInt("wallet"));
				user.setDob(rs.getDate("dob"));
				user.setAddress(rs.getString("address"));
				user.setPhone(rs.getString("phone"));
				user.setCreditCard(rs.getString("creditCard"));
				user.setCreateDate(rs.getDate("createDate"));
				user.setRoleId(rs.getInt("roleId"));
				user.setAvatar(rs.getString("avatar"));
				users.add(user);
			}
			conn.close();
			return users;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User get(int id) {
		User user = new User();
		String sql = "SELECT * FROM Users where userId=?";

		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user.setUserId(rs.getInt("userId"));
				user.setUserName(rs.getString("userName"));
				user.setPass(rs.getString("pass"));
				user.setFullName(rs.getString("fullName"));
				user.setWallet(rs.getInt("wallet"));
				user.setDob(rs.getDate("dob"));
				user.setAddress(rs.getString("address"));
				user.setPhone(rs.getString("phone"));
				user.setCreditCard(rs.getString("creditCard"));
				user.setCreateDate(rs.getDate("createDate"));
				user.setRoleId(rs.getInt("roleId"));
				user.setAvatar(rs.getString("avatar"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean checkExist(String username) {
		String sql = "SELECT COUNT(userName) FROM Users where userName=?";

		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
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

	@Override
	public List<String> getAllUserName() {
		// TODO Auto-generated method stub
		List<String> allUserName = new ArrayList<String>();
		String sql = "SELECT * FROM Users";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				allUserName.add(rs.getString("userName"));
			}
			conn.close();
			return allUserName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int getThisMonthJoinUser() {
		// TODO Auto-generated method stub
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);

//		List<User> users = new ArrayList<User>();
		int numofnewuser = 0;
		String sql = "SELECT * FROM Users WHERE MONTH(createDate) = ? and YEAR(createDate) = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, month);
			ps.setInt(2, year);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				numofnewuser = numofnewuser + 1;
			}
			conn.close();
			return numofnewuser;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void promote(int userId) {
		// TODO Auto-generated method stub
		String sql = "UPDATE Users set roleId = ? where userId = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, 1);
			ps.setInt(2, userId);
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

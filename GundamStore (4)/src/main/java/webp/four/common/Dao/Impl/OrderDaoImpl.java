package webp.four.common.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import webp.four.common.Connection.DBConnection;
import webp.four.common.Dao.Interface.IOrderDao;
import webp.four.common.Model.Grade;
import webp.four.common.Model.Order;
import webp.four.common.Model.User;

public class OrderDaoImpl extends DBConnection implements IOrderDao{

	@Override
	public void insert(Order newOrder) {
		// TODO Auto-generated method stub
		java.time.LocalDateTime dtm = java.time.LocalDateTime.now();
		java.sql.Date date = java.sql.Date.valueOf(dtm.toLocalDate());
		
		String sql = "INSERT INTO [Order] ( userId,  total, statusId, createDate, latestUpdate) VALUES (?,?,?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			//ps.setInt(1, newOrder.getOrderId());
			ps.setInt(1, newOrder.getUserId());
			//ps.setString(2, null);
			ps.setInt(2, newOrder.getTotal());
			ps.setInt(3, 1);
			ps.setDate(4, date);
			ps.setDate(5,date);
			ps.executeUpdate();
			con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	@Override
	public void update(Order order) {
		// TODO Auto-generated method stub
		java.time.LocalDateTime dtm = java.time.LocalDateTime.now();  
		java.sql.Date date = java.sql.Date.valueOf(dtm.toLocalDate());
		
		String sql = "UPDATE [Order] SET userId = ?,  total = ?, statusId = ?, latestUpdate = ? WHERE orderId = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, order.getUserId());
			//ps.setString(2, order.getCode());
			ps.setInt(2, order.getTotal());
			ps.setInt(3, order.getStatusId());
			ps.setDate(4, date);
			ps.setInt(5, order.getOrderId());
			ps.executeUpdate();
			con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}


	@Override
	public void delete(Order order) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM [Order] WHERE orderId = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, order.getOrderId());
			ps.executeUpdate();
			con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	@Override
	public int thisMonthRevenue() {
		// TODO Auto-generated method stub
		Date date = new Date();  
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);
		
		//List<Order> orders = new ArrayList<Order>();
		int revenue = 0;
		String sql = "SELECT * FROM [Order] WHERE MONTH(createDate) = ? and YEAR(createDate) = ? and statusId = 2";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, month);
			ps.setInt(2, year);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				//Order order = new Order();
				//orders.add(order);
				revenue = revenue + rs.getInt("total");
			}
			conn.close();
			return revenue;
		} catch (Exception e) {
				e.printStackTrace();}
		return 0;
	}
	
	@Override
	public void updateOrderStatus(int status, Order order) {
		// TODO Auto-generated method stub
		// status id = 1 : Ready for dispatch
		//             = 2 : Partially dispatched
		//             = 3 : Delivered
		// -----------------------------
		// Create order : default status = 1
		// Vendor update : status = 2
		// User update : status = 3
		String sql = "UPDATE [Order] SET statusId = ? WHERE orderId = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, status);
			ps.setInt(2, order.getOrderId());
			ps.executeUpdate();
			conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	@Override
	public List<Order> getAllUserOrder(int userId) {
		// TODO Auto-generated method stub
		List<Order> orders = new ArrayList<Order>();
		String sql = "SELECT * FROM [Order] WHERE userId = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setCreateDate(rs.getDate("createDate"));
				order.setLatestUpdate(rs.getDate("latestUpdate"));
				order.setOrderId(rs.getInt("orderId"));
				order.setStatusId(rs.getInt("statusId"));
				order.setTotal(rs.getInt("total"));
				//order.setCode(rs.getString("code"));
				order.setUserId(rs.getInt("userId"));
				orders.add(order);
			}
			conn.close();
			return orders;
		} catch (Exception e) {
				e.printStackTrace();}
		return null;
	}

	@Override
	public List<Order> getAllStoreOrder(int storeId) {
		// TODO Auto-generated method stub
		List<Order> orders = new ArrayList<Order>();
		String sql = "SELECT * FROM [Order]\r\n"
				+ "WHERE [Order].orderId in ( SELECT OrderDetail.orderId FROM OrderDetail join (SELECT Store.storeId,Gunpla.gunplaId FROM Store join Gunpla \r\n"
				+ "															on Store.storeId = Gunpla.storeId\r\n"
				+ "															WHERE Store.storeId = ?) as gunplaofstore\r\n"
				+ "							on OrderDetail.gunplaId = gunplaofstore.gunplaId)";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, storeId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setCreateDate(rs.getDate("createDate"));
				order.setLatestUpdate(rs.getDate("latestUpdate"));
				order.setOrderId(rs.getInt("orderId"));
				order.setStatusId(rs.getInt("statusId"));
				order.setTotal(rs.getInt("total"));
				//order.setCode(rs.getString("code"));
				order.setUserId(rs.getInt("userId"));
				orders.add(order);
			}
			conn.close();
			return orders;
		} catch (Exception e) {
				e.printStackTrace();}
		return null;
	}

	@Override
	public Order get(int orderId) {
		// TODO Auto-generated method stub
		Order order = new Order();
		String sql = "SELECT * FROM [Order] WHERE orderId = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, orderId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				order.setOrderId(rs.getInt("orderId"));
				order.setUserId(rs.getInt("userId"));
			//	order.setCode(rs.getString("code"));
				order.setTotal(rs.getInt("total"));
				order.setStatusId(rs.getInt("statusId"));
				order.setCreateDate(rs.getDate("createDate"));
				order.setLatestUpdate(rs.getDate("latestUpdate"));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return order;
	}

	@Override
	public List<Order> getAll() {
		// TODO Auto-generated method stub
		List<Order> orders = new ArrayList<Order>();
		String sql = "SELECT * FROM [Order]";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setOrderId(rs.getInt("orderId"));
				order.setUserId(rs.getInt("userId"));
				//order.setCode(rs.getString("code"));
				order.setTotal(rs.getInt("total"));
				order.setStatusId(rs.getInt("statusId"));
				order.setCreateDate(rs.getDate("createDate"));
				order.setLatestUpdate(rs.getDate("latestUpdate"));
				orders.add(order);
			}
			conn.close();
			return orders;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Order getUserOrder(int userId) {
		// TODO Auto-generated method stub
		Order order = new Order();
		String sql = "SELECT * FROM [Order] WHERE userId = ? and statusId = 1";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				order.setOrderId(rs.getInt("orderId"));
				order.setUserId(rs.getInt("userId"));
				//order.setCode(rs.getString("code"));
				order.setTotal(rs.getInt("total"));
				order.setStatusId(rs.getInt("statusId"));
				order.setCreateDate(rs.getDate("createDate"));
				order.setLatestUpdate(rs.getDate("latestUpdate"));
			}
			conn.close();
			return order;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

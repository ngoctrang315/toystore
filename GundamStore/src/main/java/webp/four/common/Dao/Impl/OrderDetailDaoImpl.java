package webp.four.common.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import webp.four.common.Connection.DBConnection;
import webp.four.common.Dao.Interface.IOrderDetailDao;
import webp.four.common.Model.Grade;
import webp.four.common.Model.Order;
import webp.four.common.Model.OrderDetail;

public class OrderDetailDaoImpl extends DBConnection implements IOrderDetailDao{

	@Override
	public void insert(OrderDetail newOrderDetail) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO OrderDetail (orderId, gunplaId) VALUES (?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, newOrderDetail.getOrderId());
			ps.setInt(2, newOrderDetail.getGunplaId());
			ps.executeUpdate();
			con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	@Override
	public void update(OrderDetail newOrderDetail) {
		// TODO Auto-generated method stub
		String sql = "UPDATE OrderDetail SET userId = ?, gunplaId = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, newOrderDetail.getOrderId());
			ps.setInt(2, newOrderDetail.getGunplaId());
			ps.executeUpdate();
			con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	@Override
	public void delete(OrderDetail newOrderDetail) {
		// TODO Auto-generated method stub
		String sql = "Delete from OrderDetail where orderDetailId = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, newOrderDetail.getOrderDetailId());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public OrderDetail get(int orderDetailId) {
		// TODO Auto-generated method stub
		OrderDetail orderDetail = new OrderDetail();
		String sql = "SELECT * FROM OrderDetail where orderDetailId=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, orderDetailId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				orderDetail.setOrderDetailId(rs.getInt("orderDetailId"));
				orderDetail.setOrderId(rs.getInt("orderId"));
				orderDetail.setGunplaId(rs.getInt("gunplaId"));
			}
			conn.close();
			return orderDetail;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<OrderDetail> getAll() {
		// TODO Auto-generated method stub
		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		String sql = "SELECT * FROM Grade";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setOrderDetailId(rs.getInt("orderDetailId"));
				orderDetail.setOrderId(rs.getInt("orderId"));
				orderDetail.setGunplaId(rs.getInt("gunplaId"));
				orderDetails.add(orderDetail);
			}
			conn.close();
			return orderDetails;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<OrderDetail> getAllOrderDetailOfOrder(int orderId) {
		// TODO Auto-generated method stub
		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		String sql = "SELECT * FROM OrderDetail where orderId=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, orderId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setOrderDetailId(rs.getInt("orderDetailId"));
				orderDetail.setOrderId(rs.getInt("orderId"));
				orderDetail.setGunplaId(rs.getInt("gunplaId"));
				orderDetails.add(orderDetail);
			}
			conn.close();
			return orderDetails;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

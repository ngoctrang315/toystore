package webp.four.common.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import webp.four.common.Connection.DBConnection;
import webp.four.common.Dao.Interface.IOrderStatusDao;
import webp.four.common.Model.OrderStatus;

public class OrderStatusDaoImpl extends DBConnection implements IOrderStatusDao {

	@Override
	public String getStatus(int statusId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM [Status] WHERE statusId=?";

		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, statusId);
			ResultSet rs = ps.executeQuery();
			OrderStatus status = new OrderStatus();
			while (rs.next()) {
				status.setStatusId(rs.getInt("statusId"));
				status.setStatusDesc(rs.getString("statusDesc"));
			}
			conn.close();
			return status.getStatusDesc();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

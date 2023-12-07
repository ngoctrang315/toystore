package webp.four.common.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import webp.four.common.Connection.DBConnection;
import webp.four.common.Dao.Interface.IRoleDao;
import webp.four.common.Model.Role;

public class RoleDaoImpl extends DBConnection implements IRoleDao {
	@Override
	public Role get(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM Role WHERE roleId=?";

		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Role role = new Role();
			while (rs.next()) {
				role.setRoleId(rs.getInt("roleId"));
				role.setRoleName(rs.getString("roleName"));
			}
			conn.close();
			return role;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

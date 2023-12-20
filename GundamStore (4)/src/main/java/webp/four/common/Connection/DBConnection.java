package webp.four.common.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import webp.four.common.Model.Gunpla;
import webp.four.common.Model.User;
import webp.four.common.Service.Impl.GunplaServiceImpl;
import webp.four.common.Service.Impl.UserServiceImpl;
import webp.four.common.Service.Interface.IGunplaService;
import webp.four.common.Service.Interface.IUserService;

public class DBConnection {
	public static Connection getConnection()
			throws ClassNotFoundException, SQLException {
			return SQLServerConnection.initializeDatabase();
		}
}
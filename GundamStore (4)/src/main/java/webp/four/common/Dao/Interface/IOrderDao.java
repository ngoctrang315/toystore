package webp.four.common.Dao.Interface;

import java.util.List;

import webp.four.common.Model.Order;
import webp.four.common.Model.User;

public interface IOrderDao {
	void insert(Order newOrder);
	
	void update(Order order);
	
	void delete(Order order);
	
	int thisMonthRevenue();
	
	void updateOrderStatus(int status, Order order);
	
	List<Order> getAllUserOrder(int userId);
	
	List<Order> getAllStoreOrder(int storeId);
	
	List<Order> getAll();
	
	Order getUserOrder(int userId);
	
	Order get(int orderId);
}

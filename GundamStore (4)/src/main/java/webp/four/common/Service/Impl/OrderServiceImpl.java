package webp.four.common.Service.Impl;

import java.util.List;

import webp.four.common.Dao.Impl.OrderDaoImpl;
import webp.four.common.Model.Order;
import webp.four.common.Service.Interface.IOrderService;

public class OrderServiceImpl implements IOrderService{
	private OrderDaoImpl orderDao = new OrderDaoImpl();
	
	@Override
	public void insert(Order newOrder) {
		// TODO Auto-generated method stub
		orderDao.insert(newOrder);
	}

	@Override
	public void update(Order order) {
		// TODO Auto-generated method stub
		orderDao.update(order);
	}

	@Override
	public void delete(Order order) {
		// TODO Auto-generated method stub
		orderDao.delete(order);
	}

	@Override
	public int thisMonthRevenue() {
		// TODO Auto-generated method stub
		return orderDao.thisMonthRevenue();
	}

	@Override
	public void updateOrderStatus(int status, Order order) {
		// TODO Auto-generated method stub
		orderDao.updateOrderStatus(status, order);
	}

	@Override
	public List<Order> getAllUserOrder(int userId) {
		// TODO Auto-generated method stub
		return orderDao.getAllUserOrder(userId);
	}

	@Override
	public List<Order> getAllStoreOrder(int storeId) {
		// TODO Auto-generated method stub
		return orderDao.getAllStoreOrder(storeId);
	}

	@Override
	public List<Order> getAll() {
		// TODO Auto-generated method stub
		return orderDao.getAll();
	}

	@Override
	public Order get(int orderId) {
		// TODO Auto-generated method stub
		return orderDao.get(orderId);
	}

	@Override
	public Order getUserOrder(int userId) {
		// TODO Auto-generated method stub
		return orderDao.getUserOrder(userId);
	}

}

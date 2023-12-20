package webp.four.common.Service.Impl;

import java.util.List;

import webp.four.common.Dao.Impl.OrderDetailDaoImpl;
import webp.four.common.Model.OrderDetail;
import webp.four.common.Service.Interface.IOrderDetailService;

public class OrderDetailServiceImpl implements IOrderDetailService {
	private OrderDetailDaoImpl orderDetailDao = new OrderDetailDaoImpl();
	
	@Override
	public void insert(OrderDetail newOrderDetail) {
		// TODO Auto-generated method stub
		orderDetailDao.insert(newOrderDetail);
	}

	@Override
	public void update(OrderDetail newOrderDetail) {
		// TODO Auto-generated method stub
		orderDetailDao.update(newOrderDetail); 
	}

	@Override
	public void delete(OrderDetail newOrderDetail) {
		// TODO Auto-generated method stub
		orderDetailDao.delete(newOrderDetail);
	}

	@Override
	public OrderDetail get(int orderDetailId) {
		// TODO Auto-generated method stub
		return orderDetailDao.get(orderDetailId);
	}

	@Override
	public List<OrderDetail> getAll() {
		// TODO Auto-generated method stub
		return orderDetailDao.getAll();
	}

	@Override
	public List<OrderDetail> getAllOrderDetailOfOrder(int orderId) {
		// TODO Auto-generated method stub
		return orderDetailDao.getAllOrderDetailOfOrder(orderId);
	}

}

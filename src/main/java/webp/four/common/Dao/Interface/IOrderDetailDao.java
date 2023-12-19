package webp.four.common.Dao.Interface;

import java.util.List;

import webp.four.common.Model.Order;
import webp.four.common.Model.OrderDetail;

public interface IOrderDetailDao {
	void insert(OrderDetail newOrderDetail);
	
	void update(OrderDetail newOrderDetail);
	
	void delete(OrderDetail newOrderDetail);
	
	OrderDetail get(int orderDetailId);
	
	List<OrderDetail> getAll();
	
	List<OrderDetail> getAllOrderDetailOfOrder(int orderId);
}

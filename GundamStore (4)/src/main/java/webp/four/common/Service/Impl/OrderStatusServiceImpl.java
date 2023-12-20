package webp.four.common.Service.Impl;

import webp.four.common.Dao.Impl.OrderStatusDaoImpl;
import webp.four.common.Dao.Interface.IOrderStatusDao;
import webp.four.common.Service.Interface.IOrderStatusService;

public class OrderStatusServiceImpl implements IOrderStatusService{
	IOrderStatusDao ordStatusDao = new OrderStatusDaoImpl();
	@Override
	public String getStatus(int statusId) {
		// TODO Auto-generated method stub
		return ordStatusDao.getStatus(statusId);
	}

}

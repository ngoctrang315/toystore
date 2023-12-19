package webp.four.common.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webp.four.common.Model.Gunpla;
import webp.four.common.Model.Order;
import webp.four.common.Model.OrderDetail;
import webp.four.common.Model.Store;
import webp.four.common.Model.User;
import webp.four.common.Service.Impl.GunplaServiceImpl;
import webp.four.common.Service.Impl.OrderDetailServiceImpl;
import webp.four.common.Service.Impl.OrderServiceImpl;
import webp.four.common.Service.Impl.OrderStatusServiceImpl;
import webp.four.common.Service.Impl.StoreServiceImpl;
import webp.four.common.Service.Interface.IGunplaService;
import webp.four.common.Service.Interface.IOrderDetailService;
import webp.four.common.Service.Interface.IOrderService;
import webp.four.common.Service.Interface.IOrderStatusService;
import webp.four.common.Service.Interface.IStoreService;

@WebServlet(urlPatterns = {"/user-orders", "/store-orders", "/user-order-detail", "/store-order-detail"})
public class OrderController extends HttpServlet  {
	private IOrderService orderService = new OrderServiceImpl();
	private IOrderDetailService ordDetailService = new OrderDetailServiceImpl();
	private IGunplaService gunplaService = new GunplaServiceImpl();
	private IOrderStatusService ordStatusService = new OrderStatusServiceImpl();
	private IStoreService storeService = new StoreServiceImpl();
	private int currentOrderId;
	/**
	 * 
	 */
	private static final long serialVersionUID = -4859365763706605865L;
	HttpSession session = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String url = req.getRequestURL().toString();
		session = req.getSession();
		session.setMaxInactiveInterval(-1);
		if(url.contains("user-order-detail"))
		{
			currentOrderId = Integer.parseInt(req.getParameter("userorderid"));
			Order currentOrder = orderService.get(currentOrderId);
			List<OrderDetail> orderDetailList = ordDetailService.getAllOrderDetailOfOrder(currentOrderId);
			List<String[]> orderDetailOfOrder = new ArrayList<String[]>();
			for(OrderDetail ordD : orderDetailList)
			{
				Gunpla tempGunpla = gunplaService.get(ordD.getGunplaId());
				String[] product = new String[4];
				//System.out.println("Order Detail ID = " + ordD.getOrderDetailId() + "  - Order ID : " + ordD.getOrderId() + "  - Gunpla ID : " + ordD.getGunplaId());
				product[0] = Integer.toString(ordD.getOrderId());
				product[1] = tempGunpla.getGunplaName();
				product[2] = Integer.toString(tempGunpla.getPrice());
				product[3] = ordStatusService.getStatus(currentOrder.getStatusId());
				orderDetailOfOrder.add(product);
			}
			req.setAttribute("listofuserorderdetail", orderDetailOfOrder);
			RequestDispatcher rq = req.getRequestDispatcher("views/user/userorderdetail.jsp");
			rq.forward(req, resp);
		}
		else if(url.contains("user-orders"))
		{
			User currentUser = (User) session.getAttribute("user");
			List<Order> userorders = orderService.getAllUserOrder(currentUser.getUserId());
			req.setAttribute("listofuserorder", userorders);
			RequestDispatcher rq = req.getRequestDispatcher("views/user/userorders.jsp");
			rq.forward(req, resp);
		}
		else if(url.contains("store-order-detail"))
		{
			currentOrderId = Integer.parseInt(req.getParameter("storeorderid"));
			Order currentOrder = orderService.get(currentOrderId);
			List<OrderDetail> orderDetailList = ordDetailService.getAllOrderDetailOfOrder(currentOrderId);
			List<String[]> orderDetailOfOrder = new ArrayList<String[]>();
			for(OrderDetail ordD : orderDetailList)
			{
				Gunpla tempGunpla = gunplaService.get(ordD.getGunplaId());
				String[] product = new String[4];
				//System.out.println("Order Detail ID = " + ordD.getOrderDetailId() + "  - Order ID : " + ordD.getOrderId() + "  - Gunpla ID : " + ordD.getGunplaId());
				product[0] = Integer.toString(ordD.getOrderId());
				product[1] = tempGunpla.getGunplaName();
				product[2] = Integer.toString(tempGunpla.getPrice());
				product[3] = ordStatusService.getStatus(currentOrder.getStatusId());
				orderDetailOfOrder.add(product);
			}
			req.setAttribute("listofstoreorderdetail", orderDetailOfOrder);
			RequestDispatcher rq = req.getRequestDispatcher("views/user/storeorderdetail.jsp");
			rq.forward(req, resp);
		}
		else if(url.contains("store-orders"))
		{
			//int storeId = 1;
			User currentUser = (User) session.getAttribute("user");
			Store storeOfUser = storeService.getStoreByUserId(currentUser.getUserId());
//			System.out.println(currentUser.getUserName());
//			
//			System.out.println(storeOfUser.getStoreName());
//			
//			System.out.println(storeOfUser.getStoreId());
			
			List<Order> storeorders = orderService.getAllStoreOrder(storeOfUser.getStoreId());
			req.setAttribute("listofstoreorder", storeorders);
			RequestDispatcher rq = req.getRequestDispatcher("views/user/storeorders.jsp");
			rq.forward(req, resp);
			//RequestDispatcher rq = req.getRequestDispatcher("views/user/storeorders.jsp");
			//rq.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String url = req.getRequestURL().toString();
		if(url.contains("user-order-detail"))
		{
			if(req.getParameter("confirm-purchase") != null)
			{
				//int orderid = Integer.parseInt(req.getParameter("orderidindetail"));
				//System.out.println(currentOrderId);
				Order currentOrder = orderService.get(currentOrderId);
				if(currentOrder.getStatusId() == 3)
				{
					orderService.updateOrderStatus(4,currentOrder);
				}
				
				User currentUser = (User) session.getAttribute("user");
				List<Order> userorders = orderService.getAllUserOrder(currentUser.getUserId());
				req.setAttribute("listofuserorder", userorders);
				RequestDispatcher rq = req.getRequestDispatcher("views/user/userorders.jsp");
				rq.forward(req, resp);
			}
		}
		else if(url.contains("store-order-detail"))
		{
			if(req.getParameter("confirm-dispatched") != null)
			{
				Order currentOrder = orderService.get(currentOrderId);
				if(currentOrder.getStatusId() == 2)
				{
					orderService.updateOrderStatus(3,currentOrder);
				}
				
				User currentUser = (User) session.getAttribute("user");
				Store storeOfUser = storeService.getStoreByUserId(currentUser.getUserId());
				//System.out.println(storeOfUser.getStoreId());
				List<Order> storeorders = orderService.getAllStoreOrder(storeOfUser.getStoreId());
				req.setAttribute("listofstoreorder", storeorders);
				RequestDispatcher rq = req.getRequestDispatcher("views/user/storeorders.jsp");
				rq.forward(req, resp);
			}
		}
	}
	
}

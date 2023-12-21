package webp.four.common.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webp.four.common.Model.Grade;
import webp.four.common.Model.Gunpla;
import webp.four.common.Model.Order;
import webp.four.common.Model.OrderDetail;
import webp.four.common.Model.User;
import webp.four.common.Service.Impl.GradeServiceImpl;
import webp.four.common.Service.Impl.GunplaServiceImpl;
import webp.four.common.Service.Impl.OrderDetailServiceImpl;
import webp.four.common.Service.Impl.OrderServiceImpl;
import webp.four.common.Service.Impl.UserServiceImpl;
import webp.four.common.Service.Interface.IGradeService;
import webp.four.common.Service.Interface.IGunplaService;
import webp.four.common.Service.Interface.IOrderDetailService;
import webp.four.common.Service.Interface.IOrderService;
import webp.four.common.Service.Interface.IUserService;

@WebServlet(urlPatterns = {"/cart",  "/cart-delete", "/cart-checkout"})
public class CartController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1320454850902200378L;
	private IOrderDetailService orderDetailService = new OrderDetailServiceImpl();
	private IOrderService orderService = new OrderServiceImpl();
	private IGunplaService gunplaService = new GunplaServiceImpl();
	private IGradeService gradeService = new GradeServiceImpl();
	private IUserService userService = new UserServiceImpl();
	HttpSession session = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String url = req.getRequestURL().toString();
		session =  req.getSession();
		session.setMaxInactiveInterval(-1);
		if(url.contains("delete"))
		{
			User currentUser = (User) session.getAttribute("user");
			Order currentOrder = orderService.getUserOrder(currentUser.getUserId());
			//int orderId = 3;
			delete(req,resp);
			List<String[]> listofcart = getDetailByOrderId(req, currentOrder.getOrderId());
			req.setAttribute("listofcart", listofcart);
			req.setAttribute("order", currentOrder);
//			RequestDispatcher rq = req.getRequestDispatcher("views/user/cart.jsp");
//			rq.forward(req, resp);
			resp.sendRedirect("/ToyStore/cart");
		}
		else if(url.contains("checkout"))
		{	
			User currentUser = (User) session.getAttribute("user");
			Order currentOrder = orderService.getUserOrder(currentUser.getUserId());
			//int orderId = 3;
			checkout(req,resp);
			List<String[]> listofcart = getDetailByOrderId(req, currentOrder.getOrderId());
			req.setAttribute("listofcart", listofcart);
			req.setAttribute("order", currentOrder);
//			RequestDispatcher rq = req.getRequestDispatcher("views/user/cart.jsp");
//			rq.forward(req, resp);
			resp.sendRedirect("/ToyStore/cart");
			
		}
		else if(url.contains("cart"))
		{
			User currentUser = (User) session.getAttribute("user");
			Order currentOrder = orderService.getUserOrder(currentUser.getUserId());
			//int orderId = 3;
			/*
			List<OrderDetail> listoforderdetail = orderDetailService.getAllOrderDetailOfOrder(orderId);
			//String[][] listofcart = new String[listoforderdetail.size()][3];
			List<String[]> listofcart = new ArrayList<String[]>();
			int tempTotalPrice = 0;
			for(OrderDetail orderdetail : listoforderdetail)
			{
				Gunpla tempGunpla = gunplaService.get(orderdetail.getGunplaId());
				Grade tempGrade = gradeService.get(tempGunpla.getGradeId());
				String[] cart = new String[4];
				cart[0] = tempGunpla.getGunplaName();
				cart[1] = tempGrade.getGradeName();
				cart[2] = Integer.toString(tempGunpla.getPrice());
				cart[3] = Integer.toString(orderdetail.getOrderDetailId());
				tempTotalPrice = tempTotalPrice + tempGunpla.getPrice();
				listofcart.add(cart);
			}
			*/
			List<String[]> listofcart = getDetailByOrderId(req, currentOrder.getOrderId());
			req.setAttribute("listofcart", listofcart);
			req.setAttribute("order", currentOrder);
			RequestDispatcher rq = req.getRequestDispatcher("views/user/cart.jsp");
			rq.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		//String url = req.getRequestURL().toString();
//		RequestDispatcher rq = req.getRequestDispatcher("views/user/cart.jsp");
//		rq.forward(req, resp);
		resp.sendRedirect("/ToyStore/cart");
	}
	
	private void delete(HttpServletRequest req, HttpServletResponse resp) 
	{
		try {
			String detailID = req.getParameter("id");
			OrderDetail orderDetail = orderDetailService.get(Integer.parseInt(detailID));
			
			User currentUser = (User) session.getAttribute("user");
			Order currentOrder = orderService.getUserOrder(currentUser.getUserId());
			Gunpla chosenGunpla = gunplaService.get(orderDetail.getGunplaId());
			currentOrder.setTotal(currentOrder.getTotal()-chosenGunpla.getPrice());
			orderService.update(currentOrder);
			
			orderDetailService.delete(orderDetail);
			
			
			//Order ord = (Order) session.getAttribute("order");
			//List<OrderDetail> odt = orderDao.getDetails(ord);
			//session.setAttribute("detaillist", odt);
			//req.setAttribute("detaillist", odt);
			req.setAttribute("order", currentOrder);
			req.setAttribute("message", "Deleted");
			//req.setAttribute("count", odt.size());

		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("error", "Error: " + e.getMessage());

		}
	}
	
	private void checkout(HttpServletRequest req, HttpServletResponse resp)
	{
//		session =  req.getSession();
		User currentUser = (User) session.getAttribute("user");
		Order currentOrder = orderService.getUserOrder(currentUser.getUserId());
		
		Date now = new Date(System.currentTimeMillis());
		//int currentUserId = 3;
		//int orderId = currentOrder.getOrderId();
		
		int totalPrice = currentOrder.getTotal();
		//System.out.println(totalPrice);
		
		//User currentUser = userService.get(currentUserId);
		if(totalPrice <= currentUser.getWallet())
		{
			currentUser.setWallet(currentUser.getWallet() - totalPrice);
			userService.edit(currentUser);
			
			//Order order = orderService.get(orderId);
			currentOrder.setStatusId(2);
			currentOrder.setLatestUpdate(now);
			orderService.update(currentOrder);
			
			// sub stock
			List<OrderDetail> ordDlist = orderDetailService.getAllOrderDetailOfOrder(currentOrder.getOrderId());
			for(OrderDetail ordD : ordDlist)
			{
				Gunpla tempGunpla = gunplaService.get(ordD.getGunplaId());
				tempGunpla.setStock(tempGunpla.getStock() - 1);
				gunplaService.edit(tempGunpla);
			}
			
			Order newOrder = new Order();
			newOrder.setCreateDate(now);
			newOrder.setLatestUpdate(now);
			//newOrder.setStoreId(null);
			newOrder.setTotal(0);
			newOrder.setUserId(currentUser.getUserId());
			newOrder.setStatusId(1);
		//	newOrder.setCode(null);
			orderService.insert(newOrder);
			//session.setAttribute("order", newOrder);
		}
	}
	
	private List<String[]> getDetailByOrderId(HttpServletRequest req, int orderId)
	{
		List<OrderDetail> listoforderdetail = orderDetailService.getAllOrderDetailOfOrder(orderId);
		//String[][] listofcart = new String[listoforderdetail.size()][3];
		List<String[]> listofcart = new ArrayList<String[]>();
		
		for(OrderDetail orderdetail : listoforderdetail)
		{
			Gunpla tempGunpla = gunplaService.get(orderdetail.getGunplaId());
			Grade tempGrade = gradeService.get(tempGunpla.getGradeId());
			String[] cart = new String[4];
			cart[0] = tempGunpla.getGunplaName();
			cart[1] = tempGrade.getGradeName();
			cart[2] = Integer.toString(tempGunpla.getPrice());
			cart[3] = Integer.toString(orderdetail.getOrderDetailId());
			listofcart.add(cart);
		}
		return listofcart;
	}
}

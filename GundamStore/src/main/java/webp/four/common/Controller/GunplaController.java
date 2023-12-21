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

import webp.four.common.Model.Grade;
import webp.four.common.Model.Gunpla;
import webp.four.common.Model.Order;
import webp.four.common.Model.OrderDetail;
import webp.four.common.Model.User;
import webp.four.common.Service.Interface.IGradeService;
import webp.four.common.Service.Interface.IGunplaService;
import webp.four.common.Service.Interface.IOrderDetailService;
import webp.four.common.Service.Interface.IOrderService;
import webp.four.common.Service.Impl.GradeServiceImpl;
import webp.four.common.Service.Impl.GunplaServiceImpl;
import webp.four.common.Service.Impl.OrderDetailServiceImpl;
import webp.four.common.Service.Impl.OrderServiceImpl;

@WebServlet(urlPatterns = { "/gunpla", "/gunpla/details"})
public class GunplaController extends HttpServlet {

	IGunplaService gunplaServ = new GunplaServiceImpl();
	IGradeService gradeServ = new GradeServiceImpl();
	IOrderDetailService orderDetailService = new OrderDetailServiceImpl();
	IOrderService orderService = new OrderServiceImpl();
	private static final long serialVersionUID = 5686070832445512648L;
	HttpSession session = null;
	protected void productPageAll(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// String categoryid = req.getParameter("categoryid");
		String indexPage = req.getParameter("index");
		req.setAttribute("currentGrade", "all");
		// phân trang, khởi tạo trang đầu
		if (indexPage == null) {
			indexPage = "1";
		}
		int indexp = Integer.parseInt(indexPage);
		// Get data từ DAO
		int countP = gunplaServ.countAll();
		// chia trang cho count
		int endPage = countP / 6;
		if (countP % 6 != 0) {
			endPage++;
		}
		List<Gunpla> gunplaListNew = gunplaServ.findAll(indexp);
		req.setAttribute("listAllGunpla", gunplaListNew);
		req.setAttribute("countproductAll", countP);
		// lay du lieu va day len view
		// List<Category> categoryList = categoryService.findAll();
		// req.setAttribute("categoryList", categoryList);
		// Truyền lên JSP
		req.setAttribute("endP", endPage);
		req.setAttribute("tag", indexp);
		// req.setAttribute("cateid", categoryid);
		req.getRequestDispatcher("/views/web/gunpla.jsp").forward(req, resp);
	}

	protected void productPageGrade(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute("currentGrade", req.getParameter("gid"));
		String gid = req.getParameter("gid");
		String indexPage = req.getParameter("index");
		req.setAttribute("currentGrade", gid);
		// phân trang, khởi tạo trang đầu
		if (indexPage == null) {
			indexPage = "1";
		}
		int indexp = Integer.parseInt(indexPage);
		// Get data từ DAO
		int countP = gunplaServ.countAll(gid);
		// chia trang cho count
		int endPage = countP / 6;
		if (countP % 6 != 0) {
			endPage++;
		}

		List<Gunpla> gunplaListNew = gunplaServ.findAll(indexp, gid);
		req.setAttribute("listAllGunpla", gunplaListNew);
		req.setAttribute("countproductAll", countP);

		req.setAttribute("endP", endPage);
		req.setAttribute("tag", indexp);
		// req.setAttribute("cateid", categoryid);
		req.getRequestDispatcher("/views/web/gunpla.jsp").forward(req, resp);
	}
	
	protected void addToCart(HttpServletRequest req, HttpServletResponse resp)
	{
		//int gunplaId = Integer.parseInt(req.getParameter("id"));
		//System.out.println(gunplaId);
		
		//String id = req.getParameter("id");
		int chosenGunplaId = Integer.parseInt(req.getParameter("id"));
		Gunpla chosenGunpla = gunplaServ.get(chosenGunplaId);
		if(chosenGunpla.getStock() >= 1)
		{
			//System.out.println(chosenGunplaId);
			//int currentUserId = 3;
			//int orderId = 3;
			//Order currentOrder = (Order) session.getAttribute("order");
			User currentUser = (User) session.getAttribute("user");
			Order currentOrder = new Order();
			currentOrder = orderService.getUserOrder(currentUser.getUserId());
			//System.out.println(currentUser.getUserId());
			//System.out.println(currentOrder.getOrderId());
			
			currentOrder.setTotal(currentOrder.getTotal() + gunplaServ.get(chosenGunplaId).getPrice());
			orderService.update(currentOrder);
			
			
			//User currentUser = userService.get(currentUserId);
			//Gunpla chosenGunpla = gunplaServ.get(chosenGunplaId);
			//Order chosenOrder = orderService.get(currentOrder.getOrderId());
			OrderDetail newOrderDetail = new OrderDetail();
			newOrderDetail.setGunplaId(chosenGunplaId);
			newOrderDetail.setOrderId(currentOrder.getOrderId());
			orderDetailService.insert(newOrderDetail);
			//System.out.println(newOrderDetail.getOrderDetailId());
		}
		else
		{
			
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		session = req.getSession();
		session.setMaxInactiveInterval(-1);
		String url = req.getRequestURL().toString();
		if (url.contains("/details")) {
			String id = req.getParameter("id");
			Gunpla gunpla = new Gunpla();
			gunpla = gunplaServ.get(Integer.parseInt(id));
			req.setAttribute("gunpla", gunpla);
			RequestDispatcher rq = req.getRequestDispatcher("/views/web/details.jsp");
			rq.forward(req, resp);
		}
		else{
			List<Grade> listGrade = new ArrayList<Grade>();
			listGrade = gradeServ.getAll();
			req.setAttribute("listGrade", listGrade);
			if (req.getParameter("gid") != null) {
				if (req.getParameter("gid").equals("all")) {
					productPageAll(req, resp);
				} else {
					productPageGrade(req, resp);
				}
			} else {
				productPageAll(req, resp);
				RequestDispatcher rq = req.getRequestDispatcher("/views/web/gunpla.jsp");
				rq.forward(req, resp);
			}
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		session =  req.getSession();
		session.setMaxInactiveInterval(-1);
		if(req.getParameter("addtocart") != null)
		{
			addToCart(req,resp);
		}
		resp.sendRedirect("/ToyStore/gunpla");
	}
	
	
}

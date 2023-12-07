package webp.four.common.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webp.four.common.Model.Grade;
import webp.four.common.Model.Store;
import webp.four.common.Model.User;
import webp.four.common.Service.Impl.GradeServiceImpl;
import webp.four.common.Service.Impl.OrderServiceImpl;
import webp.four.common.Service.Impl.StoreServiceImpl;
import webp.four.common.Service.Impl.UserServiceImpl;
import webp.four.common.Service.Interface.IGradeService;
import webp.four.common.Service.Interface.IOrderService;
import webp.four.common.Service.Interface.IStoreService;
import webp.four.common.Service.Interface.IUserService;

@WebServlet(urlPatterns = {"/admin", "/admin-home", "/admin-grade-management", "/admin-store-management","/admin-user-management","/admin-statistics"})
public class AdminController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7739401007945536410L;
	private IGradeService gradeService = new GradeServiceImpl();
	private IStoreService storeService = new StoreServiceImpl();
	private IUserService userService = new UserServiceImpl();
	private IOrderService orderService = new OrderServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String url = req.getRequestURL().toString();
		if(url.contains("admin-home"))
		{
			float revenue = (float) (orderService.thisMonthRevenue() * 0.07);
			int thismonthuser = userService.getThisMonthJoinUser();
			int thismonthshop = storeService.getThisMonthJoinStore();
			req.setAttribute("thismonthrevenue", revenue);
			req.setAttribute("thismonthjoinuser", thismonthuser);
			req.setAttribute("thismonthjoinstore", thismonthshop);
			RequestDispatcher rq = req.getRequestDispatcher("views/admin/admin-home.jsp");
			rq.forward(req, resp);
		}
		else if(url.contains("admin-statistics"))
		{
			float revenue = (float) (orderService.thisMonthRevenue() * 0.07);
			int thismonthuser = userService.getThisMonthJoinUser();
			int thismonthshop = storeService.getThisMonthJoinStore();
			req.setAttribute("thismonthrevenue", revenue);
			req.setAttribute("thismonthjoinuser", thismonthuser);
			req.setAttribute("thismonthjoinstore", thismonthshop);
			RequestDispatcher rq = req.getRequestDispatcher("views/admin/admin-home.jsp");
			rq.forward(req, resp);
		}
		else if(url.contains("admin-grade-management"))
		{
			List<Grade> listofgrade = gradeService.getAll();
			req.setAttribute("listofgrade", listofgrade);
			RequestDispatcher rq = req.getRequestDispatcher("views/admin/admin-grade-management.jsp");
			rq.forward(req, resp);
		}
		else if(url.contains("admin-store-management"))
		{
			List<Store> listofstore = storeService.getAll();
			req.setAttribute("listofstore", listofstore);
			RequestDispatcher rq = req.getRequestDispatcher("views/admin/admin-store-management.jsp");
			rq.forward(req, resp);
		}
		else if(url.contains("admin-user-management"))
		{
			List<User> listofuser = userService.getAll();
			req.setAttribute("listofuser", listofuser);
			RequestDispatcher rq = req.getRequestDispatcher("views/admin/admin-user-management.jsp");
			rq.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String url = req.getRequestURL().toString();
		if(url.contains("admin-grade-management"))
		{
			if(req.getParameter("addnewgrade") != null)
			{
				String gradeacronym = req.getParameter("acronymforgrade");
			    String grade = req.getParameter("grade");
				Grade newGrade = new Grade();
			    newGrade.setGrade(gradeacronym);
			    newGrade.setGradeName(grade);
			    gradeService.insert(newGrade);
			    List<Grade> listofgrade = gradeService.getAll();
				req.setAttribute("listofgrade", listofgrade);
				RequestDispatcher rq = req.getRequestDispatcher("views/admin/admin-grade-management.jsp");
				rq.forward(req, resp);
			}
			if(req.getParameter("updategrade") != null)
			{
				String gradeacronym = req.getParameter("acronymforgrade");
			    String grade = req.getParameter("grade");
				Grade newGrade = new Grade();
			    newGrade.setGrade(gradeacronym);
			    newGrade.setGradeName(grade);
			    gradeService.edit(newGrade);
			    List<Grade> listofgrade = gradeService.getAll();
				req.setAttribute("listofgrade", listofgrade);
				RequestDispatcher rq = req.getRequestDispatcher("views/admin/admin-grade-management.jsp");
				rq.forward(req, resp);
			}
			else if(req.getParameter("removegrade") != null)
			{
				String gradeacronym = req.getParameter("acronymforgrade");
			    String grade = req.getParameter("grade");
			    Grade selectedGrade = new Grade();
			    selectedGrade.setGrade(gradeacronym);
			    selectedGrade.setGradeName(grade);
				gradeService.delete(selectedGrade);
				List<Grade> listofgrade = gradeService.getAll();
				req.setAttribute("listofgrade", listofgrade);
				RequestDispatcher rq = req.getRequestDispatcher("views/admin/admin-grade-management.jsp");
				rq.forward(req, resp);
			}
		}
		else if(url.contains("admin-store-management"))
		{
			if(req.getParameter("approvestore") != null)
			{
				int storeId = Integer.parseInt(req.getParameter("selectedstoreid"));
				storeService.Activate(storeService.get(storeId));
				List<Store> listofstore = storeService.getAll();
				req.setAttribute("listofstore", listofstore);
				RequestDispatcher rq = req.getRequestDispatcher("views/admin/admin-store-management.jsp");
				rq.forward(req, resp);
			}
			else if(req.getParameter("deactivestore") != null)
			{
				int storeId = Integer.parseInt(req.getParameter("selectedstoreid"));
				// Deactive store
				//storeService.delete(storeId);
				storeService.Deactivate(storeService.get(storeId));
				List<Store> listofstore = storeService.getAll();
				req.setAttribute("listofstore", listofstore);
				RequestDispatcher rq = req.getRequestDispatcher("views/admin/admin-store-management.jsp");
				rq.forward(req, resp);
			}
		}
		else if(url.contains("admin-user-management"))
		{
			if(req.getParameter("settoadmin") != null)
			{
				int userId = Integer.parseInt(req.getParameter("selecteduserid"));
				// xóa user
				//storeService.deactiveStoreOfUser(userService.get(userId));
				userService.promote(userId);
				List<User> listofuser = userService.getAll();
				req.setAttribute("listofuser", listofuser);
				RequestDispatcher rq = req.getRequestDispatcher("views/admin/admin-user-management.jsp");
				rq.forward(req, resp);
			}
		}
	}
}

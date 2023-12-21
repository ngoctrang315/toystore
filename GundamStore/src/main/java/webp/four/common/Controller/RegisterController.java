package webp.four.common.Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webp.four.common.Model.Order;
import webp.four.common.Model.User;
import webp.four.common.Service.Impl.OrderServiceImpl;
import webp.four.common.Service.Impl.UserServiceImpl;
import webp.four.common.Service.Interface.IOrderService;
import webp.four.common.Service.Interface.IUserService;

@WebServlet(urlPatterns = { "/register" })
public class RegisterController extends HttpServlet {

	private static final long serialVersionUID = -2837574358583051483L;
	IUserService userServ = new UserServiceImpl();
	IOrderService orderService = new OrderServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		RequestDispatcher rq = req.getRequestDispatcher("views/web/register.jsp");
		rq.forward(req, resp);
	}
	//(?=.*[@#$%]) tính có kí tự mà hơi khó
	protected boolean isValid(String pass)
	{
		String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,20}$";
		Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(pass);
		return matcher.matches();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("username");
		//System.out.printf("IS IT EXIST ? - "+userServ.checkExist(name));
		String pass = req.getParameter("password");
		String conpass = req.getParameter("confirm-password");
		//System.out.printf("confirm pass"+conpass);
		String fname = req.getParameter("fullName");
		String phone = req.getParameter("phoneNumber");
		String address = req.getParameter("address");
		if (userServ.checkExist(name)) {
			req.setAttribute("mess", "Username Exist!");
			RequestDispatcher rq = req.getRequestDispatcher("views/web/register.jsp");
			rq.forward(req, resp);
		}
		else if (!isValid(pass))
		{
			req.setAttribute("mess", "Wrong Password format!");
			RequestDispatcher rq = req.getRequestDispatcher("views/web/register.jsp");
			rq.forward(req, resp);
		} else if (!conpass.equals(pass)){
			req.setAttribute("mess", "Password not match!");
			RequestDispatcher rq = req.getRequestDispatcher("views/web/register.jsp");
			rq.forward(req, resp);
		}else{
			try {
				User user = new User();
				Date now = new Date(System.currentTimeMillis());
				Date dob = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
				dob = formatter.parse(req.getParameter("dob"));
				user = new User();
				user.setUserName(name);
				user.setPass(pass);
				user.setCreateDate(now);
				user.setFullName(fname);
				user.setPhone(phone);
				user.setDob(dob);
				user.setWallet(0);
				user.setAvatar("");
				user.setRoleId(2);
				user.setCreditCard("");
				user.setAddress(address);
				userServ.insert(user);
				req.setAttribute("mess", "Registered!");
				
				User currentUser = userServ.get(user.getUserName());
				//System.out.println("Current user");
				//System.out.println(currentUser.getUserId());
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
//				RequestDispatcher rq = req.getRequestDispatcher("views/web/login.jsp");
//				rq.forward(req, resp);
				resp.sendRedirect("login");
			} catch (Exception e) {
				req.setAttribute("mess", "Wrong date format!");
				RequestDispatcher rq = req.getRequestDispatcher("views/web/register.jsp");
				rq.forward(req, resp);
			}
		}
	}
}

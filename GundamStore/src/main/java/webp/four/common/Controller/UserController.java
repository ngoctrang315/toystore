package webp.four.common.Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webp.four.common.Model.User;
import webp.four.common.Service.Impl.UserServiceImpl;
import webp.four.common.Service.Interface.*;

@WebServlet(urlPatterns = { "/user", "/me", "/user/funds" })
public class UserController extends HttpServlet {

	private static final long serialVersionUID = 4556694105165920946L;
	IUserService userServ = new UserServiceImpl();
	HttpSession session = null;
	User currentuser = new User();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		session = req.getSession();
		session.setMaxInactiveInterval(-1);
		currentuser = (User) session.getAttribute("user");

		String url = req.getRequestURL().toString();
		if (url.contains("funds")) {
			currentuser = (User) session.getAttribute("user");
			if (currentuser.getCreditCard() != null) {
				String card = currentuser.getCreditCard().replaceAll(" ", "");
				if (!card.equals("")) {
					req.setAttribute("cardnum", card);
				}
			}
			RequestDispatcher rq = req.getRequestDispatcher("/views/user/funds.jsp");
			rq.forward(req, resp);

		} else {
			if (this.currentuser == null)
				resp.sendRedirect("login");
			else {
				Date date = currentuser.getDob();
				SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
				String strDate = formatter.format(date);
				session.setAttribute("birthday", strDate);

				RequestDispatcher rq = req.getRequestDispatcher("views/user/home.jsp");
				rq.forward(req, resp);
			}
		}
	}

	protected void addFund(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int amount = Integer.parseInt(req.getParameter("amount"));
		if (amount > 0) {
			currentuser = (User) session.getAttribute("user");
			
			String cardNum = req.getParameter("cardnumber").replaceAll(" ","");
			if(cardNum.length() > 16)
			{
				req.setAttribute("mess", "Wrong card format!");
				RequestDispatcher rq = req.getRequestDispatcher("/views/user/funds.jsp");
				rq.forward(req, resp);
			}else {
				currentuser.setWallet(currentuser.getWallet() + amount);
				currentuser.setCreditCard(cardNum);
				userServ.edit(currentuser);
				session.setAttribute("user", currentuser);
//				RequestDispatcher rq = req.getRequestDispatcher("/views/user/home.jsp");
//				rq.forward(req, resp);
				resp.sendRedirect("/ToyStore/user");
			}
			
		} else {
			req.setAttribute("mess", "Amount can not be negative or zero!");
			RequestDispatcher rq = req.getRequestDispatcher("/views/user/funds.jsp");
			rq.forward(req, resp);
		}
	}

	protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			currentuser.setFullName(req.getParameter("fullName"));
			currentuser.setAddress(req.getParameter("address"));
			currentuser.setPhone(req.getParameter("phoneNumber"));
			currentuser.setPass(req.getParameter("password"));
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			date = formatter.parse(req.getParameter("birthday"));
			currentuser.setDob(date);
			userServ.edit(currentuser);
			session.setAttribute("user", currentuser);
			String strDate = formatter.format(date);
			req.setAttribute("birthday", strDate);
			req.setAttribute("message", "Updated");
			req.getRequestDispatcher("/views/user/home.jsp").forward(req, resp);
		} catch (Exception e) {
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		session = req.getSession();
		session.setMaxInactiveInterval(-1);
		currentuser = (User) session.getAttribute("user");
		String url = req.getRequestURL().toString();
		if (url.contains("funds")) {

			addFund(req, resp);

		} else {
			update(req, resp);
		}
		session.setAttribute("user", currentuser);

	}

}

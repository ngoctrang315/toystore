package webp.four.common.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webp.four.common.Model.User;
import webp.four.common.Service.Impl.UserServiceImpl;

@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = -5981243079206234004L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		RequestDispatcher rq = req.getRequestDispatcher("views/web/login.jsp");
		rq.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("username");
		String pass = req.getParameter("password");
		String accType = req.getParameter("accType");

		UserServiceImpl userServ = new UserServiceImpl();

		String mess = "username or password incorrect";

		boolean checkAccount = userServ.checkExist(name);
		// List<User> customer = customerDao.FindByObject("username", name);
		//System.out.printf("HAVE ? "+checkAccount+ " - " + userServ.get(name).getRoleId() + " - " + userServ.get(name).getPass() + " + " + pass);
		int isCustomer = 0; // 1 la admin  -  2 la vendor  -  3 la user
		if (accType == null) {
			mess = "Please check your role!!";
			req.setAttribute("mess", mess);
			RequestDispatcher rq = req.getRequestDispatcher("views/web/login.jsp");
			rq.forward(req, resp);
		} else if ((checkAccount == true)) {
			if (userServ.get(name).getPass().equals(pass)) {
				int check= userServ.get(name).getRoleId();
				//System.out.printf("HAVE ? "+accType+ " - " + isCustomer + " - " + check);
				switch(check)
				{
				case (1):
					if (accType.equals("manager")) isCustomer = 1;
				    break;
				case (2):
					if (accType.equals("member")) isCustomer = 2;
				    break;
				}
			}
			
			if (isCustomer == 0) {
				req.setAttribute("mess", mess);
				RequestDispatcher rq = req.getRequestDispatcher("views/web/login.jsp");
				rq.forward(req, resp);

			} else {
				HttpSession session = req.getSession();
				session.setMaxInactiveInterval(-1);
				session.setAttribute("checkuser", isCustomer);
				if (isCustomer == 1) {
					String username = req.getParameter("username");

					User employee = userServ.get(username);

//				Date date = employee.getBirthDate();
//				SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
//				String strDate = formatter.format(date);
//				session.setAttribute("birthdate", strDate);

					session.setAttribute("admin", employee);
					session.setAttribute("user", employee);
					resp.sendRedirect("admin-statistics");

				} else {
					resp.sendRedirect("home");
					//OrderAbstractImpl orderDao = new OrderAbstractImpl();
					String username = req.getParameter("username");
					if (username != null && username.length() > 0) {
						User cus = userServ.get(username);
						// System.out.println("SIZE OF DETAIL LIST : "+detaillist.size());
						session.setAttribute("user", cus);

					}
				}

			}
		}
	}
}
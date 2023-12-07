package webp.four.common.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/logout")
public class LogoutController extends HttpServlet {

	HttpSession session = null;
	private static final long serialVersionUID = 7011499117446796469L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		session = req.getSession();
		session.removeAttribute("checkuser");
		session.removeAttribute("employee");
		session.removeAttribute("user");
		session.removeAttribute("order");
		session.removeAttribute("detaillist");
		session.removeAttribute("mess");
		session.removeAttribute("message");
		resp.sendRedirect("home");
//		RequestDispatcher rq = req.getRequestDispatcher("views/web/home.jsp");
//		rq.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
	}
}

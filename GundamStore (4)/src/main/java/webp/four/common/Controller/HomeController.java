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

import webp.four.common.Model.Gunpla;
import webp.four.common.Service.Impl.GradeServiceImpl;
import webp.four.common.Service.Impl.GunplaServiceImpl;
import webp.four.common.Service.Interface.IGradeService;
import webp.four.common.Service.Interface.IGunplaService;

@WebServlet(urlPatterns = { "/home"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = -7629288540825053401L;
	IGunplaService gunplaServ = new GunplaServiceImpl();
	IGradeService gradeServ = new GradeServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		List<Gunpla> newest = new ArrayList<Gunpla>();
		newest = gunplaServ.findNewest();
		req.setAttribute("listNewest", newest);
		List<Gunpla> cheapest = new ArrayList<Gunpla>();
		cheapest = gunplaServ.findCheapest();
		req.setAttribute("cheapestList", cheapest);
		Gunpla top = new Gunpla();
		top = gunplaServ.findTopPrice();
		req.setAttribute("top", top);
		RequestDispatcher rq = req.getRequestDispatcher("views/web/home.jsp");
		rq.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
	}
	

}

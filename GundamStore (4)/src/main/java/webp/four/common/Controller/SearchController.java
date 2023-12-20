package webp.four.common.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webp.four.common.Model.Gunpla;
import webp.four.common.Service.Impl.GunplaServiceImpl;
import webp.four.common.Service.Interface.IGunplaService;

@WebServlet(urlPatterns = { "/search", "/search/details" })
public class SearchController extends HttpServlet {

	private static final long serialVersionUID = -3828285465158460961L;
	IGunplaService gunplaServ = new GunplaServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String url = req.getRequestURL().toString();
		String id = req.getParameter("id");
		if (url.contains("/detail")) {
			Gunpla gunpla = new Gunpla();
			gunpla = gunplaServ.get(Integer.parseInt(id));
			req.setAttribute("gunpla", gunpla);
			RequestDispatcher rq = req.getRequestDispatcher("/views/web/details.jsp");
			rq.forward(req, resp);
		} else {
			if (req.getParameter("keyword") != null) {
				if (req.getParameter("index") != null) {
					productPageKey(req, resp);
				} else {
					productPageFirst(req, resp);
				}
			} else {
				productPageFirst(req, resp);
				req.getRequestDispatcher("views/web/search.jsp").forward(req, resp);
			}

		}
	}

	protected void productPageFirst(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String gunplaName = req.getParameter("txtsearch");
		// String categoryid = req.getParameter("categoryid");
		req.setAttribute("keyword", gunplaName);
		String indexPage = req.getParameter("index");
		// phân trang, khởi tạo trang đầu
		if (indexPage == null) {
			indexPage = "1";
		}
		int indexp = Integer.parseInt(indexPage);
		// Get data từ DAO
		int countP = gunplaServ.countAllKey(gunplaName);
		System.out.printf("count " + countP);
		// chia trang cho count
		int endPage = countP / 6;
		if (countP % 6 != 0) {
			endPage++;
		}
		List<Gunpla> gunplaListNew = gunplaServ.search(indexp, gunplaName);
		req.setAttribute("countproductAll", countP);
		// lay du lieu va day len view
		// List<Category> categoryList = categoryService.findAll();
		// req.setAttribute("categoryList", categoryList);
		// Truyền lên JSP
		req.setAttribute("endP", endPage);
		req.setAttribute("tag", indexp);
		// req.setAttribute("cateid", categoryid);
		if (gunplaListNew.size() > 0) {
			req.setAttribute("searchlist", gunplaListNew);
			req.getRequestDispatcher("views/web/search.jsp").forward(req, resp);
		} else {
			req.setAttribute("found", "Not Found");
			req.getRequestDispatcher("views/web/search.jsp").forward(req, resp);
		}
	}

	protected void productPageKey(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String gunplaName = req.getParameter("keyword");
		// String categoryid = req.getParameter("categoryid");
		req.setAttribute("keyword", gunplaName);
		String indexPage = req.getParameter("index");
		// phân trang, khởi tạo trang đầu
		if (indexPage == null) {
			indexPage = "1";
		}
		int indexp = Integer.parseInt(indexPage);
		// Get data từ DAO
		int countP = gunplaServ.countAllKey(gunplaName);
		System.out.printf("count " + countP);
		// chia trang cho count
		int endPage = countP / 6;
		if (countP % 6 != 0) {
			endPage++;
		}
		List<Gunpla> gunplaListNew = gunplaServ.search(indexp, gunplaName);
		req.setAttribute("countproductAll", countP);
		// lay du lieu va day len view
		// List<Category> categoryList = categoryService.findAll();
		// req.setAttribute("categoryList", categoryList);
		// Truyền lên JSP
		req.setAttribute("endP", endPage);
		req.setAttribute("tag", indexp);
		// req.setAttribute("cateid", categoryid);
		if (gunplaListNew.size() > 0) {
			req.setAttribute("searchlist", gunplaListNew);
			req.getRequestDispatcher("views/web/search.jsp").forward(req, resp);
		} else {
			req.setAttribute("found", "Not Found");
			req.getRequestDispatcher("views/web/search.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		productPageFirst(req, resp);
		// String gunplaName = req.getParameter("txtsearch");
		// List<Gunpla> gunplas = gunplaServ.search(gunplaName);
	}
}
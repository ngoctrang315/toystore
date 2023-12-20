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

import org.apache.commons.beanutils.BeanUtils;

import webp.four.common.Model.Gunpla;
import webp.four.common.Model.Order;
import webp.four.common.Model.Store;
import webp.four.common.Model.User;
import webp.four.common.Service.Impl.GunplaServiceImpl;
import webp.four.common.Service.Impl.StoreServiceImpl;
import webp.four.common.Service.Interface.IGunplaService;
import webp.four.common.Service.Interface.IStoreService;

@WebServlet(urlPatterns = { "/managergunpla", "/managergunpla/edit", "/managergunpla/create", "/managergunpla/update",
		"/managergunpla/delete", "/managergunpla/reset" })
public class GunplaManagementController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3621351473234807355L;
	
	IGunplaService gunplaservice = new GunplaServiceImpl();
	IStoreService storeServie = new StoreServiceImpl();
	HttpSession session = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		session = req.getSession();
		session.setMaxInactiveInterval(-1);
		Gunpla gunpla = null;
		String url = req.getRequestURL().toString();
		if (url.contains("create")) {
			req.getRequestDispatcher("/views/user/managergunpla.jsp").forward(req, resp);
		} else if (url.contains("delete")) {

			delete(req,resp);
			gunpla = new Gunpla();

			req.setAttribute("gunpla", gunpla);

		} else if (url.contains("edit")) {

			edit(req, resp);

		} else if (url.contains("reset")) {

			gunpla = new Gunpla();

			req.setAttribute("gunpla", gunpla);

		} else if(url.contains("/details")) {
			String id = req.getParameter("id");
			Gunpla gunpladetail = new Gunpla();
			gunpladetail = gunplaservice.get(Integer.parseInt(id));
			req.setAttribute("gunpla", gunpladetail);
			RequestDispatcher rq = req.getRequestDispatcher("/views/web/details.jsp");
			rq.forward(req, resp);
		}

		FindAll(req, resp);
		RequestDispatcher rq = req.getRequestDispatcher("/views/user/managergunpla.jsp");
		rq.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();

		if (url.contains("create")) {
			insert(req, resp);

		} else if (url.contains("update")) {

			update(req, resp);

		} else if (url.contains("delete")) {

			delete(req, resp);

		} else if (url.contains("reset")) {

			req.setAttribute("gunpla", new Gunpla());

		}
		FindAll(req, resp);
		RequestDispatcher rq = req.getRequestDispatcher("/views/user/managergunpla.jsp");
		rq.forward(req, resp);
	}

	protected void FindAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			User currentUser = (User) session.getAttribute("user");
			Store userStore = storeServie.getStoreByUserId(currentUser.getUserId());
			List<Gunpla> lstgunpla = gunplaservice.getAllGunplaOfStore(userStore.getStoreId());
			req.setAttribute("lstgunpla", lstgunpla);
		} catch (Exception e) {
		}
	}

	protected void edit(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		try {
			String gunplaid =  req.getParameter("id");
			Gunpla gunpla = gunplaservice.get(Integer.parseInt(gunplaid));
			
			req.setAttribute("gunpla", gunpla);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	protected void insert(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

		try {
			User currentUser = (User) session.getAttribute("user");
			Store userStore = storeServie.getStoreByUserId(currentUser.getUserId());
			
			String gunplaName = req.getParameter("gunplaName");
			String gradeId = req.getParameter("gradeId");
			String desc = req.getParameter("desc");
			String price = req.getParameter("price");
			String image = req.getParameter("image");
			String stock = req.getParameter("stock");

			Gunpla gunpla = new Gunpla();
			BeanUtils.populate(gunpla, req.getParameterMap());
			gunpla.setGunplaName(gunplaName);
			gunpla.setGradeId(gradeId.replaceAll("\\s+",""));
			gunpla.setDesc(desc);
			gunpla.setPrice(Integer.parseInt(price.replaceAll("\\s+","")));
			gunpla.setImage(image.replaceAll("\\s+",""));
			gunpla.setStock(Integer.parseInt(stock.replaceAll("\\s+","")));
			gunpla.setStoreId(userStore.getStoreId());
			gunplaservice.insert(gunpla);
			
			req.setAttribute("gunpla", gunpla);
			req.setAttribute("message","Successful");

		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("error", "Error: " + e.getMessage());

		}

	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) {

		try {

			String gunplaId = req.getParameter("id");
			Gunpla selectedGunpla = gunplaservice.get(Integer.parseInt(gunplaId.replaceAll("\\s+","")));
			gunplaservice.delete(selectedGunpla);
			req.setAttribute("message", "Deleted");

		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("error", "Error: " + e.getMessage());

		}

	}

	protected void update(HttpServletRequest req, HttpServletResponse reps)

			throws ServletException, IOException {

		try {

			req.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");

			String gunplaId = req.getParameter("gunplaId");
			String gunplaName = req.getParameter("gunplaName");
			String gradeId = req.getParameter("gradeId");
			String desc = req.getParameter("desc");
			String price = req.getParameter("price");
			String image = req.getParameter("image");
			String stock = req.getParameter("stock");
			
			Gunpla gunpla = new Gunpla();
			BeanUtils.populate(gunpla, req.getParameterMap());
			gunpla.setGunplaId(Integer.parseInt(gunplaId.replaceAll("\\s+","")));
			gunpla.setGunplaName(gunplaName);
			gunpla.setGradeId(gradeId);
			gunpla.setDesc(desc);
			gunpla.setPrice(Integer.parseInt(price.replaceAll("\\s+","")));
			gunpla.setImage(image);
			gunpla.setStock(Integer.parseInt(stock.replaceAll("\\s+","")));
			gunplaservice.edit(gunpla);
			
			req.setAttribute("gunpla", gunpla);
			req.setAttribute("message", "Successfull");

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Error: " + e.getMessage());

		}

	}
}

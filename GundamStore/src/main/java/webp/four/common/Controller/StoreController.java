package webp.four.common.Controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import webp.four.common.Model.Gunpla;
import webp.four.common.Model.Store;
import webp.four.common.Model.User;
import webp.four.common.Service.Impl.StoreServiceImpl;
import webp.four.common.Service.Interface.IStoreService;

@WebServlet(urlPatterns = { "/storeinfo", "/store/deactive", "/store/update" })
public class StoreController extends HttpServlet {

	private static final long serialVersionUID = 5794064884422064237L;

	IStoreService storeservice = new StoreServiceImpl();
	HttpSession session = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		session = req.getSession();
		session.setMaxInactiveInterval(-1);
		String url = req.getRequestURL().toString();
		User currentUser = (User) session.getAttribute("user");
		Store userStore = storeservice.getStoreByUserId(currentUser.getUserId());
		boolean checkStore = storeservice.checkExist(currentUser.getUserId());
		if (checkStore == true) {
			if (url.contains("/update")) {
				update(req, resp);
			} else if (url.contains("/deactive")) {
				DeActive(req, resp);
			}

			req.setAttribute("store", userStore);
			RequestDispatcher rq = req.getRequestDispatcher("/views/user/storeinfo.jsp");
			rq.forward(req, resp);
		} else {
			RequestDispatcher rq = req.getRequestDispatcher("/views/user/createstore.jsp");
			rq.forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		session = req.getSession();
		session.setMaxInactiveInterval(-1);
		String url = req.getRequestURL().toString();
		User currentUser = (User) session.getAttribute("user");
		Store userStore = storeservice.getStoreByUserId(currentUser.getUserId());
		boolean checkStore = storeservice.checkExist(currentUser.getUserId());
		if (checkStore == true) {
			if (url.contains("/update")) {
				update(req, resp);
				RequestDispatcher rq = req.getRequestDispatcher("/views/user/storeinfo.jsp");
				rq.forward(req, resp);
				
			} else if (url.contains("/deactive")) {
				DeActive(req, resp);
				update(req, resp);
				RequestDispatcher rq = req.getRequestDispatcher("/views/user/storeinfo.jsp");
				rq.forward(req, resp);
			}
			req.setAttribute("store", userStore);
			RequestDispatcher rq = req.getRequestDispatcher("/views/user/storeinfo.jsp");
			rq.forward(req, resp);
		}else
		{
			insert(req,resp);
			RequestDispatcher rq = req.getRequestDispatcher("/views/user/storeinfo.jsp");
			rq.forward(req, resp);
		}
	}

	private void DeActive(HttpServletRequest req, HttpServletResponse resp) {

		try {
			String storeId = req.getParameter("storeId");

			Store old = storeservice.get(Integer.parseInt(storeId.replaceAll("\\s+", "")));
			storeservice.Deactivate(old);

			Store store = new Store();
			store.setStoreId(Integer.parseInt(storeId.replaceAll("\\s+", "")));
			store.setStoreName(old.getStoreName());
			store.setBioStore(old.getBioStore());
			store.setCreateDate(old.getCreateDate());
			store.setActive(old.isActive());
			store.setWallet(old.getWallet());

			storeservice.edit(store);
			req.setAttribute("store", store);

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

			String storeId = req.getParameter("storeId");
			String storeName = req.getParameter("storeName");
			String bioStore = req.getParameter("bioStore");
			Store old = storeservice.get(Integer.parseInt(storeId.replaceAll("\\s+", "")));
			Store store = new Store();
			store.setStoreId(Integer.parseInt(storeId.replaceAll("\\s+", "")));
			store.setStoreName(storeName);
			store.setBioStore(bioStore);
			store.setCreateDate(old.getCreateDate());
			store.setActive(old.isActive());
			store.setWallet(old.getWallet());
			storeservice.edit(store);

			req.setAttribute("store", store);
			req.setAttribute("message", "Successfull");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Error: " + e.getMessage());

		}

	}

	protected void insert(HttpServletRequest req, HttpServletResponse reps)

			throws ServletException, IOException {

		try {
			User currentUser = (User) session.getAttribute("user");

			String storename = req.getParameter("storeName");
			String bio = req.getParameter("bioStore");

			Store store = new Store();
			store.setStoreName(storename);
			store.setBioStore(bio);
			store.setUserId(currentUser.getUserId());
			storeservice.insert(store);

			req.setAttribute("store", store);
			req.setAttribute("message", "Successful");

		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("error", "Error: " + e.getMessage());

		}

	}

}

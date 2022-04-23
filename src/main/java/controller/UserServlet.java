package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import dao.ProductDAO;
import dao.UserDAO;
import entities.Product;
import entities.User;
import utils.EncryptUtil;

@WebServlet({
	"/users/index",
	"/users/create",
	"/users/store",
	"/users/edit",
	"/users/update",
	"/users/delete"
})
public class UserServlet extends HttpServlet {
	private UserDAO userDAO;
	private ProductDAO productDAO;
	
	public UserServlet() {
		this.userDAO = new UserDAO();
		this.productDAO=new ProductDAO();
	}

	protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		String uri = request.getRequestURI();
		
		if (uri.contains("index")) {
			this.index(request, response);
		} else if (uri.contains("create")) {
			this.create(request, response);
		} else if (uri.contains("edit")) {
			this.edit(request, response);
		} else if (uri.contains("delete")) {
			this.delete(request, response);
		}
	}

	protected void doPost(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		String uri = request.getRequestURI();
		
		if (uri.contains("store")) {
			this.store(request, response);
		} else if (uri.contains("update")) {
			this.update(request, response);
		} else {
			// 404
		}
	}

	private void index(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		List<User> ds = this.userDAO.all();
		request.setAttribute("ds", ds);
		request.setAttribute("now", new Date());
		request.setAttribute("view",
			"/views/admin/users/index.jsp");
		request.getRequestDispatcher("/views/layout.jsp")
			.forward(request, response);
		
	}

	private void create(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		request.setAttribute("view",
			"/views/admin/users/create.jsp");
		request.getRequestDispatcher("/views/layout.jsp")
			.forward(request, response);
	}

	private void store(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String hoTen=request.getParameter("hoTen");
		String diaChi=request.getParameter("diaChi");
		String sdt=request.getParameter("sdt");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String gioitinh=request.getParameter("gioiTinh");
		if(hoTen==null||diaChi==null||sdt==null||email==null||password==null||gioitinh==null) {
			session.setAttribute("error",
					"Không được để trống");
			response.sendRedirect("/PH17657_TranHuyHieu_Assignment_SOF3011"
					+ "/users/create");
		}else if(!email.trim().matches("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+){1,2}$")) {
			session.setAttribute("error",
					"Email không đúng định dạng");
			response.sendRedirect("/PH17657_TranHuyHieu_Assignment_SOF3011"
					+ "/users/create");
		}else if(!password.trim().matches("^[A-Za-z0-9!@#$%^&*]{3,50}$")) {
			session.setAttribute("error",
					"Password không đúng định dạng");
			response.sendRedirect("/PH17657_TranHuyHieu_Assignment_SOF3011"
					+ "/users/create");
		}else {
			try {
				User entity = new User();
				BeanUtils.populate(entity,
					request.getParameterMap());
				
				String encrypted = EncryptUtil.encrypt(
					request.getParameter("password")
				);
				entity.setPassword(encrypted);
				this.userDAO.create(entity);
				session.setAttribute("message",
					"Thêm mới thành công");
				response.sendRedirect("/PH17657_TranHuyHieu_Assignment_SOF3011"
					+ "/users/index");
			} catch (Exception e) {
				e.printStackTrace();
				session.setAttribute("error",
						"Thêm mới thất bại");
				response.sendRedirect("/PH17657_TranHuyHieu_Assignment_SOF3011"
						+ "/users/create");
			}
		}
		
		
	}

	private void edit(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		User entity = this.userDAO.findById(id);
		request.setAttribute("user", entity);
		request.setAttribute("view",
			"/views/admin/users/edit.jsp");
		request.getRequestDispatcher("/views/layout.jsp")
			.forward(request, response);
	}


	private void delete(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			String s = request.getParameter("id");
			int id = Integer.parseInt(s);
			User entity = this.userDAO.findById(id);
			this.userDAO.delete(entity);
			session.setAttribute("message",
					"Xóa thành công");
			response.sendRedirect("/PH17657_TranHuyHieu_Assignment_SOF3011"
					+ "/users/index");
		} catch (Exception e) {
			// TODO: handle exception
			session.setAttribute("message",
					"Xóa thất bại");
			response.sendRedirect("/PH17657_TranHuyHieu_Assignment_SOF3011"
					+ "/users/index");
		}
	}

	private void update(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		HttpSession session = request.getSession();
		String hoTen=request.getParameter("hoTen");
		String diaChi=request.getParameter("diaChi");
		String sdt=request.getParameter("sdt");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String gioitinh=request.getParameter("gioiTinh");
		if(hoTen==null||diaChi==null||sdt==null||email==null||password==null||gioitinh==null) {
			session.setAttribute("error",
					"Không được để trống");
			response.sendRedirect("/PH17657_TranHuyHieu_Assignment_SOF3011"
					+ "/users/edit?id=" + idStr);
		}else if(!email.trim().matches("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+){1,2}$")) {
			session.setAttribute("error",
					"Email không đúng định dạng");
			response.sendRedirect("/PH17657_TranHuyHieu_Assignment_SOF3011"
					+ "/users/edit?id=" + idStr);
		}else if(!password.trim().matches("^[A-Za-z0-9!@#$%^&*]{3,50}$")) {
			session.setAttribute("error",
					"Password không đúng định dạng");
			response.sendRedirect("/PH17657_TranHuyHieu_Assignment_SOF3011"
					+ "/users/edit?id=" + idStr);
		}else {
		
		try {
			int id = Integer.parseInt(idStr);
			User oldValue = this.userDAO.findById(id);
			User newValue = new User();
			BeanUtils.populate(newValue,
				request.getParameterMap());
			newValue.setPassword( oldValue.getPassword() );
			this.userDAO.update(newValue);
			session.setAttribute("message",
					"Sửa thành công");
			response.sendRedirect("/PH17657_TranHuyHieu_Assignment_SOF3011"
				+ "/users/index");
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error",
					"Sửa thất bại");
			response.sendRedirect("/PH17657_TranHuyHieu_Assignment_SOF3011"
				+ "/users/edit?id=" + idStr);
		}
		}
	}
}

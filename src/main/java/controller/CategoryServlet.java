package controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import dao.CategoryDAO;
import dao.ProductDAO;
import dao.UserDAO;
import entities.Category;
import entities.Product;
import entities.User;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet({"/categories/index",
	"/categories/edit",
	"/categories/create",
	"/categories/update",
	"/categories/store",
	"/categories/delete"
	})
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CategoryDAO categoryDAO;
	private UserDAO userDAO;
	private ProductDAO productDAO;
    public CategoryServlet() {
        super();
        this.categoryDAO=new CategoryDAO();
        this.userDAO=new UserDAO();
        this.productDAO=new ProductDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		
		if (uri.contains("store")) {
			this.store(request, response);
		} else if (uri.contains("update")) {
			this.update(request, response);
		} else {
			// 404
		}
	}
	protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Category> ds=this.categoryDAO.all();
		request.setAttribute("ds", ds);
		request.setAttribute("view", "/views/admin/categories/index.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<User> ds = this.userDAO.all();
		request.setAttribute("dsUser", ds);
		request.setAttribute("view", "/views/admin/categories/create.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}
	protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String ten = request.getParameter("ten");
		String user_id =request.getParameter("user_id");
		if (ten==null||user_id==null) {
			session.setAttribute("error",
					"Không được để trống");
			response.sendRedirect("/PH17657_TranHuyHieu_Assignment_SOF3011"
					+ "/categories/index");
		}else {
			try {
				int userId = Integer.parseInt(user_id);
				User user = this.userDAO.findById(userId);
				Category cate = new Category();
				cate.setTen(ten);
				cate.setUser(user);
				this.categoryDAO.create(cate);
				session.setAttribute("message",
						"Thêm mới thành công");
				response.sendRedirect("/PH17657_TranHuyHieu_Assignment_SOF3011"
						+ "/categories/index");
				} catch (Exception e) {
					e.printStackTrace();
					session.setAttribute("error",
							"Thêm mới thất bại");
					response.sendRedirect("/PH17657_TranHuyHieu_Assignment_SOF3011"
							+ "/categories/index");
				}
		}
		
	}
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idString=request.getParameter("id");
		int id=Integer.parseInt(idString);
		Category entity=this.categoryDAO.findById(id);
		request.setAttribute("category", entity);
		List<User> ds = this.userDAO.all();
		request.setAttribute("dsUser", ds);
		request.setAttribute("view", "/views/admin/categories/edit.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String ten = request.getParameter("ten");
		String user_id =request.getParameter("user_id");
		if (ten==null||user_id==null) {
			session.setAttribute("error",
					"Không được để trống");
			response.sendRedirect(request.getContextPath()
					+ "/categories/edit?id=" + request.getParameter("id"));
		}else {
			try {
			int userId = Integer.parseInt(
				request.getParameter("user_id")
			);
			User user = this.userDAO.findById(userId);
			Category cate = new Category();
			cate.setId(Integer.parseInt(request.getParameter("id")));
			cate.setTen(ten);
			cate.setUser(user);
			this.categoryDAO.update(cate);
			session.setAttribute("message",
					"Sửa thành công");
			response.sendRedirect(request.getContextPath() + "/categories/index");
			} catch (Exception e) {
				e.printStackTrace();
				session.setAttribute("error",
						"Sửa thất bại");
				response.sendRedirect(request.getContextPath()
						+ "/categories/edit?id=" + request.getParameter("id"));
			}
		}
	}
	private void delete(
			HttpServletRequest request,
			HttpServletResponse response
		) throws ServletException, IOException {
		HttpSession session = request.getSession();
			try {
				String s=request.getParameter("id");
				int id=Integer.parseInt(s);
				List<Product> product=this.productDAO.findByCategoryId(id);
				for (Product x:product) {
					this.productDAO.delete(x);
				}
				Category entity =this.categoryDAO.findById(id);
				this.categoryDAO.delete(entity);
				
				session.setAttribute("message",
						"Xóa thành công");
				response.sendRedirect(request.getContextPath() + "/categories/index");
			} catch (Exception e) {
				// TODO: handle exception
				session.setAttribute("error",
						"Xóa thất bại");
				response.sendRedirect(request.getContextPath() + "/categories/index");
			}
		}

}

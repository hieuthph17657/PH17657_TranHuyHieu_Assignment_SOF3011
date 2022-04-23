package controller;

import java.io.IOException;
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
 * Servlet implementation class ProductServlet
 */
@WebServlet({"/products/index",
	"/products/edit",
	"/products/create",
	"/products/update",
	"/products/store",
	"/products/delete"
	})
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ProductDAO productDAO;
	private CategoryDAO categoryDAO;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        this.categoryDAO=new CategoryDAO();
        this.productDAO=new ProductDAO();
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
		List<Product> ds=this.productDAO.all();
		request.setAttribute("ds", ds);
		request.setAttribute("view", "/views/admin/products/index.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Category> ds = this.categoryDAO.all();
		request.setAttribute("dsCate", ds);
		request.setAttribute("view", "/views/admin/products/create.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}
	protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String ten = request.getParameter("ten");
		String soLuong=request.getParameter("soLuong");
		String donGia = request.getParameter("donGia");
		String mauSac = request.getParameter("mauSac");
		String kichThuoc = request.getParameter("kichThuoc");
		String img = request.getParameter("img");
		String category_id = request.getParameter("category_id");
		if(ten==null||soLuong==null||donGia==null||mauSac==null||kichThuoc==null||img==null||category_id==null) {
			session.setAttribute("error",
					"Không được để trống");
			response.sendRedirect(request.getContextPath() + "/products/create");
		}else {
		try {
			
			int cateId = Integer.parseInt(
				request.getParameter("category_id")
			);
			Category cate = this.categoryDAO.findById(cateId);
			Product pro = new Product();
			BeanUtils.populate(pro,
					request.getParameterMap());
			pro.setCategory(cate);
			this.productDAO.create(pro);
			session.setAttribute("message",
					"Thêm mới thành công");
			response.sendRedirect(request.getContextPath() + "/products/index");
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error",
					"Thêm mới thất bại");
			response.sendRedirect(request.getContextPath() + "/products/create");
		}
		}
	}
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idString=request.getParameter("id");
		int id=Integer.parseInt(idString);
		Product entity=this.productDAO.findById(id);
		request.setAttribute("product", entity);
		List<Category> ds = this.categoryDAO.all();
		request.setAttribute("dsCate", ds);
		request.setAttribute("view", "/views/admin/products/edit.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String ten = request.getParameter("ten");
		String soLuong=request.getParameter("soLuong");
		String donGia = request.getParameter("donGia");
		String mauSac = request.getParameter("mauSac");
		String kichThuoc = request.getParameter("kichThuoc");
		String img = request.getParameter("img");
		String category_id = request.getParameter("category_id");
		if(ten==null||soLuong==null||donGia==null||mauSac==null||kichThuoc==null||img==null||category_id==null) {
			session.setAttribute("error",
					"Không được để trống");
			response.sendRedirect(request.getContextPath()
					+ "/products/edit?id=" + request.getParameter("id"));
		}else {
			try {
			int cateId = Integer.parseInt(
				request.getParameter("category_id")
			);
			Category cate = this.categoryDAO.findById(cateId);
			Product pro = new Product();
			pro.setId(Integer.parseInt(request.getParameter("id")));
			BeanUtils.populate(pro,
					request.getParameterMap());
			pro.setCategory(cate);
			this.productDAO.update(pro);
			session.setAttribute("message",
					"Sửa thành công");
			response.sendRedirect("/PH17657_TranHuyHieu_Assignment_SOF3011"
					+ "/products/index");
			} catch (Exception e) {
				e.printStackTrace();
				session.setAttribute("error",
						"Sửa thất bại");
				response.sendRedirect(request.getContextPath()
						+ "/products/edit?id=" + request.getParameter("id"));
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
				Product entity =this.productDAO.findById(id);
				this.productDAO.delete(entity);
				session.setAttribute("message",
						"Xóa thành công");
				response.sendRedirect(request.getContextPath() + "/products/index");
			} catch (Exception e) {
				// TODO: handle exception
				session.setAttribute("error",
						"Xóa thất bại");
				response.sendRedirect(request.getContextPath() + "/products/index");
		}
	}
}

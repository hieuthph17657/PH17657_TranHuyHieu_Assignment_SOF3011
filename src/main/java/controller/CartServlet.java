package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDAO;
import dao.CategoryDAO;
import dao.ProductDAO;
import entities.Cart;
import entities.Product;
import entities.User;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet({"/carts/index",
	"/carts/xacnhan",
	"/carts/huy"})
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO;
    private CategoryDAO categoryDAO;
    private CartDAO cartDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        this.productDAO=new ProductDAO();
        this.categoryDAO=new CategoryDAO();
        this.cartDAO=new CartDAO();
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
		}else if (uri.contains("xacnhan")) {
			this.xacnhan(request, response);
		}else if (uri.contains("huy")) {
			this.huy(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Cart> entity=this.cartDAO.all1();
		request.setAttribute("cart", entity);
		request.setAttribute("view", "/views/admin/carts/index.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}
	protected void xacnhan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		try {
			String idString=request.getParameter("id");
			int id=Integer.parseInt(idString);
			Cart cart=this.cartDAO.findById(id);
			cart.setTrangThai(2);
			System.out.println(cart.toString());
			this.cartDAO.update(cart);
			session.setAttribute("message3",
					"Xác nhận thành công");
			response.sendRedirect(request.getContextPath() + "/carts/index");
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error3",
					"Xác nhận thất bại");
			response.sendRedirect(request.getContextPath() + "/carts/index");
		}
	}
	protected void huy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		try {
			String idString=request.getParameter("id");
			int id=Integer.parseInt(idString);
			Cart cart=this.cartDAO.findById(id);
			cart.setTrangThai(4);
			System.out.println(cart.toString());
			this.cartDAO.update(cart);
			session.setAttribute("message3",
					"Hủy thành công");
			response.sendRedirect(request.getContextPath() + "/carts/index");
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error3",
					"Hủy thất bại");
			response.sendRedirect(request.getContextPath() + "/carts/index");
		}
	}
}

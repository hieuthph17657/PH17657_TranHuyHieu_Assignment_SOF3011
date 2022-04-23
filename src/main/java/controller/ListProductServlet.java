package controller;

import java.io.Console;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.commons.beanutils.BeanUtils;

import dao.CartDAO;
import dao.CategoryDAO;
import dao.ProductDAO;
import entities.Cart;
import entities.Category;
import entities.Product;
import entities.User;

/**
 * Servlet implementation class ListProductServlet
 */
@WebServlet({"/layout_product/danhmuc",
	"/layout_product/index1",
	"/layout_product/dathang",
	"/layout_product/lichsudat",
	"/layout_product/giohang",
	"/layout_product/addgiohang",
	"/layout_product/xoa",
})
public class ListProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO;
    private CategoryDAO categoryDAO;
    private CartDAO cartDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListProductServlet() {
        super();
        this.productDAO=new ProductDAO();
        this.categoryDAO=new CategoryDAO();
        this.cartDAO=new CartDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		if (uri.contains("index1")) {
			this.index(request, response);
		} else if (uri.contains("dathang")) {
			this.dathang(request, response);
		} else if (uri.contains("lichsudat")) {
			this.lichsudat(request, response);
		} else if (uri.contains("danhmuc")) {
			this.danhmuc(request, response);
		}else if (uri.contains("addgiohang")) {
			this.addgiohang(request, response);
		}else if (uri.contains("giohang")) {
			this.giohang(request, response);
		}else if (uri.contains("xoa")) {
			this.xoa(request, response);
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
		String idString=request.getParameter("id");
		int id=Integer.parseInt(idString);
		List<Product> ds=this.productDAO.findByCategoryId(id);
		request.setAttribute("ds", ds);
		request.setAttribute("view", "/views/admin/layout_product/index1.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}
	protected void dathang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		try {
		String idString=request.getParameter("id");
		int id=Integer.parseInt(idString);
		Cart entity=this.cartDAO.findById(id);
		entity.setSoLuong(1);
		int tongTien=entity.getDonGia()*entity.getSoLuong();
		entity.setTongTien(tongTien);
		entity.setTrangThai(1);
		System.out.println(entity.toString());
		this.cartDAO.update(entity);
		session.setAttribute("message2",
				"Đặt hàng thành công");
		response.sendRedirect(request.getContextPath() + "/layout_product/lichsudat");
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error2",
					"Đặt hàng thất bại");
			response.sendRedirect(request.getContextPath() + "/layout_product/lichsudat");
		}
	}
	protected void xoa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		try {
			String idString=request.getParameter("id");
			int id=Integer.parseInt(idString);
			Cart entity=this.cartDAO.findById(id);
			this.cartDAO.delete(entity);
			session.setAttribute("message1",
					"Xóa khỏi giỏ hàng thành công");
			response.sendRedirect(request.getContextPath() + "/layout_product/giohang");
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error1",
					"Xóa khỏi giỏ hàng thất bại");
			response.sendRedirect(request.getContextPath() + "/layout_product/giohang");
		}
		
	}
	protected void lichsudat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User user2=(User)session.getAttribute("user1");
	    List<Cart> cart=this.cartDAO.findByUserIdkhac0(user2.getId());
		request.setAttribute("cart", cart);
		request.setAttribute("view", "/views/admin/layout_product/lichsudat.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
		
	}
	protected void addgiohang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		try {
			Cart cart = new Cart();
			String idString=request.getParameter("id");
			int id=Integer.parseInt(idString);
			Product entity=this.productDAO.findById(id);
			cart.setTen(entity.getTen());	
			cart.setCategoryId(entity.getCategory().getId());
			User user=(User)session.getAttribute("user1");
			cart.setUserId(user.getId());
			cart.setDiaChi(user.getDiaChi());
			cart.setSdt(user.getSdt());
			cart.setDonGia(entity.getDonGia());
			cart.setKichThuoc(Integer.parseInt(entity.getKichThuoc()));
			cart.setMauSac(entity.getMauSac());
			cart.setSoLuong(1);
			int tongTien=cart.getDonGia()*cart.getSoLuong();
			cart.setTongTien(tongTien);
			cart.setTrangThai(0);
			System.out.println(cart.toString());
			this.cartDAO.create(cart);
			session.setAttribute("message1",
					"Thêm vào giỏ hàng thành công");
			response.sendRedirect(request.getContextPath() + "/layout_product/giohang");
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error1",
					"Thêm vào giỏ hàng thất bại");
			response.sendRedirect(request.getContextPath() + "/layout_product/giohang");
		}
		
	}
	protected void giohang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		    HttpSession session = request.getSession();
			User user=(User)session.getAttribute("user1");
		    List<Cart> cart=this.cartDAO.findByUserId0(user.getId());
			request.setAttribute("cart", cart);
			request.setAttribute("view", "/views/admin/layout_product/giohang.jsp");
			request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
		
	}
	
	protected void danhmuc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Category> dscate=this.categoryDAO.all();
		request.setAttribute("dscate", dscate);
		request.setAttribute("view", "/views/admin/layout_product/danhmuc.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}

}

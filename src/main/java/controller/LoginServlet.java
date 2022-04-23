package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import entities.User;
import utils.EncryptUtil;

@WebServlet({"/login"})
public class LoginServlet extends HttpServlet {
	private UserDAO userDAO;
    public LoginServlet() {
        super();
        
        this.userDAO = new UserDAO();
    }
	protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		HttpSession session = request.getSession();
        //String uri = request.getRequestURI();
		String action=request.getParameter("action");
		if (action.equals("dangnhap")) {
			session.removeAttribute("user1");
			request.setAttribute("view", "/views/login.jsp");
			request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
		} else if (action.equals("dangxuat")) {
			session.removeAttribute("user1");
			response.sendRedirect(
					"/PH17657_TranHuyHieu_Assignment_SOF3011" +
					"/layout_product/danhmuc");	
		}
//		else {
//			session.removeAttribute("user1");
//			request.getRequestDispatcher("/views/admin/layout_product/index1.jsp")
//				.forward(request, response);
//		}
		
	}

	protected void doPost(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = request.getParameter("email"),
			pwd = request.getParameter("password");
		
		User user1 = this.userDAO.findByEmail(email);
		
		boolean check = EncryptUtil.check(pwd, user1.getPassword());

		if (check == true) {
			// Đăng nhập thành công
			session.setAttribute("user1", user1);
			response.sendRedirect(
					"/PH17657_TranHuyHieu_Assignment_SOF3011" +
					"/layout_product/danhmuc");
		} else {
			// Đăng nhập thất bại
			session.removeAttribute("user1");
			response.sendRedirect(
					"/PH17657_TranHuyHieu_Assignment_SOF3011" +
					"/login?action=dangnhap");
		}
		
		
	}
}

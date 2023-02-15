package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CategoryDAO;
import dao.ProductDAO;
import entity.Category;
import entity.Product;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			
			String action = request.getParameter("action");
			String categoryId = request.getParameter("categoryId");
			HttpSession session = request.getSession();
			
			// Product product = productDAO.getProductById();
			CategoryDAO categoryDAO = new CategoryDAO();
			List<Category> list = categoryDAO.getAllCategories();

			ProductDAO productDAO = new ProductDAO();
			List<Product> productList;

			if (categoryId == null) {
				productList = productDAO.getAllProducts();
			} else {
				productList = productDAO.getProductByCategoryId(Integer.parseInt(categoryId));
			}
			
			session.setAttribute("categoryList", list);
			session.setAttribute("productList", productList);
			
//			request.setAttribute("categoryList", list);
//			request.setAttribute("productList", productList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
			
			/* LOGO HOME BUTTON */
			if (action != null && action.equals("goHome")) {
				response.sendRedirect("home.jsp");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

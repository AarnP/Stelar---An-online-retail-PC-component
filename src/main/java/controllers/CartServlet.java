package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;
import entity.Product;
import model.Cart;
import model.Item;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action.equals("VIEW_CART")) {
			response.sendRedirect("cart.jsp");
		}

		if (action.equals("ADD_TO_CART")) {
			try {
				addToCart(request, response);
			} catch (NumberFormatException | IOException | SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void addToCart(HttpServletRequest request, HttpServletResponse response)
			throws IOException, NumberFormatException, SQLException {
		ProductDAO productDAO = new ProductDAO();
		HttpSession session = request.getSession();
		String productId = request.getParameter("productId");
		Cart cart = new Cart();

		Item item = new Item();
		Product product = productDAO.getProductById(Integer.parseInt(productId));

		item.setProduct(product);
		item.setQuantity(1);

		List<Item> items = new ArrayList<Item>();

		if (session.getAttribute("cart") != null) {
			cart = (Cart) session.getAttribute("cart");
			items = cart.getItems();
			// Check if productId exist in items
			for (int i = 0; i < items.size(); i++) {
				if (items.get(i).getProduct().getId() == Integer.parseInt(productId)) {
					items.get(i).setQuantity(items.get(i).getQuantity() + 1);
					item = items.get(i);
					items.remove(i);
				}
			}
		}
		items.add(item);
		cart.setItems(items);

		int totalItem = 0;
		for (Item itemInCart : items) {
			totalItem += itemInCart.getQuantity();
		}
		cart.setTotalItem(totalItem);
		session.setAttribute("cart", cart);
		response.sendRedirect("HomeServlet");

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

package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.*;
import org.hibernate.Hibernate;
import service.impl.*;
import utility.Email;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/addToCart", "/removeCart", "/updateCart", "/viewCart", "/checkout", "/updateChooseCart"})
@MultipartConfig
public class CartServlet extends HttpServlet {

	ProductServiceImpl productService = new ProductServiceImpl();
	UserServiceImpl userService = new UserServiceImpl();
	CartServiceImpl cartService = new CartServiceImpl();
	LineItemServiceImpl lineItemService = new LineItemServiceImpl();
	OrderServiceImpl orderService = new OrderServiceImpl();
	OrderDetailServiceImpl orderDetailService = new OrderDetailServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String url = request.getRequestURL().toString();
		if (url.contains("viewCart")) {
			try {
				viewCart(request, response);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		} else if (url.contains("addToCart")) {
			addToCart(request, response);
		}else if (url.contains("checkout")) {
			request.getRequestDispatcher("/views/add-order.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String url = request.getRequestURL().toString();
		if (url.contains("addToCart")) {
			addToCart(request, response);
		} else if (url.contains("updateCart")) {
			updateCart(request, response);
		}else if (url.contains("updateChooseCart")) {
			updateChooseCart(request, response);
		} else if (url.contains("removeCart")) {
			removeCart(request, response);
		} else if (url.contains("viewCart")) {
			try {
				viewCart(request, response);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		} else if (url.contains("checkout")) {
			checkout(request, response);
		}
	}

	@SuppressWarnings("unchecked")
	private void checkout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			// Get product by Id
			Email sm = new Email();
			String toEmail = request.getParameter("email");
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("account");
			Cart cart = (Cart) session.getAttribute("cart");
			if (cart == null) {
				cart = new Cart();
			}
			Order order = new Order();
			order.setUser(userService.findByEmail(toEmail));
			order.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			order.setAddress(request.getParameter("address"));
			order.setPhone(request.getParameter("phone"));
			orderService.insert(order);
			for (LineItem lineItem : cart.getLineItems()) {
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setProduct(lineItem.getProduct());
				orderDetail.setQuantity(lineItem.getQuantity());
				orderDetail.setOrder(order);
				Product product = orderDetail.getProduct();
				product.setQuantity(product.getQuantity() - orderDetail.getQuantity());
				productService.update(product);
				orderDetailService.insert(orderDetail);
				lineItemService.delete(LineItem.class, lineItem.getId());
			}
			order.setOrderDetails(orderDetailService.getOrderDetailsByOrderId(order.getId()));;
			sm.sendEmail(toEmail, order);
			session.removeAttribute("order");
			request.getRequestDispatcher("/views/thankyou.jsp").forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void updateChooseCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// Get product by Id
			int product_id = Integer.parseInt(request.getParameter("product_id"));
			Product product = (Product) productService.findById(Product.class, product_id);
			Boolean choose = Boolean.parseBoolean(request.getParameter("choose"));
			System.out.println("choose_string="+choose);

			LineItem lineItem = new LineItem();
			lineItem.setProduct(product);
			lineItem.setChoose(choose);
			// Check if user login or not
			HttpSession session = request.getSession();
			User user_login = (User) session.getAttribute("account");
			// User do not login
			if (user_login == null) {
				Cart cart = (Cart) session.getAttribute("cart");
				cart.updateChooseLineItem(lineItem, choose);

				session.setAttribute("cart", cart);
			}
			// User logged in
			else{
				LineItem lineItem_temp = lineItemService.findLineItemByProduct(product_id);
				lineItem_temp.setChoose(choose);
				lineItemService.update(lineItem_temp);
			}
			response.sendRedirect("viewCart");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


	@SuppressWarnings("unchecked")
	private void addToCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// Get product by Id
			int product_id = Integer.parseInt(request.getParameter("product_id"));
			Product product = (Product) productService.findById(Product.class, product_id);

			LineItem lineItem = new LineItem();
			lineItem.setProduct(product);
			// Check if user login or not
			HttpSession session = request.getSession();
			User user_login = (User)session.getAttribute("account");

			//System.out.println("UserLogin_email = "+ user_login.getEmail());
			// User do not login
			if (user_login == null) {
				Cart cart = (Cart) session.getAttribute("cart");
				if (cart == null) {
					cart = new Cart();
				}

				int quantity = cart.getQuantityItem(lineItem);
				if (quantity >= 1){
					quantity += 1;
					cart.updateLineItem(lineItem, quantity);
				}
				else if (quantity < 0) {
					quantity = 1;
					lineItem.setQuantity(quantity);
					cart.addLineItem(lineItem);
				}

				session.setAttribute("cart", cart);
			}
			// User logged in
			else{
				// find cart of user
				User user = userService.findByEmail(user_login.getEmail());
				Cart cart = cartService.findByUser(user);
				if (cart == null){
					cart = new Cart(user);
					cartService.insert(cart);
				}
				int quantity = 1;
				LineItem lineItem_temp = lineItemService.findLineItemByProduct(product_id);
				//System.out.println("Line item temp" + lineItem_temp.getQuantity());
				System.out.println("LineItem"+lineItem_temp);
				System.out.println("CartID:"+cart.getId());
				if (lineItem_temp == null){
					quantity = 1;
					lineItem.setQuantity(quantity);
					lineItem.setCart(cart);
					lineItemService.insert(lineItem);
				}
				else {
					quantity = lineItem_temp.getQuantity() + 1;
					lineItem_temp.setQuantity(quantity);
					lineItem_temp.setCart(cart);
					lineItemService.update(lineItem_temp);
				}
			}
			response.sendRedirect("viewCart");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private void updateCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// Get product by Id
			int product_id = Integer.parseInt(request.getParameter("product_id"));
			Product product = (Product) productService.findById(Product.class, product_id);
			String quantityString = request.getParameter("quantity");
			LineItem lineItem = new LineItem();
			lineItem.setProduct(product);
			int quantity;
			try {
				quantity = Integer.parseInt(quantityString);
				if (quantity < 0) {
					quantity = 1;
				}
			} catch (NumberFormatException nfe) {
				quantity = 1;
			}
			if (quantity > product.getQuantity()) {
				request.setAttribute("error", "Quantity cannot exceed stock!");
				request.getRequestDispatcher("/views/cart.jsp").forward(request, response);
			}
			// if the user enters a negative or invalid quanity,
			// the quantity is automatically resit to 1.

			lineItem.setQuantity(quantity);
			// Check if user login or not
			HttpSession session = request.getSession();
			User user_login = (User) session.getAttribute("account");
			// User do not login
			if (user_login == null) {
				Cart cart = (Cart) session.getAttribute("cart");

				if (quantity > 0) {
					cart.updateLineItem(lineItem, quantity);
				} else if (quantity == 0) {
					cart.removeLineItem(lineItem);
				}
				session.setAttribute("cart", cart);
			}
			// User logged in
			else{
				LineItem lineItem_temp = lineItemService.findLineItemByProduct(product_id);
				lineItem_temp.setQuantity(lineItem.getQuantity());
				if (quantity > 0) {
					lineItemService.update(lineItem_temp);
				} else if (quantity == 0) {
					lineItemService.delete(LineItem.class, lineItem_temp.getId());
				}
			}
			response.sendRedirect("viewCart");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private void removeCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// Get product by Id
			int product_id = Integer.parseInt(request.getParameter("product_id"));
			System.out.println("Product Id=" + product_id);
			Product product = (Product) productService.findById(Product.class, product_id);
			LineItem lineItem = new LineItem();
			lineItem.setProduct(product);
			// Check if user login or not
			HttpSession session = request.getSession();
			User user_login = (User) session.getAttribute("account");
			// User do not login
			if (user_login == null) {
				Cart cart = (Cart) session.getAttribute("cart");
				if (cart == null) {
					cart = new Cart();
				}
				cart.removeLineItem(lineItem);
				session.setAttribute("cart", cart);
//                url = "/homework/week7/ex7-2/cart.jsp";
			}
			// User logged in
			else {
				LineItem lineItem_temp = lineItemService.findLineItemByProduct(product_id);
				lineItemService.delete(LineItem.class, lineItem_temp.getId());

			}
			response.sendRedirect("viewCart");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void viewCart(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		try {
			// Check if user login or not
			HttpSession session = request.getSession();
			User user_login = (User) session.getAttribute("account");

			// User do not login
			if (user_login == null) {
				String url= "/views/cart.jsp";
				request.getRequestDispatcher(url).forward(request, response);
			}
			// User logged in
			else{
				// find cart of user
				User user = userService.findByEmail(user_login.getEmail());
				System.out.println("UserLogin"+user_login.getEmail());
				Cart cart_database = cartService.findByUser(user);

				if (cart_database == null){
					Cart cart = (Cart) session.getAttribute("cart");
					if (cart == null) {
						cart = new Cart();
					}
					cart_database = cart;
					cart_database.setUser(user);
					cartService.insert(cart_database);
				}
				List<LineItem> lineItems = cartService.getAllLineItem(cart_database.getId());
//				for (int i = 0;  i < lineItems.size(); i++)
//					System.out.println("LineitemID=" + lineItems.get(i).getId());
				cart_database.setLineItems(lineItems);
//				System.out.println("id LineItem Fisrt =" + lineItems.get(0).getId());
//				System.out.println("quantity LineItem Fisrt =" + lineItems.get(0).getQuantity());
//				System.out.println("product first =" + lineItems.get(0).getProduct().getName());
//				System.out.println("Name product =" + cart_database.getLineItems().get(0).getProduct().getId());
				session.setAttribute("cart", cart_database);
				String url= "/views/cart.jsp";
				request.getRequestDispatcher(url).forward(request, response);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}


}

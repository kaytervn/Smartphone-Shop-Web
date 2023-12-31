package controller;

import model.Order;
import model.OrderDetail;
import model.Product;
import model.User;
import service.impl.OrderDetailServiceImpl;
import service.impl.OrderServiceImpl;
import service.impl.ProductServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/viewOrder", "/listOrder" })
@MultipartConfig
public class OrderServlet extends HttpServlet {

	UserServiceImpl userService = new UserServiceImpl();
	ProductServiceImpl productService = new ProductServiceImpl();
	OrderServiceImpl orderService = new OrderServiceImpl();
	OrderDetailServiceImpl orderDetailService = new OrderDetailServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		List<User> listUser = userService.getAll(User.class);
		request.setAttribute("listUser", listUser);
		String url = request.getRequestURL().toString();
		if (url.contains("listOrder")) {
			List<Order> listOrder = orderService.getAll(Order.class);
			request.setAttribute("listOrder", listOrder);
			request.getRequestDispatcher("/views/admin/order/order-list.jsp").forward(request, response);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String url = request.getRequestURL().toString();
		if (url.contains("viewOrder")) {
			List<OrderDetail> listOrderDetail = orderDetailService
					.getOrderDetailsByOrderId(Integer.parseInt(request.getParameter("id")));
			List<Product> listProduct = productService.getAll(Product.class);
			request.setAttribute("listProduct", listProduct);
			request.setAttribute("listOrderDetail", listOrderDetail);
			request.getRequestDispatcher("/views/admin/order/order-detail-list.jsp").forward(request, response);
		}
	}
}

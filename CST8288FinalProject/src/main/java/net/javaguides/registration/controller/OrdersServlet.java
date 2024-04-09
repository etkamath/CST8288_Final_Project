package net.javaguides.registration.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.javaguides.registration.dao.OrdersDao;
import net.javaguides.registration.model.Orders;
import net.javaguides.registration.dao.FoodDao; 


import java.io.IOException;
import java.sql.Date;

/**
 * Servlet implementation class OrdersServlet
 * This servlet handles operations related to orders.
 */
@WebServlet("/OrdersServlet")
public class OrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * Default constructor.
     */
    public OrdersServlet () {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * Handles the GET requests.
     * @param request HttpServletRequest object
     * @param response HttpServletResponse object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
     * Handles the POST requests.
     * This method adds an order and updates food item quantity.
     * @param request HttpServletRequest object
     * @param response HttpServletResponse object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int itemID = Integer.parseInt(request.getParameter("itemID"));
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        String name = request.getParameter("name");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Date deliveryDate = Date.valueOf(request.getParameter("deliveryDate")); 
        // Create Orders object and set its properties
        Orders orders = new Orders();
        orders.setItemID(itemID);
        orders.setAddress(address);
        orders.setName(name);
        orders.setPhoneNumber(phoneNumber);
        orders.setQuantity(quantity);
        orders.setDeliveryDate(deliveryDate);
     // Use OrdersDao to add the order
        OrdersDao ordersDao = new OrdersDao();
        ordersDao.addOrders(orders);
     // Use FoodDao to update food item quantity
        FoodDao foodItemDao = new FoodDao();
        foodItemDao.updateFoodItemQuantity(itemID, quantity);
     // Redirect after operation
        response.sendRedirect("OrderAddedSuccess.jsp");
    }
}
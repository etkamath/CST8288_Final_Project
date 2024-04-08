package net.javaguides.registration.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.javaguides.registration.dao.TransactionDao;
import net.javaguides.registration.model.Transaction;
import net.javaguides.registration.dao.FoodDao; // FoodItemDao'yu import et


import java.io.IOException;
import java.sql.Date;

/**
 * Servlet implementation class TransactionServlet
 */
@WebServlet("/TransactionServlet")
public class TransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransactionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	// Örnek TransactionServlet doPost metodu
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int itemID = Integer.parseInt(request.getParameter("itemID"));
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        String name = request.getParameter("name");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Date deliveryDate = Date.valueOf(request.getParameter("deliveryDate")); 

        Transaction transaction = new Transaction();
        transaction.setItemID(itemID);
        transaction.setAddress(address);
        transaction.setName(name);
        transaction.setPhoneNumber(phoneNumber);
        transaction.setQuantity(quantity);
        transaction.setDeliveryDate(deliveryDate);

        TransactionDao transactionDao = new TransactionDao();
        transactionDao.addTransaction(transaction);

        // Stok miktarını güncelle
        FoodDao foodItemDao = new FoodDao();
        foodItemDao.updateFoodItemQuantity(itemID, quantity);

        response.sendRedirect("orderSuccess.jsp");
    }
}
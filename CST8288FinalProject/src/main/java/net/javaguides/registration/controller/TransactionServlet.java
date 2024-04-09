package net.javaguides.registration.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.javaguides.registration.dao.TransactionDao;
import net.javaguides.registration.model.Transaction;
import net.javaguides.registration.dao.FoodDao;

import java.io.IOException;
import java.sql.Date;

/**
 * Servlet implementation class TransactionServlet
 * This servlet handles transaction-related operations.
 */
@WebServlet("/TransactionServlet")
public class TransactionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * Default constructor.
     */
    public TransactionServlet() {
        super();
    }

    /**
     * Handles the GET requests.
     * @param request HttpServletRequest object
     * @param response HttpServletResponse object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * Handles the POST requests.
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

        // Create Transaction object and set its properties
        Transaction transaction = new Transaction();
        transaction.setItemID(itemID);
        transaction.setAddress(address);
        transaction.setName(name);
        transaction.setPhoneNumber(phoneNumber);
        transaction.setQuantity(quantity);
        transaction.setDeliveryDate(deliveryDate);

        // Use TransactionDao to add the transaction
        TransactionDao transactionDao = new TransactionDao();
        transactionDao.addTransaction(transaction);

        // Update stock quantity
        FoodDao foodItemDao = new FoodDao();
        foodItemDao.updateFoodItemQuantity(itemID, quantity);

        // Redirect after operation
        response.sendRedirect("OrderAddedSuccess2.jsp");
    }
}

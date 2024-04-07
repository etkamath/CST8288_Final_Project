package net.javaguides.registration.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.javaguides.registration.model.FoodItem;
import net.javaguides.registration.model.User;
import net.javaguides.registration.dao.FoodDao;

import java.io.IOException;
import java.sql.Date;

@WebServlet("/FoodItemServlet")
public class FoodItemServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public FoodItemServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Implementation can vary based on requirements
        doPost(request, response); // This line suggests a simple redirect to doPost for any GET requests.
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("createFood".equals(action)) {
            createFood(request, response);
        } else if ("updateQuantity".equals(action)) {
            updateItemQuantity(request, response);
        } else {
            // Handle other actions or error scenario
            response.getWriter().println("Action not recognized");
        }
    }

    private void createFood(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Retrieve form data
        String name = request.getParameter("name");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Date expiryDate = Date.valueOf(request.getParameter("expiryDate"));
        boolean isSurplus = Boolean.parseBoolean(request.getParameter("isSurplus"));

        // Assuming session management for logged-in user
        User loggedInUser = (User) request.getSession().getAttribute("loggedInUser");
        int retailerID = loggedInUser.getUserID(); // Example to retrieve retailer ID

        // Create FoodItem object and set its properties
        FoodItem food = new FoodItem();
        food.setRetailerID(retailerID);
        food.setName(name);
        food.setQuantity(quantity);
        food.setExpiryDate(expiryDate);
        food.setSurplus(isSurplus);

        // Use FoodDao to interact with the database
        FoodDao foodDao = new FoodDao();
        foodDao.createFood(food);

        // Redirect or forward after operation
        response.sendRedirect("foodItemAddedSuccess.jsp");
    }

    private void updateItemQuantity(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        int newQuantity = Integer.parseInt(request.getParameter("newQuantity"));

        FoodDao foodDao = new FoodDao();
        boolean updateStatus = foodDao.updateItemQuantity(itemId, newQuantity);

        if (updateStatus) {
            request.setAttribute("message", "Quantity updated successfully.");
            request.getRequestDispatcher("/updateSuccess.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "Failed to update quantity.");
            request.getRequestDispatcher("/updateFailure.jsp").forward(request, response);
        }
    }
}

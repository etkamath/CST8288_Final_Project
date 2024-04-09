package net.javaguides.registration.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import net.javaguides.registration.dao.RetailerDao;
import net.javaguides.registration.model.Retailer;
import net.javaguides.registration.model.User;

import java.io.IOException;

/**
 * Servlet implementation class RetailerServlet
 * This servlet handles operations related to retailers.
 */
@WebServlet("/RetailerServlet")
public class RetailerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
     * Default constructor.
     */
    public RetailerServlet() {
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
     * @param request HttpServletRequest object
     * @param response HttpServletResponse object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        
        if ("createRetailer".equals(action)) {
        	// Get store information from the form.
            String storeName = request.getParameter("storeName");
            String location = request.getParameter("location");
            
         // Create Retailer object and set information from the form.
            Retailer retailer = new Retailer();
            retailer.setRetailerID(loggedInUser.getUserID()); // Oturumdaki UserID'yi al.
            retailer.setStoreName(storeName);
            retailer.setLocation(location);
            
         // Use RetailerDao to save to the database.
            RetailerDao retailerDao = new RetailerDao();
            retailerDao.createRetailer(retailer);
            
         // Redirect or show a message after the operation.
            response.sendRedirect("manageFoodItems.jsp");// Success page
        } else {
        	// Codes for other actions will be here.
        }
    }


}
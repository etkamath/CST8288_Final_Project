package net.javaguides.registration.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import net.javaguides.registration.dao.CharitableOrganizationDao;
import net.javaguides.registration.model.CharitableOrganization;
import net.javaguides.registration.model.User;

import java.io.IOException;

/**
 * Servlet implementation class CharityServlet
 * This servlet handles operations related to charitable organizations.
 */
@WebServlet("/CharityServlet")
public class CharityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * Default constructor.
     */
    public CharityServlet() {
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
        
        if ("createCharitableOrganization".equals(action)) {
        	// Get organization information from the form.
            String organizationName = request.getParameter("organizationName");
            String location = request.getParameter("location");
            
            // Create a CharitableOrganization object and set information from the form.
            CharitableOrganization charity = new CharitableOrganization();
            charity.setOrganizationID(loggedInUser.getUserID()); // Get UserID from the session.
            charity.setOrganizationName(organizationName);
            charity.setLocation(location);
            
            // Save to the database through CharitableOrganizationDao.
            CharitableOrganizationDao charityDao = new CharitableOrganizationDao();
            charityDao.createCharitableOrganization(charity);
            
         // Redirect to another page or show a message after the operation.
            response.sendRedirect("charityPage.jsp"); // Success page
        } else {
        	System.out.println("burdah hata");
        	
        	// Codes for other actions will be here..
        }
    }


}

package net.javaguides.registration.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import net.javaguides.registration.dao.UserDao;
import net.javaguides.registration.model.User;

import java.io.IOException;

/**
 * Servlet implementation class UserServlet
 * This servlet handles user-related operations such as registration, login, and logout.
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * Default constructor.
     */
    public UserServlet() {
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
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
        
        if ("register".equals(action)) {
            // Retrieve data from the form
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String userType = request.getParameter("usertype");
            
            // Create a new User object
            User newUser = new User();
            newUser.setUserName(username);
            newUser.setEmail(email);
            newUser.setPassword(password);
            newUser.setUserType(userType);
            
            // Save the user to the database
            UserDao userDao = new UserDao();
            userDao.createUser(newUser);
            
            // Redirect to login page after registration
            response.sendRedirect("login.jsp");
        }
        
        // Additional else if blocks can be added for other 'action' values
        
        if ("login".equals(action)) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String userType = request.getParameter("usertype");
            
            UserDao userDao = new UserDao();
            User user = userDao.findUserByEmail(email);
            
            if (user != null && user.getPassword().equals(password) && user.getUserType().equals(userType)) {
                // Successful login with userType check
                HttpSession session = request.getSession();
                session.setAttribute("loggedInUser", user);
                // Redirect based on user type
                switch(user.getUserType()) {
                    case "Retailer":
                        response.sendRedirect("retailerProfile.jsp");
                        break;
                    case "Consumer":
                        response.sendRedirect("consumerProfile.jsp");
                        break;
                    case "Charitable Organization":
                        response.sendRedirect("charityProfile.jsp");
                        break;
                    default:
                        // Handle unknown user type
                        response.sendRedirect("login.jsp?error=Invalid user type");
                        break;
                }
            } else {
                // Login failed
                response.sendRedirect("login.jsp?error=Invalid credentials");
            }
        } else if ("logout".equals(action)) {
            // Logout logic
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
            response.sendRedirect("userprofile.jsp");
        }
    }
}

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
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	            throws ServletException, IOException {
	        String action = request.getParameter("action");
			HttpSession session = request.getSession();
	        if ("register".equals(action)) {
	            // Formdan gelen verileri al
	            String username = request.getParameter("username");
	            String email = request.getParameter("email");
	            String password = request.getParameter("password");
	            String userType = request.getParameter("usertype");
	            
	            // User nesnesi oluştur
	            User newUser = new User();
	            newUser.setUserName(username);
	            newUser.setEmail(email);
	            newUser.setPassword(password);
	            newUser.setUserType(userType);
	            
	            // Kullanıcıyı veritabanına kaydet
	            UserDao userDao = new UserDao();
	            userDao.createUser(newUser);
				User user = userDao.findUserByEmail(email);

				session.setAttribute("loggedInUser", user);

				// Kayıttan sonra giriş sayfasına yönlendir
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
	        }
	        // Diğer 'action' değerleri için else if blokları eklenebilir
	        
	        if ("login".equals(action)) {
	            String email = request.getParameter("email");
	            String password = request.getParameter("password");
	            String userType = request.getParameter("usertype");
	            
	            UserDao userDao = new UserDao();
	            User user = userDao.findUserByEmail(email);
	            
	            if (user != null && user.getPassword().equals(password) && user.getUserType().equals(userType)) {
	                // Successful login with userType check
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
	             session = request.getSession(false);
	            if (session != null) {
	                session.invalidate();
	            }
	            response.sendRedirect("userprofile.jsp");
	        }
	    }
	}
package net.javaguides.registration.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.javaguides.registration.dao.EmployeeDao;
import net.javaguides.registration.model.Employee;

import java.io.IOException;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/register")
public class EmployeeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	 private EmployeeDao employeeDao = new EmployeeDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());

        RequestDispatcher dispatcher = request.getRequestDispatcher("employeeregister.jsp");
        dispatcher.forward(request, response);
    }
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        String firstName = request.getParameter("firstName");
		        String lastName = request.getParameter("lastName");
		        String username = request.getParameter("username");
		        String password = request.getParameter("password");
		        String address = request.getParameter("address");
		        String contact = request.getParameter("contact");

		        Employee employee = new Employee();
		        employee.setFirstName(firstName);
		        employee.setLastName(lastName);
		        employee.setUsername(username);
		        employee.setPassword(password);
		        employee.setAddress(address);
		        employee.setContact(contact);

		        try {
		            employeeDao.registerEmployee(employee);
		        } catch (Exception e) {
		            // Handle exceptions
		            e.printStackTrace();
		        }
		        
		        RequestDispatcher dispatcher = request.getRequestDispatcher("employeedetails.jsp");
		        dispatcher.forward(request, response); // Assuming you have a success.jsp for successful registration
		    }
}

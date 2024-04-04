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

/**
 * Servlet implementation class FoodItemServlet
 */
@WebServlet("/FoodItemServlet")
public class FoodItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodItemServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if ("createFood".equals(action)) {
            // Formdan gelen gıda ürünü bilgilerini al.
            String name = request.getParameter("name");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            Date expiryDate = Date.valueOf(request.getParameter("expiryDate"));
            boolean isSurplus = Boolean.parseBoolean(request.getParameter("isSurplus"));
            
            User loggedInUser = (User) request.getSession().getAttribute("loggedInUser");
            int retailerID = loggedInUser.getUserID(); // RetailerID aslında mevcut oturumdaki UserID'dir.

            // FoodItem nesnesini oluştur ve formdan alınan bilgileri set et.
            FoodItem food = new FoodItem();
            food.setRetailerID(retailerID);
            food.setName(name);
            food.setQuantity(quantity);
            food.setExpiryDate(expiryDate);
            food.setSurplus(isSurplus);
            
            // FoodItemDao aracılığıyla veritabanına kaydet.
            FoodDao foodDao = new FoodDao();
            foodDao.createFood(food);
            
            // İşlem sonrasında başka bir sayfaya yönlendir veya mesaj göster.
            response.sendRedirect("foodItemAddedSuccess.jsp"); // İşlem başarılı sayfası
        } else {
            // Diğer aksiyonlar için kodlar burada olacak.
        }
    }
}
	



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
 */
@WebServlet("/RetailerServlet")
public class RetailerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetailerServlet() {
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
        HttpSession session = request.getSession();
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        
        if ("createRetailer".equals(action)) {
            // Formdan gelen mağaza bilgilerini al.
            String storeName = request.getParameter("storeName");
            String location = request.getParameter("location");
            
            // Retailer nesnesini oluştur ve formdan alınan bilgileri set et.
            Retailer retailer = new Retailer();
            retailer.setRetailerID(loggedInUser.getUserID()); // Oturumdaki UserID'yi al.
            retailer.setStoreName(storeName);
            retailer.setLocation(location);
            
            // RetailerDao aracılığıyla veritabanına kaydet.
            RetailerDao retailerDao = new RetailerDao();
            retailerDao.createRetailer(retailer);
            
            // İşlem sonrasında başka bir sayfaya yönlendir veya mesaj göster.
            response.sendRedirect("retailerSuccess.jsp"); // İşlem başarılı sayfası
        } else {
            // Diğer aksiyonlar için kodlar burada olacak.
        }
    }


}

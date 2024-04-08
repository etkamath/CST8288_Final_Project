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
 */
@WebServlet("/CharityServlet")
public class CharityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CharityServlet() {
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
        
        if ("createCharitableOrganization".equals(action)) {
            // Formdan gelen organizasyon bilgilerini al.
            String organizationName = request.getParameter("organizationName");
            String location = request.getParameter("location");
            
            // CharitableOrganization nesnesini oluştur ve formdan alınan bilgileri set et.
            CharitableOrganization charity = new CharitableOrganization();
            charity.setOrganizationID(loggedInUser.getUserID()); // Oturumdaki UserID'yi al.
            charity.setOrganizationName(organizationName);
            charity.setLocation(location);
            
            // CharitableOrganizationDao aracılığıyla veritabanına kaydet.
            CharitableOrganizationDao charityDao = new CharitableOrganizationDao();
            charityDao.createCharitableOrganization(charity);
            
            // İşlem sonrasında başka bir sayfaya yönlendir veya mesaj göster.
            response.sendRedirect("charityPage.jsp"); // İşlem başarılı sayfası
        } else {
        	System.out.println("burdah hata");
        	
            // Diğer aksiyonlar için kodlar burada olacak.
        }
    }


}

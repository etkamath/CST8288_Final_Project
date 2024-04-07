package net.javaguides.registration.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import net.javaguides.registration.dao.FoodDao;
import net.javaguides.registration.dao.TransactionDao;
import net.javaguides.registration.model.FoodItem;
import net.javaguides.registration.model.Transaction;
import net.javaguides.registration.model.User;

import java.io.IOException;
import java.util.Calendar;

@WebServlet("/DonationFoodServlet")
public class DonationFoodServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) {
            resp.sendRedirect("login.jsp");
            return;
        }
        if (user.getUserType().equals("Charitable Organization")) {
            FoodDao foodDao = new FoodDao();

            if(req.getParameter("id")!=null && req.getParameter("number")!=null){
                int foodId= Integer.parseInt(req.getParameter("id"));
                int num= Integer.parseInt(req.getParameter("number"));
                FoodItem f= foodDao.findFoodById(foodId);
                if(f==null){
                    throw new ServletException("The selected food doesn't exist");

                }
                if(f.getQuantity()-num<0){
                    throw new ServletException("Quantity is zero");

                }
                Transaction transaction= new Transaction();
                transaction.setTransactionType("Donate");
                transaction.setUserID(user.getUserID());
                transaction.setItemID(foodId);
                transaction.setTransactionDate(Calendar.getInstance().getTime());
                transaction.setQuantity(num);

                TransactionDao transactionDao = new TransactionDao();
                transactionDao.createTransaction(transaction);
                f.setQuantity(f.getQuantity()-num);
                foodDao.updateFood(f);
                req.setAttribute("foods", foodDao.getAllDonationFoodItems());

                req.getRequestDispatcher("showDonationFood.jsp").forward(req, resp);

            }else {
                req.setAttribute("foods", foodDao.getAllDonationFoodItems());

                req.getRequestDispatcher("showDonationFood.jsp").forward(req, resp);
            }
        }

    }
}

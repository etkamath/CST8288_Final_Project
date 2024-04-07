package net.javaguides.registration.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import net.javaguides.registration.dao.SubscriptionDao;
import net.javaguides.registration.model.Subscription;
import net.javaguides.registration.model.User;

import java.io.IOException;

@WebServlet("/SubscriptionServlet")
public class SubscriptionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) {
            resp.sendRedirect("login.jsp");
            return;
        }
        SubscriptionDao subscriptionDao= new SubscriptionDao();
        Subscription subscription=subscriptionDao.findSubscriptionByUserId(user.getUserID());
     /*   if(subscription!=null){
            throw new IllegalStateException("You don't have any subscription");
        }*/
        if (user.getUserType().equals("Consumer")) {
            req.setAttribute("sub",subscription);
            req.getRequestDispatcher("showSubscription.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) {
            resp.sendRedirect("login.jsp");
            return;
        }
        SubscriptionDao subscriptionDao= new SubscriptionDao();
        Subscription subscription=subscriptionDao.findSubscriptionByUserId(user.getUserID());
        if(subscription!=null){
            throw new IllegalStateException("You already have a subscription");
        }
        if (user.getUserType().equals("Consumer")) {
            System.out.println("hi");
           String location= req.getParameter("location");
           String pref= req.getParameter("pref");
           String contactMethod= req.getParameter("contactmethod");
             subscription= new Subscription();
            subscription.setLocation(location);
            subscription.setPreferences(pref);
            subscription.setUserID(user.getUserID());
            subscription.setContactMethod(contactMethod);
            subscriptionDao.createSubscription(subscription);
        }
        resp.sendRedirect("consumerProfile.jsp");
    }
}

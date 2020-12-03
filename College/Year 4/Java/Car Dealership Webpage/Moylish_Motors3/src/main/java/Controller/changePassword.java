/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dell
 */
@WebServlet(name = "changePassword", urlPatterns = {"/changePassword"})
public class changePassword extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String currentPassword = request.getParameter("currentPassword");
        String newPassword = request.getParameter("newPassword");
        
        HttpSession session = request.getSession();
        User sessionObj = (User) session.getAttribute("loggedInUser");
        String username = sessionObj.getUsername();

        User userObj = new User();

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        try {
            int result = userObj.changePassowrd(username, currentPassword, newPassword);
            response.getWriter().write(Integer.toString(result));
        } catch (Exception e) {
            System.out.println("Exception in change password  controller: " + e);
            response.getWriter().write("-1");
        }
    }
}

package Controller;

import Model.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "updateProfile", urlPatterns = {"/updateProfile"})
public class updateProfile extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        int contact = Integer.parseInt(request.getParameter("contact"));
        String address = request.getParameter("address");
        String fax = request.getParameter("fax");
        User userObj = new User(username, name, email, contact, address, fax);

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        try {
            int result = userObj.updateUser();
            User user = userObj.getUserbyUsername(username);
            HttpSession session = request.getSession();
            session.setAttribute("loggedInUser",user);
            response.getWriter().write(Integer.toString(result));
        } catch (Exception e) {
            System.out.println("Exception in update user controller: " + e);
            response.getWriter().write("-1");
        }
    }

}

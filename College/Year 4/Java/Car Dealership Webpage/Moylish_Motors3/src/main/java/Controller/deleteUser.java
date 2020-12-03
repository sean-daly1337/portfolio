package Controller;

import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dell
 */
@WebServlet(name = "deleteUser", urlPatterns = {"/deleteUser"})
public class deleteUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        User userObj = new User();
        userObj.setUsername(username);

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        try {
            int result = userObj.deleteUser();
            response.getWriter().write(Integer.toString(result));
        } catch (Exception e) {
            System.out.println("Exception in delete user controller: " + e);
            response.getWriter().write("-1");
        }
    }
}

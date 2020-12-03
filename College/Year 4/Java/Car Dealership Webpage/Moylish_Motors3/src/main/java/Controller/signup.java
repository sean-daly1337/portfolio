package Controller;

import Model.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dell
 */
@WebServlet(name = "signup", urlPatterns = {"/signup"})
public class signup extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User userObj = new User(request.getParameter("username"),request.getParameter("name"),request.getParameter("email"),request.getParameter("password"),3);
        response.setContentType("text/html"); 
        response.setCharacterEncoding("UTF-8");
        try{
            int result = userObj.insertUser();
            response.getWriter().write(Integer.toString(result)); 
        }
        catch(Exception e){
            System.out.println("Exception in Signup controller"+e);
            response.getWriter().write("-1"); 
        }
    }
    
    @Override
    public String getServletInfo() {
        return "New User is added via this servlet";
    }

}

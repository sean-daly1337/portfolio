package Controller;

import Model.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "login", urlPatterns = {"/Login"})
public class login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User userObj = new User(request.getParameter("username"),request.getParameter("password"));
        response.setContentType("text/html"); 
        response.setCharacterEncoding("UTF-8");
        try{
            User user = userObj.loginUser();
            if(user==null){
                response.getWriter().write("0"); 
            }
            else{
                HttpSession session = request.getSession();
                session.setAttribute("loggedInUser",user);
                response.getWriter().write(Integer.toString(user.getRoleId()));              
            }
        }
        catch(Exception e){
            System.out.println("Exception in login Controller:"+e);
            response.getWriter().write("-1"); 
        }
    }
}

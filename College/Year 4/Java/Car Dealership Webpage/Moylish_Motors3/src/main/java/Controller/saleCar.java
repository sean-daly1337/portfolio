package Controller;

import Model.Cars;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "saleCar", urlPatterns = {"/saleCar"})
public class saleCar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        int listing = Integer.parseInt(request.getParameter("listing"));
        String username = request.getParameter("username");
        int listPrice = Integer.parseInt(request.getParameter("listPrice"));
                
        Cars obj = new Cars();
        int inserted = obj.saleCar(listing, listPrice, username);
        if (inserted == 1) {
            response.getWriter().write("1");
        } else {
            response.getWriter().write("-1");
        }

    }

}

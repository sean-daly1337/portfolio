package Controller;

import Model.User;
import Model.favourites;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "addToFavourites", urlPatterns = {"/addToFavourites"})
public class addToFavourites extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        User obj = (User) session.getAttribute("loggedInUser");
        favourites favObj = new favourites();

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        if (obj == null) {
            response.getWriter().write("0");
        } else {
            int listing = Integer.parseInt(request.getParameter("listing"));
            int removeOrAdd = Integer.parseInt(request.getParameter("removeOrAdd"));

            System.out.println(listing);
            System.out.println(removeOrAdd);
            
            String username = obj.getUsername();

            int i = 0;
            if (removeOrAdd == 1) {
                i = favObj.addToFavourite(listing, username);
                if (i == 1) {
                    response.getWriter().write("1");
                } else {
                    response.getWriter().write("-1");
                }
            } else {
                i = favObj.removeFavourite(listing, username);
                if (i == 1) {
                    response.getWriter().write("2");
                } else {
                    response.getWriter().write("-1");
                }
            }
        }

    }

}

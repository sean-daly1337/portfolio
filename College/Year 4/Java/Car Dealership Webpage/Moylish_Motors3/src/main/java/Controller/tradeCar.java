package Controller;

import Model.trades;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "tradeCar", urlPatterns = {"/tradeCar"})
public class tradeCar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        int ourCarListing = Integer.parseInt(request.getParameter("ourCarListing"));
        int userCarListing = Integer.parseInt(request.getParameter("userCarListing"));
        int tradingCost = Integer.parseInt(request.getParameter("tradingCost"));
                
        trades obj = new trades();
        int inserted = obj.tradeCar(ourCarListing, userCarListing, tradingCost);
        if (inserted == 1) {
            response.getWriter().write("1");
        } else {
            response.getWriter().write("-1");
        }

    }

}

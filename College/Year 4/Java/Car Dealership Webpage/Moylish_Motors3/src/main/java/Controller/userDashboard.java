package Controller;

import Model.Cars;
import Model.User;
import Model.favourites;
import Model.trades;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "userDashboard", urlPatterns = {"/userDashboard"})
public class userDashboard extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        User signedInUser = (User) session.getAttribute("loggedInUser");

        Cars carsObj = new Cars();
        trades tradedCarsObj = new trades();
        favourites favCarsObj = new favourites();

        try {

            List<Cars> soldCars = carsObj.getSoldCarsOfUser(signedInUser.getUsername());
            request.setAttribute("soldCars", soldCars);

            List<trades> tradedCars = tradedCarsObj.getAllTradedCarsOfUser(signedInUser.getUsername());
            request.setAttribute("tradedCars", tradedCars);

            List<Cars> favouriteCars = favCarsObj.getAllFavCars(signedInUser.getUsername());
            request.setAttribute("favouriteCars", favouriteCars);

        } catch (Exception e) {
            System.out.println("Excpetion in User Dashboard servlet:" + e);
        }
        request.getRequestDispatcher("/WEB-INF/user-dashboard.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}

package Controller;

import Model.Cars;
import Model.User;
import Model.trades;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "adminDashboard", urlPatterns = {"/adminDashboard"})
public class AdminDashboard extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User userObj = new User();
        Cars carsObj = new Cars();
        trades tradedCarObj = new trades();
        try {

            // fetching all users which will be sent to the admin dashboard page
            List<User> allUsers = userObj.getAllUsers();
            request.setAttribute("AllUsers", allUsers);

            // fetching all cars which will be sent to the admin dashboard page
            List<Cars> allCars = carsObj.getAllCars();
            request.setAttribute("AllCars", allCars);

            // fetching all cars again which will be sent to the admin dashboard page (for testing purpose)
            List<Cars> allCars2 = carsObj.getAllCars();
            request.setAttribute("AllCars2", allCars2);

            // fetching all sold cars which will be sent to the admin dashboard page
            List<Cars> soldCars = carsObj.getAllSoldCars();
            request.setAttribute("soldCars", soldCars);

            // fetching all traded cars which will be sent to the admin dashboard page
            List<trades> tradedCars = tradedCarObj.getAllTradedCars();
            request.setAttribute("tradedCars", tradedCars);

            // fetching all customers which will be sent to the admin dashboard page
            List<User> users = userObj.getUsersWithRoleID(3);
            request.setAttribute("users", users);
        } catch (Exception e) {
            System.out.println("Excpetion in Admin Dashboard servlet(getting all users):" + e);
        }
        // going to admin dashboard page
        request.getRequestDispatcher("/WEB-INF/admin-dashboard.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}

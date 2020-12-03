package Controller;

import Model.Cars;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "allCars", urlPatterns = {"/allCars"})
public class allCars extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cars carObj = new Cars();
        List<Cars> allCars = carObj.getAllCarsWithLimit(6);

        request.setAttribute("allCars", allCars);
        request.getRequestDispatcher("/WEB-INF/all-cars.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}

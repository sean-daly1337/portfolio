package Controller;

import Model.Cars;
import Model.User;
import Model.carImages;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "car-details", urlPatterns = {"/car-details.jsp"})
public class viewCarDetails extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int listing = Integer.parseInt(request.getParameter("listing"));
        User userObj = new User();
        Cars carsObj = new Cars();
        carImages carImagesObj = new carImages();
        try {
            Cars carDetails = carsObj.getCarByListing(listing);
            request.setAttribute("carDetails", carDetails);

            List<carImages> carImages = carImagesObj.getImages(carDetails.getListing());
            request.setAttribute("carImages", carImages);

            User salesMan = userObj.getUserbyUsername(carDetails.getSalesmanUsername());
            request.setAttribute("salesMan", salesMan);
        } catch (Exception e) {
            System.out.println("Excpetion in Car Details Controller:" + e);
        }
        request.getRequestDispatcher("/WEB-INF/car-details.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}

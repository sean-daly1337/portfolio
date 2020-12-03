package Controller;

import Model.Cars;
import java.io.File;
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
@WebServlet(name = "deleteCar", urlPatterns = {"/deleteCar"})
public class deleteCar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int listing = Integer.parseInt(request.getParameter("listing"));
        Cars carObj = new Cars();

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        try {
            int result = carObj.deleteCar(listing);
            if (result == 1) {
                File fileDir = new File("Moylish_Motors3\\target\\Moylish_Motors3-1.0-SNAPSHOT\\UPLOADS/" + listing);
                fileDir.deleteOnExit();
            }
            response.getWriter().write(Integer.toString(result));
        } catch (Exception e) {
            System.out.println("Exception in delete car controller: " + e);
            response.getWriter().write("-1");
        }
    }
}

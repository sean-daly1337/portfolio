package Controller;

import Model.User;
import Model.carImages;
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
@WebServlet(name = "deleteImage", urlPatterns = {"/deleteImage"})
public class deleteImage extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int  imageID = Integer.parseInt(request.getParameter("imageToDelete"));
        carImages carImageObj = new carImages();

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        try {
            int result = carImageObj.deleteImagePath(imageID);
            response.getWriter().write(Integer.toString(result));
        } catch (Exception e) {
            System.out.println("Exception in deleteImage controller: " + e);
            response.getWriter().write("-1");
        }
    }
}

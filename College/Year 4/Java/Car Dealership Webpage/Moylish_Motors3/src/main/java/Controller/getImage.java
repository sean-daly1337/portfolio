package Controller;

import Model.carImages;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
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
@WebServlet(name = "getImage", urlPatterns = {"/getImage"})
public class getImage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        carImages obj = new carImages();
        try {
            int ID = Integer.parseInt(request.getParameter("imagePathID"));
            String image = obj.getImagePath(ID);
            if (image != null) {
                FileInputStream fis = new FileInputStream(new File(image));
                BufferedInputStream bis = new BufferedInputStream(fis);
                response.setContentType("image/png/jpg/jpeg");
                BufferedOutputStream output = new BufferedOutputStream(response.getOutputStream());
                for (int data; (data = bis.read()) > -1;) {
                    output.write(data);
                }
            }
        } catch (IOException e) {

        }
    }

}

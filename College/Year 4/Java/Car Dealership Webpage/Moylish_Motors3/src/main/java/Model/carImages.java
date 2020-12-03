package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class carImages {

    int id;
    int listing;
    String imagePath;
    String imageType;

    connection con = new connection();

    public carImages(int id, int listing, String imagePath, String imageType) {
        this.id = id;
        this.listing = listing;
        this.imagePath = imagePath;
        this.imageType = imageType;
    }

    public carImages() {
    }

    public int getID() {
        return this.id;
    }

    public int getListing() {
        return this.listing;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public String getImageType() {
        return this.imageType;
    }

// this function is used to get all the main iamges
    public List<carImages> getImages(int listing) {
        String query = "select * from vehicle_images where listing=? and image_type='I';";
        // Step 1: Establishing a Connection
        try ( Connection connection = con.getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setInt(1, listing);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            List<carImages> images = new ArrayList<>();
            while (rs.next()) {
                images.add(new carImages(rs.getInt("id"), rs.getInt("listing"), rs.getString("image_path"), rs.getString("image_type")));
            }
            return images;
        } catch (SQLException e) {
            System.out.println("Exception in getImages [carImages.java]:" + e);
            return null;
        }
    }
    
    //  this function is used to get all the iamges
    // is it being used for update car page
    public List<carImages> getAllImages(int listing) {
        String query = "select * from vehicle_images where listing=?;";
        // Step 1: Establishing a Connection
        try ( Connection connection = con.getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setInt(1, listing);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            List<carImages> images = new ArrayList<>();
            while (rs.next()) {
                images.add(new carImages(rs.getInt("id"), rs.getInt("listing"), rs.getString("image_path"), rs.getString("image_type")));
            }
            return images;
        } catch (SQLException e) {
            System.out.println("Exception in getImages [carImages.java]:" + e);
            return null;
        }
    }
    
    
    
    // this function is used to get image path
    // function used to fetch thumbnial image from server
    public String getImagePath(int id) {
        String query = "select * from vehicle_images where id=?;";
        // Step 1: Establishing a Connection
        try ( Connection connection = con.getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setInt(1, id);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            if (rs.next()) {
                return rs.getString("image_path");
            }
            return null;
        } catch (SQLException e) {
            System.out.println("Exception in getImages [carImages.java]:" + e);
            return null;
        }
    }
    
    // delete from car images
     public int deleteImagePath(int id) {
        String query = "delete from vehicle_images where id = ? ;";
        try ( Connection connection = con.getConnection();  PreparedStatement statement = connection.prepareStatement(query);) {
            statement.setInt(1, id);
            return statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Exception in deleteImagePath: " + e);
            return -1;
        }
    }
}

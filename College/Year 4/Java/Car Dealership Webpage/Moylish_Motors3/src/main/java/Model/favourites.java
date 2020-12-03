package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class favourites {

    int listing;
    String username;

    connection con = new connection();

    public favourites() {

    }

    public favourites(int listing, String username) {
        this.listing = listing;
        this.username = username;
    }

    // insert into favourites table with username and listing
    public int addToFavourite(int listing, String username) {
        String insertUserQuery = "INSERT INTO favourites (username,listing) VALUES "
                + " (?, ?);";
        // try-with-resource statement will auto close the connection.
        try ( Connection connection = con.getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(insertUserQuery)) {
            preparedStatement.setString(1, username);
            preparedStatement.setInt(2, listing);

            int userInserted = preparedStatement.executeUpdate();
            return userInserted;
        } catch (SQLException e) {
            //printSQLException(e);
            System.out.println("Exception in addToFavourite:" + e);
            return -1;
        }
    }

    // getting all favourite cars if a user which will be shown in user dashboard
    public List<Cars> getAllFavCars(String username) {
        String query = " select v.*, vi.id as thumbnailID "
                + " from vehicles v, favourites f, vehicle_images vi "
                + " where f.listing = v.listing "
                + " and f.username =? "
                + " and v.listing = vi.listing and vi.image_type ='T' ";
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Cars> allCars = new ArrayList<>();
        // Step 1: Establishing a Connection
        try ( Connection connection = con.getConnection(); // Step 2:Create a statement using connection object
                  PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            // Step 3: Execute the query or update query
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int listing = rs.getInt("listing");
                String reg = rs.getString("reg");
                int year = rs.getInt("year");
                String make = rs.getString("make");
                String model = rs.getString("model");
                String color = rs.getString("colour");
                int buyPrice = rs.getInt("buy_price");
                int listPrice = rs.getInt("list_price");
                int thumbnailID = rs.getInt("thumbnailID");

                allCars.add(new Cars(listing, reg, year, make, model, color, buyPrice, listPrice, thumbnailID, 0, ""));
            }
            return allCars;
        } catch (SQLException e) {
            System.out.println("Exception in GetAllCars: " + e);
            return null;
        }
    }

    // when user dislikes a car, it is removed from favourites table
    public int removeFavourite(int listing, String username) {
        String query = "delete from favourites where username = ? and listing=?;";
        try ( Connection connection = con.getConnection();  PreparedStatement statement = connection.prepareStatement(query);) {
            statement.setString(1, username);
            statement.setInt(2, listing);
            return statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Exception in removeFavourite: " + e);
            return -1;
        }
    }

}

package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class trades {

    String oldThumbnail;
    int oldListing;
    String oldRegistration;
    String oldMake;

    String newThumbnail;
    int newListing;
    String newRegistration;
    String newMake;

    int tradeCost;
    String tradePerson;

    connection con = new connection();

    public trades(String oldThumbnail, int oldListing, String oldRegistration, String oldMake, String newThumbnail, int newListing, String newRegistration, String newMake, int tradeCost, String tradePerson) {
        this.oldThumbnail = oldThumbnail;
        this.oldListing = oldListing;
        this.oldRegistration = oldRegistration;
        this.oldMake = oldMake;
        this.newThumbnail = newThumbnail;
        this.newListing = newListing;
        this.newRegistration = newRegistration;
        this.newMake = newMake;
        this.tradeCost = tradeCost;
        this.tradePerson = tradePerson;
    }

    public trades() {

    }

    public int getOldListing() {
        return this.oldListing;
    }

    public int getNewListing() {
        return this.newListing;
    }

    public String getOldMake() {
        return this.oldMake;
    }

    public String getNewMake() {
        return this.newMake;
    }

    public String getOldThumbnail() {
        return this.oldThumbnail;
    }

    public String getNewThumbnail() {
        return this.newThumbnail;
    }

    public String getTradeUsername() {
        return this.tradePerson;
    }

    public int getTradedCost() {
        return this.tradeCost;
    }

    // this function makes an entry into trades table
    public int tradeCar(int ourCarListing, int userCarListing, int tradingCost) {
        String insertCarQuery = "INSERT INTO trades(user_car_listing,traded_car_listing,adjusted_price) VALUES(?,?,?)";
        // try-with-resource statement will auto close the connection.
        try ( Connection connection = con.getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(insertCarQuery)) {
            preparedStatement.setInt(1, userCarListing);
            preparedStatement.setInt(2, ourCarListing);
            preparedStatement.setInt(3, tradingCost);
            int isInserted = preparedStatement.executeUpdate();
            return isInserted;
        } catch (SQLException e) {
            //printSQLException(e);
            System.out.println("Exception in sale car" + e);
            return -1;
        }
    }

    // all traded cars are fetched from database with thumbnail image paths which will be shown in database
    public List<trades> getAllTradedCars() {
        String query = " select vi.id oldThumbnail, v.listing oldListing,v.reg oldRegistration,v.make oldMake, vi1.id newThumbnail, v1.listing newListing,v1.reg newRegistration,v1.make newMake, t.adjusted_price tradeCost, v1.previous_owner_username tradePerson "
                + " from vehicles v,vehicle_images vi, vehicles v1, vehicle_images vi1, trades t "
                + " WHERE t.user_car_listing = v1.listing "
                + " and t.traded_car_listing = v.listing "
                + " and v.listing = vi.listing and vi.image_type ='T' "
                + " and v1.listing = vi1.listing and vi1.image_type ='T' ";
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<trades> allCars = new ArrayList<>();
        // Step 1: Establishing a Connection
        try ( Connection connection = con.getConnection(); // Step 2:Create a statement using connection object
                  PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String oldThumbnail = rs.getString("oldThumbnail");
                int oldListing = rs.getInt("oldListing");
                String oldRegistration = rs.getString("oldRegistration");
                String oldMake = rs.getString("oldMake");
                String newThumbnail = rs.getString("newThumbnail");
                int newListing = rs.getInt("newListing");
                String newRegistration = rs.getString("newRegistration");
                String newMake = rs.getString("newMake");
                int tradeCost = rs.getInt("tradeCost");
                String tradePerson = rs.getString("tradePerson");

                allCars.add(new trades(oldThumbnail, oldListing, oldRegistration, oldMake, newThumbnail, newListing, newRegistration, newMake, tradeCost, tradePerson));
            }
            return allCars;
        } catch (SQLException e) {
            System.out.println("Exception in GetAllCars: " + e);
            return null;
        }
    }

    // all traded cars are fetched from database for a particular with thumbnail image paths which will be shown in user dashboard
    public List<trades> getAllTradedCarsOfUser(String username) {
        String query = " select vi.id oldThumbnail, v.listing oldListing,v.reg oldRegistration,v.make oldMake, vi1.id newThumbnail, v1.listing newListing,v1.reg newRegistration,v1.make newMake, t.adjusted_price tradeCost, v1.previous_owner_username tradePerson "
                + " from vehicles v,vehicle_images vi, vehicles v1, vehicle_images vi1, trades t "
                + " WHERE t.user_car_listing = v1.listing "
                + " and t.traded_car_listing = v.listing "
                + " and v.listing = vi.listing and vi.image_type ='T' "
                + " and v1.listing = vi1.listing and vi1.image_type ='T' "
                + " and v1.previous_owner_username = ?";
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<trades> allCars = new ArrayList<>();
        // Step 1: Establishing a Connection
        try ( Connection connection = con.getConnection(); // Step 2:Create a statement using connection object
                  PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            // Step 3: Execute the query or update query
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String oldThumbnail = rs.getString("oldThumbnail");
                int oldListing = rs.getInt("oldListing");
                String oldRegistration = rs.getString("oldRegistration");
                String oldMake = rs.getString("oldMake");
                String newThumbnail = rs.getString("newThumbnail");
                int newListing = rs.getInt("newListing");
                String newRegistration = rs.getString("newRegistration");
                String newMake = rs.getString("newMake");
                int tradeCost = rs.getInt("tradeCost");
                String tradePerson = rs.getString("tradePerson");

                allCars.add(new trades(oldThumbnail, oldListing, oldRegistration, oldMake, newThumbnail, newListing, newRegistration, newMake, tradeCost, tradePerson));
            }
            return allCars;
        } catch (SQLException e) {
            System.out.println("Exception in getAllTradedCarsOfUser: " + e);
            return null;
        }
    }
}

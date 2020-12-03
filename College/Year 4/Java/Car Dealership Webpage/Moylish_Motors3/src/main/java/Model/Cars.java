package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// car class consisting of all the required functions
public class Cars {

    int listing;
    int year;
    String reg;
    String make;
    String model;
    String color;
    String discription;
    int buyPrice;
    int listPrice;
    int odometer;
    String kph;
    double engine;
    String fuel;
    String transmission;
    String body;
    String isofix;
    int motor_tax;
    int previous_owners;
    String sales_person_username;
    String previous_owner_username;
    String full_service_history;
    String note;
    int thumbnailImageID;
    // these 2 attributes are used when car is being sold
    int sold_price;
    String sold_to;

    connection con = new connection();

    // parameterized constructor
    public Cars(int listing, String reg, int year, String make, String model, String color, int buyPrice, int listPrice, int thumbnailID) {
        this.listing = listing;
        this.reg = reg;
        this.year = year;
        this.make = make;
        this.model = model;
        this.color = color;
        this.buyPrice = buyPrice;
        this.listPrice = listPrice;
        this.thumbnailImageID = thumbnailID;
    }
// parameterized constructor

    public Cars(int listing, String reg, int year, String make, String model, String color, int buyPrice, int listPrice, int thumbnailID, int soldPrice, String soldToUsername) {
        this.listing = listing;
        this.reg = reg;
        this.year = year;
        this.make = make;
        this.model = model;
        this.color = color;
        this.buyPrice = buyPrice;
        this.listPrice = listPrice;
        this.thumbnailImageID = thumbnailID;
        this.sold_price = soldPrice;
        this.sold_to = soldToUsername;
    }

    public Cars(int listing, int year, String reg, String make, String model, String color, String discription, int buyPrice, int listPrice, int odometer, String kph, Double engine, String fuel, String transmission, String body, String isofix, int motor_tax, int previous_owners, String sales_person_username, String previous_owner_username, String full_service_history, String note) {
        this.listing = listing;
        this.year = year;
        this.reg = reg;
        this.make = make;
        this.model = model;
        this.color = color;
        this.discription = discription;
        this.buyPrice = buyPrice;
        this.listPrice = listPrice;
        this.odometer = odometer;
        this.kph = kph;
        this.engine = engine;
        this.fuel = fuel;
        this.transmission = transmission;
        this.body = body;
        this.isofix = isofix;
        this.motor_tax = motor_tax;
        this.previous_owners = previous_owners;
        this.sales_person_username = sales_person_username;
        this.previous_owner_username = previous_owner_username;
        this.full_service_history = full_service_history;
        this.note = note;

    }

    public Cars() {
        // default constructor
    }

    // setter and getter functions
    public int getListing() {
        return this.listing;
    }

    public int getYear() {
        return this.year;
    }

    public String getReg() {
        return this.reg;
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public String getColor() {
        return this.color;
    }

    public String getDescription() {
        return this.discription;
    }

    public int getBuyPrice() {
        return this.buyPrice;
    }

    public int getListPrice() {
        return this.listPrice;
    }

    public String getBody() {
        return this.body;
    }

    public String getTransmission() {
        return this.transmission;
    }

    public String getFuel() {
        return this.fuel;
    }

    public Double getEngine() {
        return this.engine;
    }

    public String getKPH() {
        return this.kph;
    }

    public int getOdometer() {
        return this.odometer;
    }

    public int getMotorTax() {
        return this.motor_tax;
    }

    public int getPreviousOwners() {
        return this.previous_owners;
    }

    public String getIsofix() {
        return this.isofix;
    }

    public String getServiceHistory() {
        return this.full_service_history;
    }

    public String getNote() {
        return this.note;
    }

    public String getSalesmanUsername() {
        return this.sales_person_username;
    }

    public String getPreviousOwnerUsername() {
        return this.previous_owner_username;
    }

    public int getThumbnailID() {
        return this.thumbnailImageID;
    }

    public int getSoldPrice() {
        return this.sold_price;
    }

    public String getSoldToUsername() {
        return this.sold_to;
    }

    // this functions is used to get all the AVAILABLE Cars, (sold cars and traded cars are excluded via subquery), images are fetched via join
    public List<Cars> getAllCars() {
        String query = " select v.*, vi.* "
                + " from vehicles v "
                + " LEFT JOIN vehicle_images vi "
                + " ON  v.listing = vi.listing and vi.image_type !='I' "
                + " "
                + " WHERE v.listing NOT IN (SELECT traded_car_listing from trades) "
                + " and v.listing NOT IN (SELECT sold_car_listing from sold_cars)";
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Cars> allCars = new ArrayList<>();
        // Step 1: Establishing a Connection
        try ( Connection connection = con.getConnection(); // Step 2:Create a statement using connection object
                  PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            // Step 3: Execute the query or update query
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
                int thumbnailID = rs.getInt("id");
                allCars.add(new Cars(listing, reg, year, make, model, color, buyPrice, listPrice, thumbnailID));
            }
            return allCars;
        } catch (SQLException e) {
            System.out.println("Exception in GetAllCars: " + e);
            return null;
        }
    }

    // this function is used to get cars with a count limit. eg: if 6 is passed then only 6 cars will be fetched from database
    public List<Cars> getAllCarsWithLimit(int limit) {
        String query = " select v.*, vi.* "
                + " from vehicles v "
                + " LEFT JOIN vehicle_images vi "
                + " ON  v.listing = vi.listing and vi.image_type ='T' "
                + " "
                + " WHERE v.listing NOT IN (SELECT traded_car_listing from trades) "
                + " and v.listing NOT IN (SELECT sold_car_listing from sold_cars) LIMIT ?";
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Cars> allCars = new ArrayList<>();
        // Step 1: Establishing a Connection
        try ( Connection connection = con.getConnection(); // Step 2:Create a statement using connection object
                  PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            // Step 3: Execute the query or update query
            preparedStatement.setInt(1, limit);
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
                int thumbnailID = rs.getInt("id");
                Cars obj = new Cars(listing, reg, year, make, model, color, buyPrice, listPrice, thumbnailID);
                obj.odometer = rs.getInt("odometer");
                obj.engine = rs.getInt("engine");
                obj.fuel = rs.getString("fuel");
                obj.transmission = rs.getString("transmission");
                allCars.add(obj);
            }
            return allCars;
        } catch (SQLException e) {
            System.out.println("Exception in GetAllCars: " + e);
            return null;
        }
    }

    // this function is used to insert a new car into DB
    public int insertCar() throws SQLException {
        String insertCarQuery = "INSERT INTO vehicles (listing,year,reg,make,model,colour,discription,buy_price,list_price,odometer,kph,engine,fuel,transmission,body,isofix,motor_tax,previous_owners,sales_person_username,previous_owner_username,full_service_history,note) "
                + "  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        // try-with-resource statement will auto close the connection.
        try ( Connection connection = con.getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(insertCarQuery)) {
            preparedStatement.setInt(1, this.listing);
            preparedStatement.setInt(2, this.year);
            preparedStatement.setString(3, this.reg);
            preparedStatement.setString(4, this.make);
            preparedStatement.setString(5, this.model);
            preparedStatement.setString(6, this.color);
            preparedStatement.setString(7, this.discription);
            preparedStatement.setInt(8, this.buyPrice);
            preparedStatement.setInt(9, this.listPrice);
            preparedStatement.setInt(10, this.odometer);
            preparedStatement.setString(11, this.kph);
            preparedStatement.setDouble(12, this.engine);
            preparedStatement.setString(13, this.fuel);
            preparedStatement.setString(14, this.transmission);
            preparedStatement.setString(15, this.body);
            preparedStatement.setString(16, this.isofix);
            preparedStatement.setInt(17, this.motor_tax);
            preparedStatement.setInt(18, this.previous_owners);
            preparedStatement.setString(19, this.sales_person_username);
            preparedStatement.setString(20, this.previous_owner_username);
            preparedStatement.setString(21, this.full_service_history);
            preparedStatement.setString(22, this.note);
            int carInserted = preparedStatement.executeUpdate();
            return carInserted;
        } catch (SQLException e) {
            //printSQLException(e);
            System.out.println("Exception in signup model" + e);
            return -1;
        }
    }

    // this function is used to insert a new car into DB
    public int updateCar() throws SQLException {
        String insertCarQuery = "update vehicles set year=?,reg=?,make=?,model=?,colour=?,discription=?,buy_price=?,list_price=?,odometer=?,kph=?,engine=?,fuel=?,transmission=?,body=?,isofix=?,motor_tax=?,previous_owners=?,sales_person_username=?,previous_owner_username=?,full_service_history=?,note=? "
                + "  where listing=?";
        // try-with-resource statement will auto close the connection.
        try ( Connection connection = con.getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(insertCarQuery)) {
            preparedStatement.setInt(1, this.year);
            preparedStatement.setString(2, this.reg);
            preparedStatement.setString(3, this.make);
            preparedStatement.setString(4, this.model);
            preparedStatement.setString(5, this.color);
            preparedStatement.setString(6, this.discription);
            preparedStatement.setInt(7, this.buyPrice);
            preparedStatement.setInt(8, this.listPrice);
            preparedStatement.setInt(9, this.odometer);
            preparedStatement.setString(10, this.kph);
            preparedStatement.setDouble(11, this.engine);
            preparedStatement.setString(12, this.fuel);
            preparedStatement.setString(13, this.transmission);
            preparedStatement.setString(14, this.body);
            preparedStatement.setString(15, this.isofix);
            preparedStatement.setInt(16, this.motor_tax);
            preparedStatement.setInt(17, this.previous_owners);
            preparedStatement.setString(18, this.sales_person_username);
            preparedStatement.setString(19, this.previous_owner_username);
            preparedStatement.setString(20, this.full_service_history);
            preparedStatement.setString(21, this.note);
            preparedStatement.setInt(22, this.listing);
            int carInserted = preparedStatement.executeUpdate();
            return carInserted;
        } catch (SQLException e) {
            //printSQLException(e);
            System.out.println("Exception in signup model" + e);
            return -1;
        }
    }

    // this function is used to insert image path of a car image into database
    // imageType= I means that it is car's main image
    // imageType= T means that it is car's thumbnail image
    public int insertImage(int listing, String imagePath, String imageType) throws SQLException {
        if (imageType == "T" || imageType.equals("T")) {
            checkIfEntryAlreadyThereThenDeleteIt(listing, "T");
        }
        String insertCarQuery = "INSERT INTO vehicle_images(listing,image_path,image_type) VALUES(?,?,?)";
        // try-with-resource statement will auto close the connection.
        try ( Connection connection = con.getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(insertCarQuery)) {
            preparedStatement.setInt(1, listing);
            preparedStatement.setString(2, imagePath);
            preparedStatement.setString(3, imageType);
            int isInserted = preparedStatement.executeUpdate();
            return isInserted;
        } catch (SQLException e) {
            //printSQLException(e);
            System.out.println("Exception in insert image model" + e);
            return -1;
        }
    }

    public int checkIfEntryAlreadyThereThenDeleteIt(int listing, String imgType) {
        String query = "delete from vehicle_images where listing = ? and image_type=? ;";
        try ( Connection connection = con.getConnection();  PreparedStatement statement = connection.prepareStatement(query);) {
            statement.setInt(1, listing);
            statement.setString(2, imgType);
            return statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Exception in delete car images model: " + e);
            return -1;
        }
    }

    // car is fetched by it's listing number
    public Cars getCarByListing(int listing) {
        String query = "select * from vehicles where listing=?";
        // Step 1: Establishing a Connection
        try ( Connection connection = con.getConnection(); // Step 2:Create a statement using connection object
                  PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setInt(1, listing);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            Cars carObj = null;
            if (rs.next()) {
                carObj = new Cars(rs.getInt("listing"), rs.getInt("year"), rs.getString("reg"), rs.getString("make"), rs.getString("model"), rs.getString("colour"), rs.getString("discription"), rs.getInt("buy_price"), rs.getInt("list_price"), rs.getInt("odometer"), rs.getString("kph"), rs.getDouble("engine"), rs.getString("fuel"), rs.getString("transmission"), rs.getString("body"), rs.getString("isofix"), rs.getInt("motor_tax"), rs.getInt("previous_owners"), rs.getString("sales_person_username"), rs.getString("previous_owner_username"), rs.getString("full_service_history"), rs.getString("note"));
            }
            return carObj;
        } catch (SQLException e) {
            System.out.println("Exception in get car by listing [Cars.java]:" + e);
            return null;
        }
    }

    // function used to delete a car, listing is passed as a parameter
    public int deleteCar(int listing) {
        deleteCarImages(listing);
        String query = "delete from vehicles where listing = ? ;";
        try ( Connection connection = con.getConnection();  PreparedStatement statement = connection.prepareStatement(query);) {
            statement.setInt(1, listing);
            return statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Exception in delete car model: " + e);
            return -1;
        }
    }

    // when car is deleted, it's images are also deleted from database
    public int deleteCarImages(int listing) {
        String query = "delete from vehicle_images where listing = ? ;";
        try ( Connection connection = con.getConnection();  PreparedStatement statement = connection.prepareStatement(query);) {
            statement.setInt(1, listing);
            return statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Exception in delete car images model: " + e);
            return -1;
        }
    }

    // this function inserts an entry into sold_cars 
    public int saleCar(int listing, int price, String username) {
        String insertCarQuery = "INSERT INTO sold_cars(sold_car_listing,sold_car_price,sold_to) VALUES(?,?,?)";
        // try-with-resource statement will auto close the connection.
        try ( Connection connection = con.getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(insertCarQuery)) {
            preparedStatement.setInt(1, listing);
            preparedStatement.setInt(2, price);
            preparedStatement.setString(3, username);
            int isInserted = preparedStatement.executeUpdate();
            return isInserted;
        } catch (SQLException e) {
            //printSQLException(e);
            System.out.println("Exception in sale car" + e);
            return -1;
        }
    }

    // getting all the sold cars along with thumbnail image path so details can be shown in table in admin dashboard
    public List<Cars> getAllSoldCars() {
        String query = " select v.*, s.sold_car_price, s.sold_to, vi.id as thumbnailID "
                + " from vehicles v, sold_cars s, vehicle_images vi "
                + " where s.sold_car_listing = v.listing "
                + " and v.listing = vi.listing and vi.image_type ='T' ";
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Cars> allCars = new ArrayList<>();
        // Step 1: Establishing a Connection
        try ( Connection connection = con.getConnection(); // Step 2:Create a statement using connection object
                  PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            // Step 3: Execute the query or update query
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
                int soldPrice = rs.getInt("sold_car_price");
                String soldToUsername = rs.getString("sold_to");

                allCars.add(new Cars(listing, reg, year, make, model, color, buyPrice, listPrice, thumbnailID, soldPrice, soldToUsername));
            }
            return allCars;
        } catch (SQLException e) {
            System.out.println("Exception in GetAllCars: " + e);
            return null;
        }
    }

    // function used to get sold cars of a user so details can be shown in user dashboard
    public List<Cars> getSoldCarsOfUser(String username) {
        String query = "SELECT v.*, s.sold_car_price,s.sold_to, vi.id as thumbnailID "
                + " FROM vehicles v, sold_cars s, vehicle_images vi "
                + " WHERE v.listing = s.sold_car_listing "
                + " AND s.sold_to = ? "
                + " AND v.listing = vi.listing and vi.image_type ='T'; ";
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
                int soldPrice = rs.getInt("sold_car_price");
                String soldToUsername = rs.getString("sold_to");

                allCars.add(new Cars(listing, reg, year, make, model, color, buyPrice, listPrice, thumbnailID, soldPrice, soldToUsername));
            }
            return allCars;
        } catch (SQLException e) {
            System.out.println("Exception in GetAllSoldCarsForUser: " + e);
            return null;
        }
    }

}

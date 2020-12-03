package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// User class
public class User {

    // all the attributes
    protected int id;
    protected String username;
    protected String password;
    protected String name;
    protected String email;
    protected String fax;
    protected int phone;
    protected String address;
    protected int roleId;

    connection con = new connection();

    // default constructor as sometimes User object is needed to call some functions
    public User() {
    }

    // parameterized constructor
    public User(String username, String password, String name, String email, String fax, int phone, String address,
            int roleId) {
        super();
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.fax = fax;
        this.phone = phone;
        this.address = address;
        this.roleId = roleId;
    }

    public User(String name, String email, String address) {
        super();
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public User(String username, String name, String email, String password, int roleID) {
        super();
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.roleId = roleID;
    }

    public User(String username, String name, int roleid, int phone, String email, String address, String fax) {
        super();
        this.username = username;
        this.name = name;
        this.roleId = roleid;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.fax = fax;
    }

    public User(String username, String name, String email, int phone, String address, String fax) {
        super();
        this.username = username;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.fax = fax;
    }

    public User(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public int getPhone() {
        return this.phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    // this function inserts an entry in user table, 
    // password is encrypted using MYSQL function 'PASSWORD'
    public int insertUser() throws SQLException {
        ResultSet rs = null;
        String insertUserQuery = "INSERT INTO user (name,username,email,password,roleId) VALUES "
                + " (?, ?,?,PASSWORD(?),?);";
        // try-with-resource statement will auto close the connection.
        try ( Connection connection = con.getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(insertUserQuery)) {
            preparedStatement.setString(1, this.getName());
            preparedStatement.setString(2, this.getUsername());
            preparedStatement.setString(3, this.getEmail());
            preparedStatement.setString(4, this.getPassword());
            preparedStatement.setInt(5, this.roleId);
            int userInserted = preparedStatement.executeUpdate();
            return userInserted;
        } catch (SQLException e) {
            //printSQLException(e);
            System.out.println("Exception in signup model" + e);
            return -1;
        }
    }

    // function used to login, if credentials are correct then user object is returned so it can be stored in Session
    public User loginUser() {
        ResultSet rs = null;
        String query = "select * from user where username =? AND password=PASSWORD(?);";
        // Step 1: Establishing a Connection
        try {
            Connection conn = con.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, this.username);
            preparedStatement.setString(2, this.password);
            // Step 3: Execute the query or update query
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String username = rs.getString("username");
                String name = rs.getString("name");
                int roleID = rs.getInt("roleid");
                int phone = rs.getInt("phone");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String fax = rs.getString("fax");
                User obj = new User(username, name, roleID, phone, email, address, fax);
                return obj;
            } else {
                return null;
            }
        } catch (SQLException e) {
            //printSQLException(e);
            System.out.println("Exception in login" + e);
            return null;
        }
    }

    // function used to get a user by username
    public User getUserbyUsername(String username) {
        String query = "select * from user where username =?";
        // Step 1: Establishing a Connection
        try ( Connection connection = con.getConnection(); // Step 2:Create a statement using connection object
                  PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setString(1, username);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            if (rs.next()) {
                String username1 = rs.getString("username");
                String name = rs.getString("name");
                int roleID = rs.getInt("roleid");
                int phone = rs.getInt("phone");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String fax = rs.getString("fax");
                User obj = new User(username1, name, roleID, phone, email, address, fax);
                return obj;
            } else {
                return null;
            }
        } catch (SQLException e) {
            printSQLException(e);
            return null;
        }
    }

    // getting all users from database
    // roleid=1 means user is admin
    // roleid=2 means user is salesperson
    // roleid=3 means user is user/customer
    public List<User> getAllUsers() {
        String query = "select * from user order by roleid;";
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<User> users = new ArrayList<>();
        // Step 1: Establishing a Connection
        try ( Connection connection = con.getConnection(); // Step 2:Create a statement using connection object
                  PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String username = rs.getString("username");
                String name = rs.getString("name");
                int roleid = rs.getInt("roleid");
                int phone = rs.getInt("phone");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String fax = rs.getString("fax");
                users.add(new User(username, name, roleid, phone, email, address, fax));
            }
            return users;
        } catch (SQLException e) {
            System.out.println("Exception in GetAllUsers: " + e);
            return null;
        }
    }

    // function used to get users will roleid, 
    // if I only need customers then roleid 3 will be passed
    // if I only need salesman then roleid 2 will be passed
    public List<User> getUsersWithRoleID(int roleID) {
        String query = "select * from user where roleId =?";
        // Step 1: Establishing a Connection
        try ( Connection connection = con.getConnection(); // Step 2:Create a statement using connection object
                  PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setInt(1, roleID);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            List<User> users = new ArrayList<>();
            while (rs.next()) {
                String username = rs.getString("username");
                String name = rs.getString("name");
                int roleid = rs.getInt("roleid");
                int phone = rs.getInt("phone");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String fax = rs.getString("fax");
                users.add(new User(username, name, roleid, phone, email, address, fax));
            }
            return users;

        } catch (SQLException e) {
            System.out.println("Exception in getUsersWithRoleID [addCar.java]:"+e);
            return null;
        }
    }

    // function used to delete user
    public int deleteUser() throws SQLException {
        String query = "delete from user where username = ?;";
        try ( Connection connection = con.getConnection();  PreparedStatement statement = connection.prepareStatement(query);) {
            statement.setString(1, this.username);
            return statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Exception in delete user model: " + e);
            return -1;
        }
    }

     // function used to update user
    public int updateUser() throws SQLException {
        String query = "update user set name = ?,email= ?,phone=?, address =?,fax=? where username = ?;";
        try ( Connection connection = con.getConnection();  PreparedStatement statement = connection.prepareStatement(query);) {
            statement.setString(1, this.getName());
            statement.setString(2, this.getEmail());
            statement.setInt(3, this.getPhone());
            statement.setString(4, this.getAddress());
            statement.setString(5, this.getFax());
            statement.setString(6, this.getUsername());
            return statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Exception in update user model: " + e);
            return -1;
        }
    }

     // function used to change password of a user
    public int changePassowrd(String username, String oldPassword, String newPassowrd) {
        String query = "update user set password = PASSWORD(?) where username = ? AND password = PASSWORD(?);";
        try ( Connection connection = con.getConnection();  PreparedStatement statement = connection.prepareStatement(query);) {
            statement.setString(1, newPassowrd);
            statement.setString(2, username);
            statement.setString(3, oldPassword);
            return statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Exception in update user model: " + e);
            return -1;
        }
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}

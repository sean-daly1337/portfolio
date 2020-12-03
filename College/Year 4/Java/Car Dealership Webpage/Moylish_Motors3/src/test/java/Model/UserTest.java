package Model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class UserTest {

    private User user;

    @Before
    public void setUp() throws Exception {
        user = createDummyUser();
    }

    @Test
    public void getName() {
        assertEquals("First Name", user.getName());
    }

    @Test
    public void getEmail() {
        assertEquals("abc@mail.com", user.getEmail());
    }

    @Test
    public void getUsername() {
        assertEquals("user-name", user.getUsername());
    }

    @Test
    public void getPassword() {
        assertEquals("123", user.getPassword());
    }

    @Test
    public void getFax() {
        assertEquals("123456789", user.getFax());
    }

    @Test
    public void getPhone() {
        assertEquals(718765124, user.getPhone());
    }

    @Test
    public void getAddress() {
        assertEquals("address", user.getAddress());
    }

    @Test
    public void getRoleId() {
        assertEquals(1, user.getRoleId());
    }

    @Test
    public void testInsertUser() throws SQLException {
        assertEquals(1, user.insertUser());

        user.deleteUser(); // remove added user
    }

    @Test
    public void testLoginUser() throws SQLException {
        user.insertUser(); // insert before logging

        User loggedUser = user.loginUser();
        assertEquals(user.getUsername(), loggedUser.getUsername());
        assertEquals(user.getEmail(), loggedUser.getEmail());
        assertEquals(user.getName(), loggedUser.getName());

        user.deleteUser(); // remove added user
    }

    @Test
    public void getUserbyUsername() throws SQLException {
        user.insertUser(); // insert

        User result = user.getUserbyUsername(user.getUsername());
        assertEquals(user.getUsername(), result.getUsername());
        assertEquals(user.getEmail(), result.getEmail());
        assertEquals(user.getName(), result.getName());

        user.deleteUser(); // remove added user
    }

    @Test
    public void getAllUsers() throws SQLException {
        user.insertUser(); // insert

        User result = user.getUserbyUsername(user.getUsername());
        assertEquals(user.getUsername(), result.getUsername());
        assertEquals(user.getEmail(), result.getEmail());
        assertEquals(user.getName(), result.getName());

        user.deleteUser(); // remove added user
    }

    @Test
    public void getUsersWithRoleID() throws SQLException {
        user.insertUser(); // insert

        List<User> result = user.getUsersWithRoleID(user.getRoleId());
        assertNotNull(result);
        assertFalse(result.isEmpty());

        user.deleteUser(); // remove added user
    }

    @Test
    public void deleteUser() throws SQLException {
        user.insertUser();
        assertEquals(1,user.deleteUser() );
    }

    @Test
    public void deleteUserNotInDB() throws SQLException {
        assertEquals(0,user.deleteUser() );
    }

    @Test
    public void updateUser() throws SQLException {
        user.insertUser(); // insert

        user.setName("Other Name");
        int updated = user.updateUser();
        assertEquals(1, updated);

        user.deleteUser(); // remove added user
    }

    private User createDummyUser() {
        User user = new User();
        user.setUsername("user-name");
        user.setAddress("address");
        user.setEmail("abc@mail.com");
        user.setFax("123456789");
        user.setName("First Name");
        user.setPassword("123");
        user.setPhone(718765124);
        user.setRoleId(1);
        return user;
    }
}
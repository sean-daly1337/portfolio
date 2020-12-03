package Model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class favouritesTest {

    private favourites favourites;
    private User user;
    private Cars cars;

    @Before
    public void setUp() throws SQLException {
        user = new User();
        user.setUsername("username");
        user.insertUser();
        cars = new Cars(
                1, "reg", 2020, "make", "model", "red", 20000, 25000, 1
        );
        cars.insertCar();
        favourites = new favourites();
    }

    @After
    public void tearDown() throws SQLException {
        user.deleteUser();
        cars.deleteCar(1);
    }

    @Test
    public void addToFavourite() {
        assertEquals(1, favourites.addToFavourite(1, "username"));

        favourites.removeFavourite(1, "username"); // delete after add
    }

    @Test
    public void getAllFavCars() {
        List<Cars> result = favourites.getAllFavCars("username");
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void removeFavourite() {
        favourites.addToFavourite(1, "username"); // add before delete

        assertEquals(1, favourites.removeFavourite(1, "username"));

    }
}
package Model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class CarsTest {

    private Cars cars;

    @Before
    public void setUp() throws SQLException {
        cars = createDummyCars();
        cars.insertCar();
    }

    @After
    public void tearDown() {
        cars.deleteCar(cars.getListing());
    }

    @Test
    public void getAllCars() {
        List<Cars> allCars = cars.getAllCars();
        assertNotNull(allCars);
        assertFalse(allCars.isEmpty());
    }

    @Test
    public void getAllCarsWithLimit() {
        List<Cars> result = cars.getAllCarsWithLimit(1);
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    public void insertImage() throws SQLException {
        assertEquals(1, cars.insertImage(1, "../path/image", "png"));
    }

    @Test
    public void getAllSoldCars() {
        List<Cars> result = cars.getAllSoldCars();
        assertNotNull(result);
    }

    @Test
    public void getSoldCarsOfUser() {
        List<Cars> result = cars.getSoldCarsOfUser("user-name");
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    private Cars createDummyCars() {
        return new Cars(
                1, "reg", 2020, "make", "model", "red", 20000, 25000, 1
        );
    }
}
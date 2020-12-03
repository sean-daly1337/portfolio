package Model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class tradesTest {

    @Test
    public void tradeCar() throws SQLException {
        Cars cars = createDummyCars();
        cars.insertCar();

        trades trades = new trades();
        assertEquals(1, trades.tradeCar(1, 1, 20000));

        cars.deleteCar(1);
    }

    @Test
    public void getAllTradedCars() throws SQLException {
        Cars cars = createDummyCars();
        cars.insertCar();
        cars.insertImage(1, "/abc/", "I");

        trades trades = new trades();
        assertFalse(trades.getAllTradedCars().isEmpty());

        cars.deleteCarImages(1);
        cars.deleteCar(1);
    }

    @Test
    public void getAllTradedCarsOfUser() throws SQLException {
        Cars cars = createDummyCars();
        cars.insertCar();

        trades trades = new trades();
        assertTrue(trades.getAllTradedCarsOfUser("username").isEmpty());

        cars.deleteCarImages(1);
        cars.deleteCar(1);
    }

    private Cars createDummyCars() {
        return new Cars(
                1, "reg", 2020, "make", "model", "red", 20000, 25000, 1
        );
    }
}
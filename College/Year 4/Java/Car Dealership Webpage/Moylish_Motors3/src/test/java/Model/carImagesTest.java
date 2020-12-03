package Model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class carImagesTest {

    @Test
    public void getImages() throws SQLException {
        Cars cars = new Cars(
                1, "reg", 2020, "make", "model", "red", 20000, 25000, 1
        );
        cars.insertCar();
        cars.insertImage(1, "/abc/", "I");

        carImages carImages = new carImages();
        List<Model.carImages> images = carImages.getImages(1);

        assertNotNull(images);
        assertFalse(images.isEmpty());

        cars.deleteCarImages(1);
        cars.deleteCar(1);
    }

    @Test
    public void getAllImages() throws SQLException {
        Cars cars = new Cars(
                1, "reg", 2020, "make", "model", "red", 20000, 25000, 1
        );
        cars.insertCar();
        cars.insertImage(1, "/abc/", "I");

        carImages carImages = new carImages();
        List<Model.carImages> images = carImages.getAllImages(1);

        assertNotNull(images);
        assertFalse(images.isEmpty());

        cars.deleteCarImages(1);
        cars.deleteCar(1);
    }
}
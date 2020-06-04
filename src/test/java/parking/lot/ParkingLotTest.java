package parking.lot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ParkingLotTest {

    private ParkingLot parkingLot;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        parkingLot = new ParkingLot(1);
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void should_park_car_in_parking_lot() {
        Car car = new Car(1);
        Assertions.assertEquals(this.parkingLot.getName(), this.parkingLot.park(car).orElse(null));
    }

    @Test
    void should_pick_up_car_from_parking_lot() {
        Car car = new Car(1);
        this.parkingLot.park(car);

        Assertions.assertEquals(car, this.parkingLot.pickup(car.getCarNumber()).orElse(null));
    }

    @Test
    void should_print_parking_lot_info() {
        parkingLot.print();
        String expected = "Parking lot No: 0, All space: 1, Left space: 1, Available rate: 100\n";
        Assertions.assertEquals(expected, outContent.toString());
    }
}

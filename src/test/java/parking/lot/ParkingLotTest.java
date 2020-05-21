package parking.lot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParkingLotTest {

    private ParkingLot parkingLot;

    @BeforeEach
    void setUp() {
        parkingLot = new ParkingLot(1);
    }

    @Test
    void should_park_car_in_parking_lot() {
        Car car = new Car(1);
        Assertions.assertEquals(this.parkingLot.getName(), this.parkingLot.park(car));
    }

    @Test
    void should_pick_up_car_from_parking_lot() {
        Car car = new Car(1);
        this.parkingLot.park(car);

        Assertions.assertEquals(car, this.parkingLot.pickup(car.getCarNumber()));
    }
}

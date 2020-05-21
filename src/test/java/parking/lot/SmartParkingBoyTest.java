package parking.lot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SmartParkingBoyTest {

    @Test
    void parking_boy_should_park_car_to_paring_lot_when_boy_has_one_available_parking_lot() {
        ParkingLot parkingLot = new ParkingLot(1, 1);
        SmartParkingBoy parkingBoy = new SmartParkingBoy();
        parkingBoy.addParkingLot(parkingLot);
        Car car = new Car(1);

        Assertions.assertEquals(1, parkingBoy.park(car));
    }

    @Test
    void parking_boy_should_park_car_to_most_space_paring_lot() {
        ParkingLot parkingLot1 = new ParkingLot(1, 1);
        ParkingLot parkingLot2 = new ParkingLot(2, 2);
        SmartParkingBoy parkingBoy = new SmartParkingBoy();
        parkingBoy.addParkingLot(parkingLot1);
        parkingBoy.addParkingLot(parkingLot2);
        Car car = new Car(1);

        Assertions.assertEquals(parkingLot2.getName(), parkingBoy.park(car));
    }
}

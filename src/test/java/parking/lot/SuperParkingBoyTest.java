package parking.lot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SuperParkingBoyTest {

    @Test
    void parking_boy_should_park_car_to_paring_lot_when_boy_has_one_available_parking_lot() {
        ParkingLot parkingLot = new ParkingLot(1, 1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);

        ParkingBoy parkingBoy = new ParkingBoy(parkingLots, new SuperParkableImpl(), new PickupableImpl());
        Car car = new Car(1);

        Assertions.assertEquals(1, parkingBoy.park(car).orElse(null));
    }

    @Test
    void parking_boy_should_park_car_to_most_space_rate_parking_lot() {
        ParkingLot parkingLot1 = new ParkingLot(3, 1);
        ParkingLot parkingLot2 = new ParkingLot(2, 2);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);

        ParkingBoy parkingBoy = new ParkingBoy(parkingLots, new SuperParkableImpl(), new PickupableImpl());

        Car car = new Car(1);
        parkingLot1.park(car);

        Assertions.assertEquals(parkingLot2.getName(), parkingBoy.park(car).orElse(null));
    }

    @Test
    void parking_boy_should_pickup_car() {
        ParkingLot parkingLot = new ParkingLot(1, 1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);

        ParkingBoy parkingBoy = new ParkingBoy(parkingLots, new NormalParkableImpl(), new PickupableImpl());

        Car car = new Car(1);
        parkingBoy.park(car);

        Assertions.assertEquals(car, parkingBoy.pickup(car.getCarNumber()).orElse(null));
    }
}

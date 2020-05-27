package parking.lot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ParkingManagerTest {
    @Test
    void should_park_car_to_manager_parking_lot_when_parking_boy_has_no_available_parking_lot() {
        ParkingLot parkingLotForParkingBoy = new ParkingLot(1, 1);
        List<ParkingLot> parkingLotsForParkingBoy = new ArrayList<>();
        parkingLotsForParkingBoy.add(parkingLotForParkingBoy);

        Car car = new Car(1);
        parkingLotForParkingBoy.park(car);

        ParkingLot parkingLotForParkingManager = new ParkingLot(1, 1);
        List<ParkingLot> parkingLotsForParkingManager = new ArrayList<>();
        parkingLotsForParkingManager.add(parkingLotForParkingManager);

        List<ParkingBoy> parkingBoys = new ArrayList<>();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotsForParkingBoy, new NormalParkableImpl(), new PickupableImpl());
        parkingBoys.add(parkingBoy);

        ParkingManager parkingManager = new ParkingManager(parkingLotsForParkingManager, parkingBoys);

        Car car2 = new Car(2);
        Assertions.assertEquals(1, parkingManager.park(car2));
    }

    @Test
    void should_park_car_to_boy_parking_lot_when_parking_boy_has_available_parking_lot() {
        ParkingLot parkingLotForParkingBoy = new ParkingLot(1, 1);
        List<ParkingLot> parkingLotsForParkingBoy = new ArrayList<>();
        parkingLotsForParkingBoy.add(parkingLotForParkingBoy);

        ParkingLot parkingLotForParkingManager = new ParkingLot(1, 1);
        List<ParkingLot> parkingLotsForParkingManager = new ArrayList<>();
        parkingLotsForParkingManager.add(parkingLotForParkingManager);

        List<ParkingBoy> parkingBoys = new ArrayList<>();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotsForParkingBoy, new NormalParkableImpl(), new PickupableImpl());
        parkingBoys.add(parkingBoy);

        ParkingManager parkingManager = new ParkingManager(parkingLotsForParkingManager, parkingBoys);

        Car car = new Car(1);
        Assertions.assertEquals(1, parkingManager.park(car));
    }

    @Test
    void parking_manager_should_pickup_car() {
        ParkingLot parkingLotForParkingBoy = new ParkingLot(1, 1);
        List<ParkingLot> parkingLotsForParkingBoy = new ArrayList<>();
        parkingLotsForParkingBoy.add(parkingLotForParkingBoy);

        ParkingLot parkingLotForParkingManager = new ParkingLot(1, 1);
        List<ParkingLot> parkingLotsForParkingManager = new ArrayList<>();
        parkingLotsForParkingManager.add(parkingLotForParkingManager);

        List<ParkingBoy> parkingBoys = new ArrayList<>();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotsForParkingBoy, new NormalParkableImpl(), new PickupableImpl());
        parkingBoys.add(parkingBoy);

        ParkingManager parkingManager = new ParkingManager(parkingLotsForParkingManager, parkingBoys);
        Car car = new Car(1);
        parkingManager.park(car);

        Assertions.assertEquals(car, parkingManager.pickup(car.getCarNumber()));
    }
}

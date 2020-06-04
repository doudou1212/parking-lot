package parking.lot;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ParkingManagerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

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
        Assertions.assertEquals(1, parkingManager.park(car2).orElse(null));
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
        Assertions.assertEquals(1, parkingManager.park(car).orElse(null));
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

        Assertions.assertEquals(car, parkingManager.pickup(car.getCarNumber()).orElse(null));
    }

    @Test
    void should_print_parking_lot_info() {
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

        parkingManager.print();
        String expected = "===============Parking Boys Info=================\nParking boy No: 0, Parking Lot info: \nParking lot No: 1, All space: 1, Left space: 1, Available rate: 100\n===============Manager Parking Lot Info=================\nParking lot No: 1, All space: 1, Left space: 1, Available rate: 100\n";
        Assertions.assertEquals(expected, outContent.toString());
    }
}

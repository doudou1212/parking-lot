package parking.lot;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class SmartParkingBoy {

    private List<ParkingLot> parkingLots;

    public SmartParkingBoy() {
        this.parkingLots = new ArrayList<>();
    }

    public void addParkingLot(ParkingLot parkingLot) {
        this.parkingLots.add(parkingLot);
    }

    public Integer park(Car car) {
        ParkingLot parkingLot = this.parkingLots.stream()
                .filter(lot -> lot.isAvailable())
                .sorted((o1, o2) -> o2.leftSpace() - o1.leftSpace())
                .findFirst().orElse(null);

        if(parkingLot != null) {
            return parkingLot.park(car);
        }

        return null;
    }

    public Car pickup(int carNumber) {
        ParkingLot parkingLot = this.parkingLots.stream()
                .filter(lot -> lot.pickup(carNumber) != null)
                .findFirst().orElse(null);

        if(parkingLot != null) {
            return parkingLot.pickup(carNumber);
        }

        return null;
    }
}

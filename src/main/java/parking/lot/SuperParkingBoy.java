package parking.lot;

import java.util.ArrayList;
import java.util.List;

public class SuperParkingBoy {

    private List<ParkingLot> parkingLots;

    public SuperParkingBoy() {
        this.parkingLots = new ArrayList<>();
    }

    public void addParkingLot(ParkingLot parkingLot) {
        this.parkingLots.add(parkingLot);
    }

    public Integer park(Car car) {
        ParkingLot parkingLot = this.parkingLots.stream()
                .filter(lot -> lot.isAvailable())
                .sorted((o1, o2) -> o2.getParkingSpareRate() - o1.getParkingSpareRate())
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

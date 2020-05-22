package parking.lot;

import java.util.List;

public class SuperParkableImpl implements Parkable {
    @Override
    public Integer park(Car car, List<ParkingLot> parkingLots) {
        ParkingLot parkingLot = parkingLots.stream()
                .filter(lot -> lot.isAvailable())
                .sorted((o1, o2) -> o2.getParkingSpareRate() - o1.getParkingSpareRate())
                .findFirst().orElse(null);

        if(parkingLot != null) {
            return parkingLot.park(car);
        }

        return null;
    }
}

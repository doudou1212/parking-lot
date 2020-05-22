package parking.lot;

import java.util.List;

public class SmartParkableImpl implements Parkable {
    @Override
    public Integer park(Car car, List<ParkingLot> parkingLots) {
        ParkingLot parkingLot = parkingLots.stream()
                .filter(lot -> lot.isAvailable())
                .sorted((o1, o2) -> o2.leftSpace() - o1.leftSpace())
                .findFirst().orElse(null);

        if(parkingLot != null) {
            return parkingLot.park(car);
        }

        return null;
    }
}

package parking.lot;

import java.util.List;
import java.util.Optional;

public class SmartParkableImpl implements Parkable {
    @Override
    public Optional<Integer> park(Car car, List<ParkingLot> parkingLots) {
        return parkingLots.stream()
                .filter(ParkingLot::isAvailable)
                .sorted((o1, o2) -> o2.leftSpace() - o1.leftSpace())
                .findFirst()
                .flatMap(parkingLot -> parkingLot.park(car));
    }
}

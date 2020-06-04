package parking.lot;

import java.util.List;
import java.util.Optional;

@FunctionalInterface
public interface Parkable {
    public Optional<Integer> park(Car car, List<ParkingLot> parkingLots);
}

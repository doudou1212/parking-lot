package parking.lot;

import java.util.List;
import java.util.Optional;

public class NormalParkableImpl implements Parkable{
    @Override
    public Optional<Integer> park(Car car, List<ParkingLot> parkingLots) {
        return parkingLots.stream()
                .filter(ParkingLot::isAvailable)
                .findFirst()
                .flatMap(parkingLot -> parkingLot.park(car));
    }
}

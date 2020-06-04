package parking.lot;

import java.util.List;
import java.util.Optional;

public class PickupableImpl implements Pickupable {
    @Override
    public Optional<Car> pickup(Integer carNumber, List<ParkingLot> parkingLots) {
        return parkingLots.stream()
                .filter(parkingLot -> parkingLot.isCarInLot(carNumber))
                .findFirst()
                .flatMap(parkingLot -> parkingLot.pickup(carNumber));
    }
}

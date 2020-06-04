package parking.lot;

import java.util.List;
import java.util.Optional;

public interface Pickupable {
    public Optional<Car> pickup(Integer carNumber, List<ParkingLot> parkingLots);
}

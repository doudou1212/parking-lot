package parking.lot;

import java.util.List;

@FunctionalInterface
public interface Parkable {
    public Integer park(Car car, List<ParkingLot> parkingLots);
}

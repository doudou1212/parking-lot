package parking.lot;

import java.util.List;

public interface Pickupable {
    public Car pickup(Integer carNumber, List<ParkingLot> parkingLots);
}

package parking.lot;

import java.util.List;

public class PickupableImpl implements Pickupable {
    @Override
    public Car pickup(Integer carNumber, List<ParkingLot> parkingLots) {
        ParkingLot parkingLot = parkingLots.stream()
                .filter(lot -> lot.pickup(carNumber) != null)
                .findFirst().orElse(null);

        if(parkingLot != null) {
            return parkingLot.pickup(carNumber);
        }

        return null;
    }
}

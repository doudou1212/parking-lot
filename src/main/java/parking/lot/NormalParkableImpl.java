package parking.lot;

import java.util.List;

public class NormalParkableImpl implements Parkable{
    @Override
    public Integer park(Car car, List<ParkingLot> parkingLots) {
        ParkingLot parkingLot = parkingLots.stream()
                .filter(lot -> lot.isAvailable())
                .findFirst().orElse(null);

        if(parkingLot != null) {
            return parkingLot.park(car);
        }

        return null;
    }
}

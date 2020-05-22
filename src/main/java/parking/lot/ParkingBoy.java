package parking.lot;

import java.util.List;

public class ParkingBoy {

    private List<ParkingLot> parkingLots;
    private Parkable parkable;
    private Pickupable pickupable;

    public ParkingBoy(List<ParkingLot> parkingLots, Parkable parkable, Pickupable pickupable) {
        this.parkingLots = parkingLots;
        this.parkable = parkable;
        this.pickupable = pickupable;
    }

    public Integer park(Car car) {
        return this.parkable.park(car, this.parkingLots);
    }

    public Car pickup(Integer carNumber) {
       return this.pickupable.pickup(carNumber, this.parkingLots);
    }
}

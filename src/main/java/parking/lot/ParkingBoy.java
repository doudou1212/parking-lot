package parking.lot;

import java.util.List;
import java.util.Optional;

public class ParkingBoy {

    private List<ParkingLot> parkingLots;
    private Parkable parkable;
    private Pickupable pickupable;
    private int name = 0;

    public ParkingBoy(List<ParkingLot> parkingLots, Parkable parkable, Pickupable pickupable) {
        this.parkingLots = parkingLots;
        this.parkable = parkable;
        this.pickupable = pickupable;
    }

    public Optional<Integer> park(Car car) {
        return this.parkable.park(car, this.parkingLots);
    }

    public Optional<Car> pickup(Integer carNumber) {
       return this.pickupable.pickup(carNumber, this.parkingLots);
    }

    public boolean isAvailable() {
        return this.parkingLots.stream()
                .filter(ParkingLot::isAvailable)
                .findFirst()
                .map(ParkingLot::isAvailable)
                .orElse(false);
    }

    public boolean isCarInLot(Integer carNumber) {
        return this.parkingLots.stream()
                .filter(parkingLot -> parkingLot.isCarInLot(carNumber))
                .findFirst()
                .map(parkingLot -> parkingLot.isCarInLot(carNumber))
                .orElse(false);
    }

    public void print() {
        System.out.println("Parking boy No: " + this.name + ", Parking Lot info: ");
        this.parkingLots.stream().map(parkingLot -> {
            parkingLot.print();
            return parkingLot;
        }).findFirst();
    }
}

package parking.lot;

import java.util.List;

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

    public ParkingBoy(List<ParkingLot> parkingLots, Parkable parkable, Pickupable pickupable, int name) {
        this.parkingLots = parkingLots;
        this.parkable = parkable;
        this.pickupable = pickupable;
        this.name = name;
    }

    public int getName() {
        return name;
    }

    public Integer park(Car car) {
        return this.parkable.park(car, this.parkingLots);
    }

    public Car pickup(Integer carNumber) {
       return this.pickupable.pickup(carNumber, this.parkingLots);
    }

    public boolean isAvailable() {
        ParkingLot parkingLot = this.parkingLots.stream().filter(lot -> lot.isAvailable()).findFirst().orElse(null);

        if(parkingLot != null) {
            return parkingLot.isAvailable();
        }

        return false;
    }

    public boolean isCarInLot(Integer carNumber) {
        ParkingLot parkingLot = this.parkingLots.stream().filter(lot -> lot.isCarInLot(carNumber)).findFirst().orElse(null);
        if(parkingLot != null) {
            return true;
        }

        return false;
    }

    public void print() {
        System.out.println("Parking boy No: " + this.name + ", Parking Lot info: ");
        this.parkingLots.stream().map(parkingLot -> {
            parkingLot.print();
            return parkingLot;
        }).findFirst();
    }
}

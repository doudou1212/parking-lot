package parking.lot;

import java.util.List;
import java.util.function.Consumer;

public class ParkingManager {
    private List<ParkingLot> parkingLots;
    private List<ParkingBoy> parkingboys;

    public ParkingManager(List<ParkingLot> parkingLots, List<ParkingBoy> parkingboys) {
        this.parkingLots = parkingLots;
        this.parkingboys = parkingboys;
    }

    public Integer park(Car car) {
        ParkingBoy parkingboy = this.parkingboys.stream()
                .filter(parkingBoy -> parkingBoy.isAvailable())
                .findFirst().orElse(null);
        if(parkingboy != null) {
            return parkingboy.park(car);
        }

        ParkingLot parkingLot = this.parkingLots.stream()
                .filter(lot -> lot.isAvailable())
                .findFirst().orElse(null);
        if(parkingLot != null) {
            return parkingLot.park(car);
        }

        return null;
    }

    public Car pickup(Integer carNumber) {
        ParkingLot parkingLot = this.parkingLots.stream().filter(lot -> lot.isCarInLot(carNumber)).findFirst().orElse(null);
        if(parkingLot != null) {
            return parkingLot.pickup(carNumber);
        }

        ParkingBoy parkingBoy = this.parkingboys.stream()
                .filter(boy -> boy.isCarInLot(carNumber))
                .findFirst().orElse(null);

        if(parkingBoy != null) {
            return parkingBoy.pickup(carNumber);
        }

        return null;
    }

    public void print() {
        System.out.println("===============Parking Boys Info=================");
        this.parkingboys.stream().map(boy -> {
            boy.print();
            return boy;
        }).findFirst();

        System.out.println("===============Manager Parking Lot Info=================");
        this.parkingLots.stream().map(lot -> {
            lot.print();
            return lot;
        }).findFirst();
    }
}

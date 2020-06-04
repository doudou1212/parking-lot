package parking.lot;

import java.util.List;
import java.util.Optional;

public class ParkingManager {
    private List<ParkingLot> parkingLots;
    private List<ParkingBoy> parkingBoys;

    public ParkingManager(List<ParkingLot> parkingLots, List<ParkingBoy> parkingBoys) {
        this.parkingLots = parkingLots;
        this.parkingBoys = parkingBoys;
    }

    public Optional<Integer> park(Car car) {
        return this.parkingBoys.stream()
                .filter(ParkingBoy::isAvailable)
                .findFirst()
                .flatMap(parkingBoy -> parkingBoy.park(car))
                .or(() ->
                        this.parkingLots.stream()
                                .filter(ParkingLot::isAvailable)
                                .findFirst()
                                .flatMap(parkingLot -> parkingLot.park(car))
                );
    }

    public Optional<Car> pickup(Integer carNumber) {
        return this.parkingBoys.stream()
                .filter(parkingBoy -> parkingBoy.isCarInLot(carNumber))
                .findFirst()
                .flatMap(parkingBoy -> parkingBoy.pickup(carNumber))
                .or(() -> this.parkingLots.stream()
                        .filter(parkingLot -> parkingLot.isCarInLot(carNumber))
                        .findFirst()
                        .flatMap(parkingLot -> parkingLot.pickup(carNumber))
                );
    }

    public void print() {
        System.out.println("===============Parking Boys Info=================");
        this.parkingBoys.stream().map(boy -> {
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

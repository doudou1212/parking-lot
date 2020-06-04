package parking.lot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingLot {
    private List<Car> parkingSpace;
    private int capability;
    private int name = 0;

    public ParkingLot(int capability) {
        this.capability = capability;
        this.parkingSpace = new ArrayList<>();
    }

    public ParkingLot(int capability, int name) {
        this.capability = capability;
        this.name = name;
        this.parkingSpace = new ArrayList<>();
    }

    public int getName() {
        return name;
    }

    public Optional<Integer> park(Car car) {
        if(this.parkingSpace.size() >= capability)
            return Optional.ofNullable(null);

        this.parkingSpace.add(car);
        return Optional.of(this.name);
    }

    public Optional<Car> pickup(int carNumber) {
        return this.parkingSpace.stream()
                .filter(car -> carNumber == car.getCarNumber())
                .findFirst();
    }

    public boolean isAvailable() {
        return this.parkingSpace.size() < this.capability;
    }

    public int leftSpace() {
        int leftSpace = this.capability - this.parkingSpace.size();
        return Math.max(leftSpace, 0);
    }

    public int getParkingSpareRate() {
        double rate = (double) this.leftSpace() / (double) this.capability;
        return (int) (rate * 100);
    }

    public boolean isCarInLot(Integer carNumber) {
        return this.parkingSpace.stream()
                .filter(car -> carNumber == car.getCarNumber())
                .findFirst()
                .map(car -> true)
                .orElse(false);
    }

    public void print() {
        System.out.println("Parking lot No: " + this.name + ", All space: " + this.capability + ", Left space: " + this.leftSpace() + ", Available rate: " + this.getParkingSpareRate());
    }
}

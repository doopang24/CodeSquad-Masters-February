package week1.day4;

import java.time.YearMonth;

public class Car {
    private String name;
    private String type;
    private int capacity;
    private YearMonth sop;
    private YearMonth eop;

    public Car(String name, String type, int capacity, YearMonth sop, YearMonth eop) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
        this.sop = sop;
        this.eop = eop;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public YearMonth getSop() {
        return sop;
    }

    public YearMonth getEop() {
        return eop;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean canAccommodate(Car targetCar, int people) {  // 인원을 수용할 수 있는가
        return targetCar.getCapacity() >= people;
    }

    public boolean isDiscontinued(Car targetCar) {  // 현재 단종되었는가
        YearMonth nowDay = YearMonth.of(2023, 5);
        return targetCar.getEop().isBefore(nowDay);
    }
}

package week1.day4;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CarManager {   // 자동차 모델의 리스트를 관리하는 클래스

    private List<Car> carList;

    public CarManager() {   // 자동으로 실행되는 생성자
        this.carList = new ArrayList<>();
        setCarList();
        carList.sort(Comparator.comparing(Car::getName));   // Car::getName -> Car 클래스의 getName 메서드를 참조한다
    }

    private void setCarList() {
        carList.add(new Car("Tuscani", "Coupe", 2, YearMonth.of(2001, 9), YearMonth.of(2008, 10)));
        carList.add(new Car("Porter", "Truck", 3, YearMonth.of(1977, 2), YearMonth.of(2004, 5)));
        carList.add(new Car("Cortina", "Sedan", 5, YearMonth.of(1968, 1), YearMonth.of(1980, 4)));
        carList.add(new Car("Elantra", "Sedan", 5, YearMonth.of(1990, 10), YearMonth.of(1995, 12)));
        carList.add(new Car("Equus", "Sedan", 5, YearMonth.of(1999, 4), YearMonth.of(2009, 12)));
        carList.add(new Car("Grandeur", "Sedan", 5, YearMonth.of(1986, 7), YearMonth.of(2023, 5)));
        carList.add(new Car("Pony", "Sedan", 5, YearMonth.of(1975, 12), YearMonth.of(1982, 1)));
        carList.add(new Car("SantaFe", "RV", 7, YearMonth.of(2000, 6), YearMonth.of(2023, 5)));
        carList.add(new Car("Aerotown", "Bus", 30, YearMonth.of(1994, 6), YearMonth.of(2023, 5)));
        carList.add(new Car("Universe", "Bus", 45, YearMonth.of(2006, 12), YearMonth.of(2023, 5)));
    }

    public List<Car> getAvailableCarByDate(YearMonth referencePoint) {  // 이 리스트에 아무것도 안 들어감
        List<Car> availableCarList = new ArrayList<>();
        for (Car car : carList) {
            if (car.getSop().isBefore(referencePoint) && car.getEop().isAfter(referencePoint)) {
                availableCarList.add(car);
            }
        }
        return availableCarList;
    }
}

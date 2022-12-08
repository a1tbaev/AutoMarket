package java_8.services.impl;

import java_8.classes.Car;
import java_8.classes.Person;
import java_8.services.CarService;

import java.util.LinkedList;
import java.util.List;

public class CarServiceImpl implements CarService {
    List<Car> cars = new LinkedList<>();
    @Override
    public String createCar(List<Car> cars) {
        this.cars = cars;
        return "cars successfully created!!";
    }

    @Override
    public String removeCar(String name, List<Car> cars) {
        for (Car car : cars) {
            if (car.getName().contains(name)){
                cars.remove(car);
                return "car successfully deleted!!";
            }
        }
        return "Car was not find!!";
    }

    @Override
    public List<Car> getAll() {
        return cars;
    }

    @Override
    public Car findByName(String name, List<Car> cars) {
        for (Car car : cars) {
            if (car.getName().equals(name)){
                return car;
            }
        }
        return null;
    }

    @Override
    public List<Car> findByCountry(String name, List<Car> cars) {
        List<Car>cars1 = new LinkedList<>();
        for (Car car : cars) {
            if (car.getCountryOfOrigin().name().equals(name.toUpperCase())){
                cars1.add(car);
            }
        }
        return cars1;
    }
}

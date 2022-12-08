package java_8.services;

import java_8.classes.Car;
import java_8.classes.Person;

import java.util.List;

public interface CarService {
    String createCar(List<Car> cars);

    String removeCar(String name,List<Car>cars);

    List<Car>getAll();

    Car findByName(String name, List<Car>cars);

    List<Car>findByCountry(String name,List<Car>persons);
}

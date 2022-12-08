package java_8.services.impl;

import java_8.classes.Car;
import java_8.classes.Person;
import java_8.services.PersonService;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class PersonServiceImpl implements PersonService {
    List<Person> people = new LinkedList<>();
    List<Car> cars1 = new LinkedList<>();
    @Override
    public String createPerson(List<Person> people) {
        this.people = people;
        return "Person is successfully created!";
    }

    @Override
    public String removePerson(String name, List<Person> people) {
        try{
            if (!name.matches("[a-zA-Zа-яА-Я]*")){
                throw new Exception("kk");
            }
            for (Person person : people) {
                if (person.getName().contains(name)){
                    people.remove(person);
                    return "Person is successfully deleted!";
                }
            }
            return "404 not found";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Person> getAll() {
        return this.people;
    }

    @Override
    public List<Person> findByName(String name, List<Person> people) {
        List<Person> personList = new LinkedList<>();
        try {
            if (!name.matches("[a-zA-Zа-яА-Я]*")) {
                throw new Exception();
            }
            for (Person person : people) {
                if (person.getName().equals(name)){
                    personList.add(person);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return personList;
    }

    @Override
    public List<Person> findByCarName(String name, List<Person> people) {
        List<Person> personList = new LinkedList<>();
        try {
            if (!name.matches("[a-zA-Zа-яА-Я]*")) {
                throw new Exception();
            }
            for (Person person : people) {
                for (Car car : person.getCars()) {
                    if (car.getName().equals(name)){
                        personList.add(person);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return personList;
    }

    @Override
    public String payCars(String name, List<Person> people, String carName, List<Car> cars) {

        for (Person person : people) {
           if(person.getName().contains(name)){
               for (Car car : cars) {
                   if (car.getName().contains(carName)){
                       int n = person.getMoney().subtract(car.getPrice()).intValue();
                        if (n >= 0){
                            if (person.getCars() == null){
                                person.setCars(List.of(car));
                                cars1.removeAll(cars);
                                cars1.add(car);
                                cars.remove(car);
                                person.setMoney(person.getMoney().subtract(car.getPrice()));
                            }else {
                                person.setCars(cars1);
                                cars1.add(car);
                                cars.remove(car);
                                person.setMoney(person.getMoney().subtract(car.getPrice()));
                            }
                            return "successfully paid";
                        }else{
                            return "not enough money";
                        }
                   }
               }
           }
        }
        return "car was sell";
    }

    public static Comparator<Person> sortPersonDateOfBirth = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
        }
    };

    public static Comparator<Person> sortPersonName = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };
    public static Comparator<Person>sortGender = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getGender().name().compareTo(o2.getGender().name());
        }
    };
    @Override
    public List<Person> sortPersonDateOfBirth(List<Person> people) {
        people.sort(sortPersonDateOfBirth);
        return people;
    }

    @Override
    public List<Person> sortPersonName(List<Person> people) {
        people.sort(sortPersonName);
        return people;
    }

    @Override
    public List<Person> sortGender(List<Person> people) {
        people.sort(sortGender);
        return people;
    }

    @Override
    public int getAge(List<Person> people, String name) {
        for (Person person : people) {
            if (person.getName().contains(name)){
                return Period.between(person.getDateOfBirth(), LocalDate.now()).getYears();
            }
        }
        return 0;
    }
}

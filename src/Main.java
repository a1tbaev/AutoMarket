import java_8.classes.Car;
import java_8.classes.Person;
import java_8.enums.Colour;
import java_8.enums.Country;
import java_8.enums.Gender;
import java_8.services.impl.CarServiceImpl;
import java_8.services.impl.PersonServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Year;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("kunan", "taitoru", new BigDecimal(12000), Year.of(2022), Colour.WHITE, Country.KYRGYZSTAN);
        Car car1 = new Car("tulpar", "karager", new BigDecimal(10000), Year.of(2017), Colour.BLACK, Country.KYRGYZSTAN);
        Car car2 = new Car("BMW", "e34", new BigDecimal(5000), Year.of(1998), Colour.BLUE, Country.GERMANY);
        Car car3 = new Car("Toyota", "camry", new BigDecimal(7000), Year.of(2000), Colour.RED, Country.JAPAN);
        Car car4 = new Car("Mers", "e250", new BigDecimal(6000), Year.of(2004), Colour.BLUE, Country.GERMANY);
        List<Car> cars = new LinkedList<>(List.of(car, car1, car2, car3,car4));

        Person person3 = new Person("Adil", LocalDate.of(2004,2,17), Gender.MALE, new BigDecimal(1000000), "000000", null);
        Person person1 = new Person("Nuriza", LocalDate.of(2005,2,5), Gender.FEMALE, new BigDecimal(999999), "122334", null);
        Person person2 = new Person("Balancha", LocalDate.of(2001,12,12), Gender.MALE, new BigDecimal(10000), "000000", null);
        List<Person> people = new LinkedList<>(List.of(person3, person1, person2));
        CarServiceImpl carService = new CarServiceImpl();

        PersonServiceImpl person = new PersonServiceImpl();
        while (true){
                System.out.println("""
            1. Create people!
            2. Remove person!
            3. Get all people!
            4. Find by person's name!
            5. Find people by car's name!
            6. Buy the car!
            7. Sort by date of birth!
            8. Sort by people's name!
            9. Sort by gender!
            10. Get age!
            11. Create cars!
            12. Remove car!
            13. Get all cars!
            14. Find car by name!
            15. Find car by country!
            """);
            int number = new Scanner(System.in).nextInt();
            switch (number) {
                case 1 -> System.out.println(person.createPerson(people));
                case 2 -> {
                    System.out.print("Write the person name: ");
                    String name = new Scanner(System.in).next();
                    System.out.println(person.removePerson(name, people));
                }
                case 3 -> System.out.println(person.getAll());
                case 4 -> {
                    System.out.print("Write the person name: ");
                    String name = new Scanner(System.in).next();
                    System.out.println(person.findByName(name, people));
                }
                case 5 -> {
                    System.out.print("Write the car name: ");
                    String name = new Scanner(System.in).next();
                    System.out.println(person.findByCarName(name, people));
                }
                case 6 -> {
                    System.out.print("Write the person name: ");
                    String n = new Scanner(System.in).next();
                    System.out.print("Write the car name: ");
                    String c = new Scanner(System.in).next();
                    System.out.println(person.payCars(n, people, c, cars));
                }
                case 7 -> System.out.println(person.sortPersonDateOfBirth(people));
                case 8 -> System.out.println(person.sortPersonName(people));
                case 9 -> System.out.println(person.sortGender(people));
                case 10 -> {
                    System.out.println("Write the person's name!");
                    String name = new Scanner(System.in).next();
                    System.out.println(person.getAge(people, name));
                }
                case 11 -> System.out.println(carService.createCar(cars));
                case 12 -> {
                    System.out.print("Write the car's name!");
                    String carName = new Scanner(System.in).next();
                    System.out.println(carService.removeCar(carName, cars));
                }
                case 13 -> System.out.println(carService.getAll());
                case 14 -> {
                    System.out.print("Write the car's name!");
                    String carName = new Scanner(System.in).next();
                    System.out.println(carService.findByName(carName, cars));
                }
                case 15 -> {
                    System.out.print("Write the Country of car! ");
                    String countryName = new Scanner(System.in).next();
                    System.out.println(carService.findByCountry(countryName, cars));
                }
                default -> throw new RuntimeException("404 not found");
            }
        }
    }
}
package service;

import model.Car;
import model.User;
import utils.MyList;

public interface MainService {

    // прописывать логику из техзадания (все пункты ТЗ должны быть обеспечены методами)
    // на практике нужно сервис создавать для каждого типа обэектов, мы для упрощения
    // все делаем в одном

    //----------------------------------Методы для машин---------------------------------------------

    //READ
    //create  - add
    void addCar(String model, int year, double price);

    //получить список всех машин
    MyList<Car> getAllCars();

    //получить машин по ID
    //Car getCarById(int id);

    //получить машину по модели
    MyList<Car> getCarsByModel(String model);

    //получить список свободных машин
    MyList<Car> getFriCars();

    //UPDATE
    // boolean (удалось/неудалось)
    boolean updateCarPrice(int id, double price);

    boolean takeCar(int id);

    //DELETE
    Car deleteCar(int id);

    //----------------------------------Методы для пользователей---------------------------------------------

    User registerUser(String email, String password);

    boolean loginUser(String email, String password);

    void logOut();



}

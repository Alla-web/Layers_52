package repository;
/*
CRUD - операции:
Create - создание, добавление данных
Read - чтение, получение новых данных
Update - обновление - изменение существующих данных
Delete - удаление данных
 */

import model.Car;
import utils.MyList;

public interface CarRepository {

    //READ
    //create  - add
    void addCar(String model, int year, double price);

    //получить список всех машин
    MyList<Car> getAllCars();

    //
    Car getCarById(int id);

    //получить машину по модели
    MyList<Car> getCarsByModel(String model);

    //получить список свободных машин
    MyList<Car> getFriCars();

    //DELETE
    void deleteCar(Car car);
}

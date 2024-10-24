package repository;

import model.Car;
import utils.MyArrayGenList;
import utils.MyList;

import java.util.concurrent.atomic.AtomicInteger;

/*
CRUD - операции:
Create - создание, добавление данных
Read - чтение, получение новых данных
Update - обновление - изменение существующих данных
Delete - удаление данных
 */

public class CarRepositoryImpl implements CarRepository {

    //ВАЖНО!!! НИКАКИХ ПРОВЕРОК В СЛОЕ РЕПОЗИТОРИЙ, все проверки в СЕРВИСном слое

    // имитация базы данных
    // будут храниться все наши машины
    private final MyList<Car> cars; //??? почему MyList

    //объект, отвечающий за генерацию уникальных ID //?????????
    private final AtomicInteger currentId = new AtomicInteger(1);

    //constructor
    public CarRepositoryImpl() {
        this.cars = new MyArrayGenList<>(); //??? почему MyArrayGenList
    }

    //methods
    @Override
    public void addCar(String model, int year, double price) {
        //currentId.getAndIncrement() -> аналог currentId++; - получает текущий id и увеличивает его на +1
        Car car = new Car(currentId.getAndIncrement(), model, year, price);
        cars.add(car); // сохранение в хранилище
    }

    @Override
    public MyList<Car> getAllCars() {
        return null;
    }

    @Override
    public Car getCarById(int id) {
        return null;
    }

    @Override
    public MyList<Car> getCarsByModel(String model) {
        return null;
    }

    @Override
    public MyList<Car> getFriCars() {
        return null;
    }

    @Override
    public boolean updateCarModel(int id, String model) {
        return false;
    }

    @Override
    public boolean takeCar(int id) {
        return false;
    }

    @Override
    public Car deleteCar(int id) {
        return null;
    }
}

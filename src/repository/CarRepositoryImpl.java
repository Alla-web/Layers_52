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
        return cars;
    }

    @Override
    public Car getCarById(int id) {
        //ищем одну машину с унркальным id
        for (Car car : cars) { // список всех существующих машин
            if (car.getId() == id) return car;
        }
        //если не нашли - возвращаем null
        return null;
    }

    @Override
    public MyList<Car> getCarsByModel(String model) {
        //создаём пустой список машин одной модели (т.к. их может быть не сколько)
        MyList<Car> carsByModelList = new MyArrayGenList<>();
        // перебераем циклом все наши машины
        for (Car car : cars) { // список всех существующих машин
            // если модель машины совпадает с искомой моделью, добавляем машину
            // в список машин данной модели (result)
            if (car.getModel().equals(model)) carsByModelList.add(car);
        }
        return carsByModelList;
    }

    @Override
    public MyList<Car> getFriCars() {
        //ищем список свободных машинок
        MyList<Car> friCarsList = new MyArrayGenList<>();
        //перебераем циклом все наши машины
        for (Car car : cars) { // список всех существующих машин
            // если машина не занята (car.isBusy() == false),
            // добавляем машину в список свободных машин (result)
            if (!car.isBusy()) friCarsList.add(car);
            //!car.isBusy()) вместо car.isBusy() == false
             /*
             более понятная форма записи
             if (car.isBusy()) { // значит, что если isBusy == true (машина)
                    пустая строка значит - ничего не делать при этом условии
             } else {
                при условии car.isBusy() == false добавляем машину в список свободных машин
                friCarsList.add(car);
             */
            return friCarsList;
        }
        return null;
    }

    //метод, возвращающий список всех занятых машин
    public MyList<Car> getAllBusyCars() {
        MyList<Car> busyCarsList = new MyArrayGenList<>();
        for (Car car : cars) { // список всех существующих машин
            if (car.isBusy()) busyCarsList.add(car);
            return busyCarsList;
        }
        return null;
    }

    //TODO перенести метод в сервис
    public boolean updateCarPrice(int id, double price) {
        Car car = getCarById(id);
        // провенряем, если метод getCarById не нашёл машину (вернул null) возвращаем false
        if (car == getCarById(id)) return false;
        car.setPrice(price);
        return false;
    }

    @Override
    public void deleteCar(Car car) {
        cars.remove(car);
    }

}

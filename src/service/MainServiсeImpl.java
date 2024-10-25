package service;

import model.Car;
import model.User;
import repository.CarRepository;
import repository.UserRepository;
import utils.MyList;

public class MainServiсeImpl implements MainService {

    // здесь будет связь с репозиторием
    private final CarRepository repositoryCar; // репозиторная ссылка???
    private final UserRepository repositoryUser;

    private User activeUser;

    public MainServiсeImpl(CarRepository repositoryCar, UserRepository repositoryUser) {
        this.repositoryCar = repositoryCar;
        this.repositoryUser = repositoryUser;
    }

    @Override
    public void addCar(String model, int year, double price) {

    }

    @Override
    public MyList<Car> getAllCars() {
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
    public boolean updateCarPrice(int id, double price) {
        Car car = repositoryCar.getCarById(id);
        if (car == null || price < 0) {
            return false;
        }
        // в противном случае
        car.setPrice(price);
        return true;
    }

    @Override
    public boolean takeCar(int id) {
        //получить машину из репозитория
        Car car = repositoryCar.getCarById(id);
        // TODO доделать
        /*
        проверить, что она найдена и свободна,
        если нет- закончсить, если да:
        пометить машину как занятую,
        добавить машину в список машин текущего пользователя(корпоративный клиент)

         */


        return false;
    }

    @Override
    public Car deleteCar(int id) {
        Car car = repositoryCar.getCarById(id); // получаем из репозитория машину по id
        if (car == null) return null;

        repositoryCar.deleteCar(car);
        return car;
    }

    @Override
    public User registerUser(String email, String password) {
        // добавить валидацию емайла
        // если не прошла валидация - закончитьработу метода, вернуть налл

        if (repositoryUser.isEmailExist(email)) {
            System.out.println("Email already exist");
        }
        User user = repositoryUser.addUser(email, password);
        return user;
    }

    @Override
    public boolean loginUser(String email, String password) {
        /*
        нужно найти пользователя в нашей базе данных с тким имейлом
        если такого метода не существует - отказать и выдать сообщение "пароль
            с имейлом не соответствуют" чтобы не давать
        проверить, совпадает ли пароль у пользователя в БД с паролем, который пришел в метод
        если не совпадает - отказать
        Залогинить пользователя - пометить как активный пользователь системы
         */
        User user = repositoryUser.getUserEmail(email);
        if (user == null) {
            System.out.println("Invalid email or password");
            return false;
        }
        if (!user.getPassword().equals(password)) {
            System.out.println("Invalid email or password");
            return false;
        }
        activeUser = user;
        return true;
    }

    //геттер на юзера
    public User getActiveUser() {
        return activeUser;
    }

    @Override
    public void logOut() {
        activeUser = null;
    }
}

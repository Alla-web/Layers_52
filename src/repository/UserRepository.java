package repository;

import model.User;

public interface UserRepository {

    //добавление нового юзера
    User addUser(String email, String password); //имейл дожен быть уникальным

    //метод проверки имейла
    boolean isEmailExist(String email);

    // получить имейл юзера
    User getUserEmail(String email);


}

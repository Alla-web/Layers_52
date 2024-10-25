package repository;

import model.User;
import utils.MyArrayGenList;
import utils.MyList;

public class UserRepositoryImpl implements UserRepository {

    private final MyList<User> users;

    public UserRepositoryImpl() {
        users = new MyArrayGenList<>();
    }

    //TODO

    @Override
    public User addUser(String email, String password) {
        User user = new User(email, password);
        users.add(user);
        return user;
    }

    @Override
    public boolean isEmailExist(String email) {
        return false;
    }

    @Override
    public User getUserEmail(String email) {
        return null;
    }
}

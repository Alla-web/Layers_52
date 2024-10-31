package model;

import utils.MyArrayGenList;
import utils.MyList;

public class User {

    private String email; // в качестве ID
    private String password;
    private Role role;
    private final MyList<Car> userCars;

    //constructor
    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.role = Role.USER;
        this.userCars = new MyArrayGenList<>();
    }

    // getters
    public Role getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public MyList<Car> getUserCars() {
        return userCars;
    }

    // setters
    public void setRole(Role role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // methods


    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", userCars = " + userCars +
                ", role = " + role +
                '}';
    }
}

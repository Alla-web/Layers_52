package model;

public class Car {
    private final int id;
    private String model;
    private final int year;
    private double price;
    private boolean isBusy; // задаётся false по умолчанию
    // и нас это устраивает, а если нам нужно это установить правда
    // мы должны были бы в конструктор добавить со значением правда

    public Car(int id, String model, int year, double price) {
        this.id = id;
        this.model = model;
        this.year = year;
        this.price = price;
        //this.isBusy = false; не пишем, т.к. по умолчанию у типа boolean значение false
    }

    //getters
    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public boolean isBusy() {
        return isBusy;
    }

    // setters
    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    //methods
    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", isBusy=" + isBusy +
                '}';
    }

    //переопределили метод equals для безопасного сравнения объектов
    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;

        Car car = (Car) o;
        return id == car.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}

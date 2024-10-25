import repository.CarRepository;
import repository.CarRepositoryImpl;
import repository.UserRepository;
import repository.UserRepositoryImpl;
import service.MainService;
import service.MainServiсeImpl;
import view.Menu;

public class CarsApp {
    public static void main(String[] args) {

        CarRepository carRepository  = new CarRepositoryImpl();
        UserRepository userRepository = new UserRepositoryImpl();

        MainService service = new MainServiсeImpl(carRepository, userRepository);

        Menu menu = new Menu(service);

        menu.run();
    }
}

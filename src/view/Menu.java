package view;

import model.User;
import repository.UserRepository;
import service.MainService;

import java.util.Scanner;

public class Menu {

    // меню общается только с сервисами
    private final MainService service;
    private final Scanner scanner = new Scanner(System.in);

    public Menu(MainService service) {
        this.service = service;
    }

    public void run() {
        showMenu();
    }

    private void showMenu() {
        while (true) {
            System.out.println("Welcome to menu");
            System.out.println("1.Menu of cars");
            System.out.println("2.Menu of users");
            System.out.println("3.Menu of administrator");
            System.out.println("0.LogOut");
            System.out.println("\n type yur choice, please");

            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) {
                System.out.println("До свидания");
                //завершить работу приложения
                System.exit(0); //команда завершения работы приложения
            }

            showSubMenu(choice);
        }
    }

    private void showSubMenu(int choice) {
        switch (choice) {
            case 1:
                //TODO
                //showCarMenu();
                break;
            case 2:
                showUserMenu();
                break;
            case 3:
                //TODO
                //showAdminMenu();
                break;
            default:
                System.out.println("Сделайте корректный выбор");
        }
    }

    private void showUserMenu() {
        while (true) {
            System.out.println("Menu of user");
            System.out.println("1.Вход в систему");
            System.out.println("2.Регистрация нового пользователя");
            System.out.println("3.Logout");
            System.out.println("0.Вернуться в предъидущее меню");

            System.out.println("\nСделайте корректный выбор пункта меню");
            int input = scanner.nextInt();
            scanner.nextLine();
            // прервать текущий цикл
            if (input == 0) break;

            handleUserMenuChoice(input);
        }

    }

    private void handleUserMenuChoice(int input) {
        switch (input) {
            case 1:
                //TODO написать автризацию
                System.out.println("Метод в разработке");
                waitRead();
                break;
            case 2:
                //регистрация
                System.out.println("Регистрация нового пользователя");
                System.out.println("Введите имейл");
                String email = scanner.nextLine();
                System.out.println("Введите пароль");
                String password = scanner.nextLine();

                User user = service.registerUser(email, password); //отправили юзера в сервис на проверку
                if (user != null) {
                    System.out.println("Вы успешно зарегистрировались в системе");
                } else {
                    System.out.println("Регистрация провалена");
                }
                waitRead();
                break;
            case 3:
                //логаут
                service.logOut();
                System.out.println("Вы вышли из системы");
                waitRead();
                break;
            default:
                System.out.println("\nНеверный ввод");

        }
    }

    private void waitRead() {
        System.out.println("\nДля продолжения нажми кнопку Enter");
        scanner.nextLine();
    }

}

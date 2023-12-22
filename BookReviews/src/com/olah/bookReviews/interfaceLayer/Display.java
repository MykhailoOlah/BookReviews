package com.olah.bookReviews.interfaceLayer;

import com.olah.bookReviews.businessLogic.ReviewManager;
import com.olah.bookReviews.businessLogic.User;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * Клас, що відповідає за відображення консольного інтерфейсу користувача.
 */
public class Display {

    /**
     * Об'єкт Scanner для зчитування введених користувачем даних
     */
    static Scanner scanner = new Scanner(System.in);
    /**
     * Логін користувача.
     */
    static String login;
    /**
     * Пароль користувача.
     */
    static String password;

    /**
     * Відображення меню входу.
     */
    public static void enterMenu() {
        System.out.println("Книга відгуків кінотеатру: 5 Елемент");
        System.out.println("[1] Авторизація");
        System.out.println("[2] Реєстрація");

        switch (scanner.nextLine()) {
            case "1":
                logInMenu();
                break;
            case "2":
                signUpMenu();
                break;
            default:
                System.out.println("Невірний вибір!");
                enterMenu();
        }
    }

    /**
     * Відображення меню авторизації.
     */
    public static void logInMenu() {
        System.out.println("Авторизація:");
        System.out.println("Введіть логін:");
        login = scanner.nextLine();
        System.out.println("Введіть пароль:");
        password = scanner.nextLine();
        try {
            LogInSignUp.logIn(login, password);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Відображення меню реєстрації.
     */
    public static void signUpMenu() {
        System.out.println("Реєстрація:");
        System.out.println("Введіть логін:");
        login = scanner.nextLine();
        System.out.println("Введіть пароль:");
        password = scanner.nextLine();
        LogInSignUp.signUp(login, password);
    }

    /**
     * Відображення головного меню.
     * @param user Об'єкт користувача.
     */
    public static void reviewsMenu(User user) {
        System.out.println("Книга відгуків кінотеатру: 5 Елемент");
        System.out.println("[1] Залишити відгук");
        System.out.println("[2] Перегляд відгуків");
        System.out.println("[3] Вихід");

        switch (scanner.nextLine()) {
            case "1":
                writeReview(user);
                break;
            case "2":
                readReviews(user);
                break;
            case "3":
                enterMenu();
                break;
            default:
                System.out.println("Невірний вибір!");
                reviewsMenu(user);
        }
    }

    /**
     * Відображення меню написання відгуку.
     * @param user Об'єкт користувача.
     */
    public static void writeReview(User user) {
        String theme = " ";

        System.out.println("Оберіть тему відгуку");
        System.out.println("[1] Комфорт та зручність");
        System.out.println("[2] Якість зображення та звуку");
        System.out.println("[3] Обслуговування та сервіс");
        System.out.println("[4] Ціни");
        System.out.println("[5] Атмосфера та загальне враження");
        System.out.println("[6] Додаткові послуги");


        switch (scanner.nextLine()) {
            case "1":
                theme = "Комфорт та зручність";
                break;
            case "2":
                theme = "Якість зображення та звуку";
                break;
            case "3":
                theme = "Обслуговування та сервіс";
                break;
            case "4":
                theme = "Ціни";
                break;
            case "5":
                theme = "Атмосфера та загальне враження";
                break;
            case "6":
                theme = "Додаткові послуги";
                break;
            default:
                System.out.println("Невірний вибір!");
                writeReview(user);
        }

        System.out.println("Залиште відгук:");
        String review = scanner.nextLine();

        ReviewManager.writeReview(user, theme, review);
        System.out.println("Відгук збережено!");

        reviewsMenu(user);
    }

    /**
     * Відображення всіх відгуків.
     *
     * @param user Об'єкт користувача.
     */
    public static void readReviews(User user) {
        System.out.println(ReviewManager.allReviews());
        reviewsMenu(user);
    }
}

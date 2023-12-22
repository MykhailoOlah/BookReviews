package com.olah.bookReviews.interfaceLayer;

import com.olah.bookReviews.businessLogic.FileManager;
import com.olah.bookReviews.businessLogic.User;
import java.security.NoSuchAlgorithmException;

/**
 * Клас, що відповідає за реєстрацію та авторизацію користувачів.
 */
public class LogInSignUp {

    /**
     * Шлях до файлу для зберігання даних користувача
     */
    static String pathUsers = "src/com/olah/bookReviews/dataLayer/users.txt";
    /**
     * Масив, що містить інформацію про користувачів.
     */
    static String[] users;
    /**
     * Масив, що містить дані конкретного користувача.
     */
    static String[] userData;
    /**
     * Змінна, що вказує, чи існує вже введений логін.
     */
    static boolean loginExist = false;

    /**
     * Реєстрація нового користувача.
     *
     * @param login    Логін нового користувача.
     * @param password Пароль нового користувача.
     */
    public static void signUp(String login, String password) {
        users = FileManager.readedFromFile(pathUsers).split("\n");

        for (String user : users) {
            userData = user.split("\t");

            if (userData[0].equals(login)) {
                loginExist = true;
                System.out.println("Користувача не знайдено");
                break;
            }
        }

        if (!loginExist) {
            //Створення об'єкту користувач
            User newUser = new User(login, password);
            String writeUser = newUser.getLogin() + "\t" + newUser.getPassword() + "\n";

            FileManager.writeToFile(writeUser, pathUsers);
            System.out.println("Реєстрація успішна!");
        }
        Display.enterMenu();
    }

    /**
     * Авторизація користувача.
     *
     * @param login    Логін користувача для авторизації.
     * @param password Пароль користувача для авторизації.
     * @throws NoSuchAlgorithmException - якщо алгоритм хешування не підтримується,
     * @see User#hashPassword(String password)
     */
    public static void logIn(String login, String password) throws NoSuchAlgorithmException {
        users = FileManager.readedFromFile(pathUsers).split("\n");

        for (String user : users) {
            userData = user.split("\t");

            if (userData[0].equals(login)) {
                loginExist = true;

                if (User.hashPassword(password).equals(userData[1])) {
                    System.out.println("Авторизація успішна!");

                    User newUser = new User(login, password);
                    Display.reviewsMenu(newUser);
                    break;
                } else {
                    System.out.println("Невірний пароль");
                    Display.enterMenu();
                    break;
                }
            }
        }
        if (!loginExist) {
            System.out.println("Користувача не знайдено");
            Display.enterMenu();
        }
    }
}

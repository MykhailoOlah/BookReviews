package com.olah.bookReviews.businessLogic;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Клас, що представляє користувача системи.
 */
public class User implements Serializable {

    /**
     * Унікальний ідентифікатор версії класу для серіалізації.
     */
    private static final long serialVersionUID = 1L;
    /**
     * Логін користувача.
     */
    private String login;
    /**
     * Захешований пароль користувача.
     */
    private String password;

    /**
     * Конструктор класу User - створення об'єкта користувача з вказаним логіном та паролем.
     *
     * @param login    Логін користувача.
     * @param password Пароль користувача.
     */
    public User(String login, String password) {
        this.login = login;
        try {
            this.password = hashPassword(password);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Повертає логін користувача.
     *
     * @return Логін користувача.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Повертає захешований пароль користувача.
     *
     * @return Захешований пароль користувача.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Хешує пароль за допомогою алгоритму SHA-512.
     *
     * @param password Пароль для хешування.
     * @return Захешований пароль у вигляді рядка.
     * @throws NoSuchAlgorithmException - Якщо виникає помилка при виборі алгоритму хешування.
     */
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
        byte[] hashedBytes = messageDigest.digest(password.getBytes());

        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : hashedBytes) {
            stringBuilder.append(String.format("%02x", b));
        }

        return stringBuilder.toString();
    }
}

package com.olah.bookReviews.businessLogic;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Клас, що представляє відгук.
 */
public class Review implements Serializable {

    /**
     * Логін користувача, який залишив відгук.
     */
    public String user;
    /**
     * Тема відгуку.
     */
    public String theme;
    /**
     * Опис відгуку.
     */
    public String description;
    /**
     * Дата публікації відгуку.
     */
    public LocalDate publishData;

    /**
     * Конструктор для створення нового відгуку.
     *
     * @param user        Користувач, що залишив відгук.
     * @param theme       Тема відгуку.
     * @param description Опис відгуку.
     */
    public Review(User user, String theme, String description) {
        this.user = user.getLogin();
        this.theme = theme;
        this.description = description;
        this.publishData = LocalDate.now();
    }

    /**
     * Повертає рядок із представленням відгуку.
     *
     * @return Рядок із представленням відгуку.
     */
    @Override
    public String toString() {
        return "\n╭───────────────────────────────\n" +
              "│ Тема: " + theme + "\n" +
              "│ User: " + user + "\n" +
              "│ Відгук: " + description + "\n" +
              "│ Дата публікації: " + publishData.toString() + "\n" +
              "╰───────────────────────────────\n";
    }

}

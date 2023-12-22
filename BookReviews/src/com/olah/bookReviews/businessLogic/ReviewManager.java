package com.olah.bookReviews.businessLogic;

/**
 * Клас, що керує відгуками користувачів.
 */
public class ReviewManager {
    /**
     * Шлях до файлу для зберігання відгуків
     */
    static String pathReviews = "src/com/olah/bookReviews/dataLayer/reviews.txt";

    /**
     * Створює відгук з отриманих даних та записує до файлу.
     *
     * @param user  користувач, який залишає відгук.
     * @param theme тема відгуку.
     * @param description   текст відгуку.
     */
    public static void writeReview(User user, String theme, String description){
        Review newReview = new Review(user, theme, description);
        FileManager.writeToFile(newReview.toString(), pathReviews);
    }

    /**
     * Отримує всі відгуки з файлу.
     *
     * @return Рядок всіх відгуків.
     */
    public static String allReviews(){
        return FileManager.readedFromFile(pathReviews);
    }
}

package com.olah.bookReviews.main;

import com.olah.bookReviews.interfaceLayer.Display;
/**
 * Головний клас програми, який запускає консольний інтерфейс для керування відгуками.
 */
public class Main {
    /**
     * Метод main, який викликає відображення меню входу
     *
     * @param args Аргументи командного рядка (не використовуються).
     */
    public static void main(String[] args){
        Display.enterMenu();
    }
}

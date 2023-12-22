package com.olah.bookReviews.businessLogic;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Клас для роботи з файлами - створення, запис та читання.
 */
public class FileManager {

    /**
     * Шлях до каталогу для зберігання файлів
     */
    static String pathFiles = "src/com/olah/bookReviews/dataLayer";

    /**
     * Перевіряє існування файлу за заданим шляхом.
     *
     * @param file файл, існування якого перевіряється.
     * @return true, якщо файл існує, в іншому випадку - false.
     */
    public static boolean isFileExists(File file) {
        return file.isFile();
    }

    /**
     * Створює файл за заданим шляхом, якщо він не існує.
     *
     * @param pathToFile шлях до файлу, який потрібно створити.
     */
    public static void createFile(String pathToFile) {
        if (!isFileExists(new File(pathToFile))) {
            try {
                File directory = new File(pathFiles);
                directory.mkdir();
                FileWriter fileWriter = new FileWriter(pathToFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Записує рядок в файл.
     *
     * @param writeToFile Рядок для запису в файл.
     * @param pathToFile  Шлях до файлу.
     */
    public static void writeToFile(String writeToFile, String pathToFile) {
        createFile(pathToFile);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(pathToFile, true);
            fileOutputStream.write(writeToFile.getBytes());

            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Читає вміст файлу та повертає у вигляді рядка.
     *
     * @param pathToFile Шлях до файлу.
     * @return Рядок з вмістом файлу.
     */
    public static String readedFromFile(String pathToFile) {
        createFile(pathToFile);

        StringBuilder stringBuilder = new StringBuilder();
        try {
            FileInputStream fileInputStream = new FileInputStream(pathToFile);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            InputStreamReader reader = new InputStreamReader(bufferedInputStream,
                StandardCharsets.UTF_8);

            int content;
            while ((content = reader.read()) != -1) {
                stringBuilder.append((char) content);
            }

            fileInputStream.close();
            bufferedInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }
}

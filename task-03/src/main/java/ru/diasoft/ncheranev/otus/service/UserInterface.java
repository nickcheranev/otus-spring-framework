package ru.diasoft.ncheranev.otus.service;

/**
 * Интерфейс пользователя
 */
public interface UserInterface {
    /**
     * Получить строку от пользователя
     *
     * @return текст
     */
    String getLine();

    /**
     * Получить имя пользователя
     *
     * @return имя
     */
    String getName();

    /**
     * Вывести данные пользователю
     *
     * @param line текст
     */
    void outLine(String line);
}

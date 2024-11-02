package ru.diasoft.ncheranev.otus.service;

import ru.diasoft.ncheranev.otus.model.Quiz;

/**
 * Загрузчик викторины
 */
public interface QuizLoader {
    /**
     * Загрузить викторину (список вопросов с ответами)
     *
     * @return викторину
     */
    Quiz load();
}

package ru.diasoft.ncheranev.otus.service;

import ru.diasoft.ncheranev.otus.model.Quiz;

/**
 * Демонстратор викторины
 */
public interface QuizShow {
    /**
     * Показать вопросы викторины пользователю
     *
     * @param quiz данные викторины (вопросы, ответы)
     */
    void show(Quiz quiz);
}

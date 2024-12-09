package ru.diasoft.ncheranev.otus.service;

import ru.diasoft.ncheranev.otus.model.Question;

import java.util.List;

/**
 * DAO вопросов викторины
 */
public interface QuestionDao {
    /**
     * Загрузить список вопросов с ответами
     *
     * @return список вопросов
     */
    List<Question> read();
}

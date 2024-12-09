package ru.diasoft.ncheranev.otus.service;

import ru.diasoft.ncheranev.otus.model.Question;

/**
 * Форматер вопроса
 */
public interface QuestionFormatter {
    /**
     * Форматировать вопрос для вывода
     *
     * @param question вопрос
     * @return текст
     */
    String format(Question question);
}

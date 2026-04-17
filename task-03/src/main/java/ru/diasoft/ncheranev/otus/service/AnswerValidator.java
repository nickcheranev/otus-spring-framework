package ru.diasoft.ncheranev.otus.service;

import ru.diasoft.ncheranev.otus.model.Answer;
import ru.diasoft.ncheranev.otus.util.AnswerValidatorException;

import java.util.List;

/**
 * Проверка ответов
 */
public interface AnswerValidator {
    boolean validate(List<Answer> answers, String s) throws AnswerValidatorException;
}

package ru.diasoft.ncheranev.otus.util;

/**
 * Исключение при проверке ответов на вопросы
 */
public class AnswerValidatorException extends RuntimeException {
    public AnswerValidatorException(String message) {
        super(message);
    }
}

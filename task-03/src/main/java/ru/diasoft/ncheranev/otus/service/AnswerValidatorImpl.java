package ru.diasoft.ncheranev.otus.service;

import org.springframework.stereotype.Service;
import ru.diasoft.ncheranev.otus.model.Answer;
import ru.diasoft.ncheranev.otus.util.AnswerValidatorException;

import java.util.List;

/**
 * Реализация проверки ответов
 */
@Service
public class AnswerValidatorImpl implements AnswerValidator {

    @Override
    public boolean validate(List<Answer> answers, String input) throws AnswerValidatorException {
        int n;
        try {
            n = Integer.parseInt(input);
        } catch (RuntimeException re) {
            throw new AnswerValidatorException(re.getMessage() + ". Enter number");
        }

        if (n<1 || n> answers.size()) {
            throw new AnswerValidatorException("Entered number must be between 1 and " + answers.size() + " inclusive");
        }

        return answers.get(--n).getRight();
    }
}

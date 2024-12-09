package ru.diasoft.ncheranev.otus.service;

import org.springframework.stereotype.Service;
import ru.diasoft.ncheranev.otus.model.Answer;
import ru.diasoft.ncheranev.otus.model.Question;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

/**
 * Форматер для вывода в текстовую консоль
 */
@Service
public class TextQuestionFormatter implements QuestionFormatter {

    @Override
    public String format(Question question) {
        return String.format("\nQuestion:\n  %s\nAnswers: (Select the answer number and press Enter)\n  %s",
                question.getText(), formatAnswers(question.getAnswers()));
    }

    private String formatAnswers(List<Answer> answers) {
        AtomicInteger n = new AtomicInteger(1);
        return isNull(answers) ? null : answers.stream()
                .map(answer -> n.getAndIncrement() + ". " + answer.getText())
                .collect(Collectors.joining("\n  "));
    }
}
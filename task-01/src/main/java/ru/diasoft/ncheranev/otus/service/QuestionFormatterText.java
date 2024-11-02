package ru.diasoft.ncheranev.otus.service;

import ru.diasoft.ncheranev.otus.model.Answer;
import ru.diasoft.ncheranev.otus.model.Question;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

/**
 * Форматер для вывода в текстовую консоль
 */
public class QuestionFormatterText implements QuestionFormatter {

    @Override
    public String format(Question question) {
        return String.format("\nQuestion:\n  %s\nAnswers:\n  %s", question.getText(), formatAnswers(question.getAnswers()));
    }

    private String formatAnswers(List<Answer> answers) {
        return isNull(answers) ? null : answers.stream()
                .map(Answer::getText)
                .collect(Collectors.joining("\n  "));
    }
}

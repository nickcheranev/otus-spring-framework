package ru.diasoft.ncheranev.otus.service;

import lombok.RequiredArgsConstructor;
import ru.diasoft.ncheranev.otus.model.Quiz;

/**
 * Демонстратор викторины
 */
@RequiredArgsConstructor
public class QuizShowImpl implements QuizShow {
    private final QuestionFormatter questionFormatter;

    @Override
    public void show(Quiz quiz) {
        quiz.getQuestions()
                .forEach(question -> System.out.println(questionFormatter.format(question)));
    }
}

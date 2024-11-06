package ru.diasoft.ncheranev.otus.service;

import lombok.RequiredArgsConstructor;

/**
 * Реализация проигрывателя викторины
 */
@RequiredArgsConstructor
public class QuizRunnerImpl implements QuizRunner {
    private final QuizLoader quizLoader;
    private final QuizShow quizShow;

    @Override
    public void run() {
        var quiz = quizLoader.load();
        quizShow.show(quiz);
    }
}
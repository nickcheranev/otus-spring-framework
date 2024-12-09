package ru.diasoft.ncheranev.otus.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.diasoft.ncheranev.otus.model.Quiz;

/**
 * Реализация проигрывателя викторины
 */
@Service
@RequiredArgsConstructor
public class QuizRunnerImpl implements QuizRunner {
    private final QuestionDao questionDao;
    private final QuizShow quizShow;
    private final UserInterface userInterface;

    @Override
    public void run() {
        userInterface.outLine("Enter your name:");
        var name = userInterface.getName();
        userInterface.outLine("Hello, " + name + "! Answer our questions");

        var questions = questionDao.read();

        quizShow.show(new Quiz()
                .setName(name)
                .setQuestions(questions));
    }
}
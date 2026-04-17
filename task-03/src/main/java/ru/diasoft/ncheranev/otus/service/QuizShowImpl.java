package ru.diasoft.ncheranev.otus.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.diasoft.ncheranev.otus.model.Quiz;
import ru.diasoft.ncheranev.otus.util.AnswerValidatorException;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Демонстратор викторины
 */
@Service
@RequiredArgsConstructor
public class QuizShowImpl implements QuizShow {
    private final QuestionFormatter questionFormatter;
    private final AnswerValidator answerValidator;
    private final UserInterface userInterface;

    @Override
    public void show(Quiz quiz) {
        var balls = new AtomicInteger(0);
        quiz.getQuestions()
                .forEach(question -> {
                    userInterface.outLine(questionFormatter.format(question));
                    var userData = userInterface.getLine();

                    try {
                        var right = answerValidator.validate(question.getAnswers(), userData);
                        if (right) {
                            balls.getAndIncrement();
                        }
                    } catch (AnswerValidatorException e) {
                        userInterface.outLine(e.getMessage());
                    }
                });

        userInterface.outLine("Your score: " + balls.get() + ". Goodbye, " + quiz.getName());
    }
}

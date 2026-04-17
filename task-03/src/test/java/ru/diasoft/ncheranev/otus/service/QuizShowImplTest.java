package ru.diasoft.ncheranev.otus.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.diasoft.ncheranev.otus.model.Answer;
import ru.diasoft.ncheranev.otus.model.Question;
import ru.diasoft.ncheranev.otus.model.Quiz;
import ru.diasoft.ncheranev.otus.util.AnswerValidatorException;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("Класс QuizShowImpl")
@ExtendWith(MockitoExtension.class)
class QuizShowImplTest {
    @Mock
    private QuestionFormatter questionFormatter;
    @Mock
    private AnswerValidator answerValidator;
    @Mock
    private UserInterface userInterface;
    @InjectMocks
    private QuizShowImpl tester;

    @DisplayName("Правильные ответы")
    @Test
    void shouldShowScoreOneBall() {
        var answers = List.of(new Answer()
                .setText("answer")
                .setRight(true));
        var question = new Question()
                .setText("question")
                .setAnswers(answers);
        Quiz quiz = new Quiz()
                .setName("User")
                .setQuestions(List.of(question));

        when(questionFormatter.format(question)).thenReturn("formattedQuestion");
        when(userInterface.getLine()).thenReturn("1");
        when(answerValidator.validate(answers, "1")).thenReturn(true);

        tester.show(quiz);

        verify(userInterface).outLine("formattedQuestion");
        verify(userInterface).outLine("Your score: 1. Goodbye, User");
    }

    @DisplayName("Неправильные ответы")
    @Test
    void shouldShowScoreZeroBall() {
        var answers = List.of(new Answer()
                .setText("answer")
                .setRight(false));
        var question = new Question()
                .setText("question")
                .setAnswers(answers);
        Quiz quiz = new Quiz()
                .setName("User")
                .setQuestions(List.of(question));

        when(questionFormatter.format(question)).thenReturn("formattedQuestion");
        when(userInterface.getLine()).thenReturn("1");
        when(answerValidator.validate(answers, "1")).thenReturn(false);

        tester.show(quiz);

        verify(userInterface).outLine("formattedQuestion");
        verify(userInterface).outLine("Your score: 0. Goodbye, User");
    }

    @DisplayName("Ошибка при валидации ответа")
    @Test
    void shouldThrowAnswerValidatorException() {
        var answers = List.of(new Answer()
                .setText("answer")
                .setRight(false));
        var question = new Question()
                .setText("question")
                .setAnswers(answers);
        var quiz = new Quiz()
                .setName("User")
                .setQuestions(List.of(question));

        when(questionFormatter.format(question)).thenReturn("formattedQuestion");
        when(userInterface.getLine()).thenReturn("1");
        when(answerValidator.validate(answers, "1")).thenThrow(new AnswerValidatorException("Ошибка"));

        tester.show(quiz);

        verify(userInterface).outLine("formattedQuestion");
        verify(userInterface).outLine("Ошибка");
        verify(userInterface).outLine("Your score: 0. Goodbye, User");
    }
}
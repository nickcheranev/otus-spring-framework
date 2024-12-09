package ru.diasoft.ncheranev.otus.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.diasoft.ncheranev.otus.model.Question;
import ru.diasoft.ncheranev.otus.model.Quiz;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("Класс QuizRunnerImpl")
@ExtendWith(MockitoExtension.class)
class QuizRunnerImplTest {
    @Mock
    private QuestionDao questionDao;
    @Mock
    private QuizShow quizShow;
    @Mock
    private UserInterface userInterface;
    @InjectMocks
    private QuizRunnerImpl tester;


    @Test
    @DisplayName("Должен выполнить запуск викторины без ошибок")
    void run() {
        when(userInterface.getName()).thenReturn("User");
        var questions = List.of(new Question());
        when(questionDao.read()).thenReturn(questions);
        var quiz = new Quiz().setName("User").setQuestions(questions);

        tester.run();

        verify(userInterface).outLine("Enter your name:");
        verify(userInterface).outLine("Hello, User! Answer our questions");
        verify(quizShow).show(quiz);
    }
}
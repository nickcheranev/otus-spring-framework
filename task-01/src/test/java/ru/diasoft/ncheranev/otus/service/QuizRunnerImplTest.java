package ru.diasoft.ncheranev.otus.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.diasoft.ncheranev.otus.model.Quiz;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class QuizRunnerImplTest {
    @Mock
    private QuizLoader quizLoader;
    @Mock
    private QuizShow quizShow;
    @InjectMocks
    private QuizRunnerImpl tester;

    @Test
    void runTest() {
        // given
        Quiz quiz = new Quiz();
        when(quizLoader.load()).thenReturn(quiz);

        // when
        tester.run();

        // then
        verify(quizLoader).load();
        verify(quizShow).show(quiz);
    }
}
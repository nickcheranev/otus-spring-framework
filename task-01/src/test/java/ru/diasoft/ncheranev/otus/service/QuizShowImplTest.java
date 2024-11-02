package ru.diasoft.ncheranev.otus.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.diasoft.ncheranev.otus.model.Question;
import ru.diasoft.ncheranev.otus.model.Quiz;

import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class QuizShowImplTest {
    @Mock
    private QuestionFormatter questionFormatter;
    @InjectMocks
    private QuizShowImpl tester;

    @Test
    void showTest() {
        // given
        var question1 = new Question();
        var question2 = new Question();
        var quiz = new Quiz().setQuestions(List.of(question1, question2));

        // when
        tester.show(quiz);

        // then
        verify(questionFormatter, times(2)).format(question1);
    }
}
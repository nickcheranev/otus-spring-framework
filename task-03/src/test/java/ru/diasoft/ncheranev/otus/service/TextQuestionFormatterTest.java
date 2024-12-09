package ru.diasoft.ncheranev.otus.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.diasoft.ncheranev.otus.model.Answer;
import ru.diasoft.ncheranev.otus.model.Question;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Класс TextQuestionFormatter")
class TextQuestionFormatterTest {

    @Test
    @DisplayName("Должен преобразовать объект вопроса в форматированный текст для вывода")
    void shouldFormatQuestionToText() {
        var question = new Question()
                .setText("Вопрос")
                .setAnswers(List.of(new Answer()
                        .setText("Ответ")));

        var formatted = new TextQuestionFormatter().format(question);

        assertThat(formatted).isEqualTo(
                """
                        
                        Question:
                          Вопрос
                        Answers: (Select the answer number and press Enter)
                          1. Ответ""");
    }

    @Test
    @DisplayName("Если вопросы == null, то не должно быть исключения")
    void whenNullAnswersThenNotShouldException() {
        var question = new Question()
                .setText("Вопрос");

        var formatted = new TextQuestionFormatter().format(question);

        assertThat(formatted).isEqualTo(
                """
                        
                        Question:
                          Вопрос
                        Answers: (Select the answer number and press Enter)
                          null""");
    }
}
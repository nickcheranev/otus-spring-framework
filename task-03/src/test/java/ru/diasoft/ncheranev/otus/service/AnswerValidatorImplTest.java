package ru.diasoft.ncheranev.otus.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.diasoft.ncheranev.otus.model.Answer;
import ru.diasoft.ncheranev.otus.util.AnswerValidatorException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Класс AnswerValidatorImpl")
class AnswerValidatorImplTest {

    @Test
    @DisplayName("Должен вернуть ответ \"Правильно\"")
    void validate_rightAnswer() {
        var sut = new AnswerValidatorImpl();
        var answers = List.of(new Answer().setRight(true), new Answer().setRight(false));

        assertThat(sut.validate(answers, "1")).isTrue();
    }

    @Test
    @DisplayName("Должен вернуть ответ \"Неправильно\"")
    void validate_wrongAnswer() {
        var sut = new AnswerValidatorImpl();
        var answers = List.of(new Answer().setRight(true), new Answer().setRight(false));

        assertThat(sut.validate(answers, "2")).isFalse();
    }

    @Test
    @DisplayName("Должен выбросить исключение AnswerValidatorException")
    void validate_0_illegalRange() {
        var sut = new AnswerValidatorImpl();
        var answers = List.of(new Answer().setRight(true), new Answer().setRight(false));

        assertThatThrownBy(() -> sut.validate(answers, "0"))
                .isInstanceOf(AnswerValidatorException.class)
                        .hasMessage("Entered number must be between 1 and 2 inclusive");
    }

    @Test
    @DisplayName("Должен выбросить исключение AnswerValidatorException")
    void validate_3_illegalRange() {
        var sut = new AnswerValidatorImpl();
        var answers = List.of(new Answer().setRight(true), new Answer().setRight(false));

        assertThatThrownBy(() -> sut.validate(answers, "3"))
                .isInstanceOf(AnswerValidatorException.class)
                .hasMessage("Entered number must be between 1 and 2 inclusive");
    }

    @Test
    @DisplayName("Должен выбросить исключение AnswerValidatorException")
    void validate_illegalInput() {
        var sut = new AnswerValidatorImpl();
        var answers = List.of(new Answer().setRight(true), new Answer().setRight(false));

        assertThatThrownBy(() -> sut.validate(answers, "A"))
                .isInstanceOf(AnswerValidatorException.class)
                .hasMessage("For input string: \"A\". Enter number");
    }
}
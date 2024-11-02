package ru.diasoft.ncheranev.otus.service;

import org.junit.jupiter.api.Test;
import ru.diasoft.ncheranev.otus.model.Answer;
import ru.diasoft.ncheranev.otus.model.Question;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class QuestionFormatterTextTest {

    @Test
    void format() {
        // given
        QuestionFormatterText tester = new QuestionFormatterText();
        Question question = new Question()
                .setText("question")
                .setAnswers(List.of(
                        new Answer().setText("answer1"),
                        new Answer().setText("answer2")))
        ;

        // when
        var result = tester.format(question);

        // then
        assertThat(result).isEqualTo("\nQuestion:\n  question\nAnswers:\n  answer1\n  answer2");
    }
}
package ru.diasoft.ncheranev.otus.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
class QuizLoaderFromResourceTest {

    @Test
    void load() {
        // given
        var loaderStub = new QuizLoaderFromResource("data.csv");

        // when
        var result = loaderStub.load();

        // then
        assertThat(result.getQuestions().size()).isEqualTo(5);
    }
}
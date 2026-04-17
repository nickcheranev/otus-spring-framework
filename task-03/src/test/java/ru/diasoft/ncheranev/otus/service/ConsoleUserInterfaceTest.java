package ru.diasoft.ncheranev.otus.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;

@DisplayName("Класс ConsoleUserInterface")
class ConsoleUserInterfaceTest {

    @Test
    @DisplayName("Должен вывести сообщение пользователю в консоль без сбоев")
    void outLineSmokeTest() {
        assertThatNoException().isThrownBy(() -> new ConsoleUserInterface().outLine("text"));
    }
}
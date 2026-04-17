package ru.diasoft.ncheranev.otus.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.diasoft.ncheranev.otus.model.Answer;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Класс TextToAnswer")
class TextToAnswerTest {

    @Test
    @DisplayName("Должен конвертировать текст в объект")
    void convertToRead() {
        TextToAnswer tester = new TextToAnswer();

        var obj = tester.convertToRead("текст.true");

        assertThat(obj).isEqualTo(new Answer().setText("текст").setRight(true));
    }

    @Test
    @DisplayName("Должен конвертировать объект в текст")
    void convertToWrite() {
        TextToAnswer tester = new TextToAnswer();
        Answer answer = new Answer().setText("текст").setRight(true);

        var s =  tester.convertToWrite(answer);
        assertThat(s).isEqualTo("текст.true");
    }
}
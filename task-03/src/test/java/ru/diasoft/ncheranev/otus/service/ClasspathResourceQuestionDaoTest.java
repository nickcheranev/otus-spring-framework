package ru.diasoft.ncheranev.otus.service;

import com.opencsv.bean.StatefulBeanToCsvBuilder;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.diasoft.ncheranev.otus.model.Answer;
import ru.diasoft.ncheranev.otus.model.Question;

import java.io.FileWriter;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Класс ClasspathResourceQuestionDao")
class ClasspathResourceQuestionDaoTest {

    @DisplayName("Не unit test. Использовать для генерации data.csv")
    @Disabled
    @Test
    void write() {
        ClasspathResourceQuestionDao sut = new ClasspathResourceQuestionDao(null);
        var questions = List.of(
                new Question().setText("1 + 1")
                        .setAnswers(List.of(
                                new Answer().setText("2").setRight(true),
                                new Answer().setText("1").setRight(false),
                                new Answer().setText("3").setRight(false)
                        )),
                new Question().setText("2 * 2")
                        .setAnswers(List.of(
                                new Answer().setText("5").setRight(false),
                                new Answer().setText("4").setRight(true)
                        )),
                new Question().setText("2 / 2")
                        .setAnswers(List.of(
                                new Answer().setText("3").setRight(false),
                                new Answer().setText("1").setRight(true)
                        )),
                new Question().setText("333 / 3")
                        .setAnswers(List.of(
                                new Answer().setText("1111").setRight(false),
                                new Answer().setText("111").setRight(true)
                        )),
                new Question().setText("7 * 8")
                        .setAnswers(List.of(
                                new Answer().setText("57").setRight(false),
                                new Answer().setText("56").setRight(true)
                        ))
        );

        write(questions);
    }

    private void write(List<Question> questions) {
        FileWriter writer;
        try {
            writer = new FileWriter("data.csv");
            var beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
            beanToCsv.write(questions);
            writer.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Успешное чтение вопросов из файла")
    void shouldReadSuccess() {
        ClasspathResourceQuestionDao sut = new ClasspathResourceQuestionDao("data.csv");
        List<Question> questions = sut.read();
        assertThat(questions).hasSize(5);
    }

    @Test
    @DisplayName("Ошибка при чтении вопросов из файла")
    void readShouldThrowException() {
        ClasspathResourceQuestionDao sut = new ClasspathResourceQuestionDao("wrongpath");

        assertThatThrownBy(sut::read).isInstanceOf(RuntimeException.class);
    }
}
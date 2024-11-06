package ru.diasoft.ncheranev.otus.service;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.DefaultResourceLoader;
import ru.diasoft.ncheranev.otus.model.Answer;
import ru.diasoft.ncheranev.otus.model.Question;
import ru.diasoft.ncheranev.otus.model.Quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/**
 * Загрузчик викторины из ресурсов приложения
 */
@RequiredArgsConstructor
public class QuizLoaderFromResource implements QuizLoader {
    private final String fileName;

    @Override
    public Quiz load() {
        var resourceLoader = new DefaultResourceLoader();
        var resource = resourceLoader.getResource("classpath:" + fileName);
        try {
            var reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            return fromLines(reader.lines().toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Quiz fromLines(List<String> lines) {
        return new Quiz()
                .setQuestions(lines.stream().map(this::toQuestion).toList());
    }

    private Question toQuestion(String line) {
        var parts = Arrays.stream(line.split(";")).toList() ;
        return new Question()
                .setText(parts.get(0))
                .setAnswers(parts.subList(1, parts.size()).stream().map(this::toAnswer).toList());
    }

    private Answer toAnswer(String text) {
        return new Answer().setText(text);
    }
}

package ru.diasoft.ncheranev.otus.model;

import com.opencsv.bean.CsvBindAndSplitByName;
import com.opencsv.bean.CsvBindByName;
import lombok.Data;
import lombok.experimental.Accessors;
import ru.diasoft.ncheranev.otus.util.TextToAnswer;

import java.util.List;

/**
 * Вопрос
 */
@Data
@Accessors(chain = true)
public class Question {
    /**
     * Текст вопроса
     */
    @CsvBindByName(required = true)
    private String text;
    /**
     * Список ответов
     */
    @CsvBindAndSplitByName(elementType = Answer.class, splitOn = "\\ ", converter = TextToAnswer.class)
    private List<Answer> answers;
}

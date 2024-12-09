package ru.diasoft.ncheranev.otus.model;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Ответ
 */
@Data
@Accessors(chain = true)
public class Answer {
    /**
     * Текст ответа
     */
    @CsvBindByName(required = true)
    private String text;
    /**
     * Правильность ответа
     */
    @CsvBindByName(required = true)
    private Boolean right;
}

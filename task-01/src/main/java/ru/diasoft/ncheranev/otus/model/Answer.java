package ru.diasoft.ncheranev.otus.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Ответ
 */
@Data
@Accessors(chain = true)
public class Answer {
    private String text;
}

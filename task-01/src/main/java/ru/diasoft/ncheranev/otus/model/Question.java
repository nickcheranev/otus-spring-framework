package ru.diasoft.ncheranev.otus.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Вопрос
 */
@Data
@Accessors(chain = true)
public class Question {
    private String text;
    private List<Answer> answers;
}

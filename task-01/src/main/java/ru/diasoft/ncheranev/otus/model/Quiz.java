package ru.diasoft.ncheranev.otus.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Викторина
 */
@Data
@Accessors(chain = true)
public class Quiz {
    private List<Question> questions;
}

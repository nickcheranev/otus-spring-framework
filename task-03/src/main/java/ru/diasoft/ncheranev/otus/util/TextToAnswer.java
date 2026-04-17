package ru.diasoft.ncheranev.otus.util;

import com.opencsv.bean.AbstractCsvConverter;
import ru.diasoft.ncheranev.otus.model.Answer;

/**
 * CSV конвертер вопросов
 */
public class TextToAnswer extends AbstractCsvConverter {
    @Override
    public Object convertToRead(String value) {
        Answer a = new Answer();
        String[] split = value.split("\\.", 2);
        a.setText(split[0]);
        a.setRight(Boolean.parseBoolean(split[1]));
        return a;
    }

    @Override
    public String convertToWrite(Object value) {
        Answer a = (Answer) value;
        return String.format("%s.%s", a.getText(), a.getRight());
    }
}

package ru.diasoft.ncheranev.otus.service;

import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import ru.diasoft.ncheranev.otus.model.Question;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * DAO (загрузка) вопросов викторины из ресурсов приложения
 */
@Service
@RequiredArgsConstructor
@PropertySource("classpath:application.yml")
public class ClasspathResourceQuestionDao implements QuestionDao {
    @Value("${fileName}")
    private final String fileName;

    /**
     * Чтение вопросов викторины из файла ресурсов
     *
     * @return список вопросов
     */
    @Override
    public List<Question> read() {
        try {
            var classPathResource = new ClassPathResource(fileName);
            var streamReader = new InputStreamReader(classPathResource.getInputStream(), StandardCharsets.UTF_8);
            return new CsvToBeanBuilder<Question>(streamReader)
                    .withType(Question.class)
                    .build()
                    .parse();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

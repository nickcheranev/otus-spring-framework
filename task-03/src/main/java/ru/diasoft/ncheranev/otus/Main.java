package ru.diasoft.ncheranev.otus;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.diasoft.ncheranev.otus.service.QuizRunner;

@ComponentScan
public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Main.class);

        var quizRunner = context.getBean(QuizRunner.class);
        quizRunner.run();

        context.close();
    }
}
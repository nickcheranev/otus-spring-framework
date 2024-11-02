package ru.diasoft.ncheranev.otus;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.diasoft.ncheranev.otus.service.QuizRunner;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");

        var quizRunner = context.getBean(QuizRunner.class);
        quizRunner.run();

        context.close();
    }
}
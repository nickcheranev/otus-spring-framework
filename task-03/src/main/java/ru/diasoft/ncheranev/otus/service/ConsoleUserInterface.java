package ru.diasoft.ncheranev.otus.service;

import org.springframework.stereotype.Service;

import java.util.Scanner;

/**
 * Реализация консольного интерфейса пользователя
 */
@Service
public class ConsoleUserInterface implements UserInterface {

    private static final Scanner CONSOLE_INPUT = new Scanner(System.in);

    @Override
    public String getLine() {
        return CONSOLE_INPUT.nextLine();
    }

    @Override
    public String getName() {
        return CONSOLE_INPUT.nextLine();
    }

    @Override
    public void outLine(String line) {
        System.out.println(line);
    }
}

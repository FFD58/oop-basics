package ru.fafurin.lesson4;

import ru.fafurin.lesson4.task4.GreaterOfThreeNumbersSearcher;
import ru.fafurin.lesson4.task5.StringCreator;
import ru.fafurin.lesson4.task6.MinOfTwoNumbersSearcher;
import ru.fafurin.lesson4.task6.Multitasker;
import ru.fafurin.lesson4.task6.ReverseStringPrinter;
import ru.fafurin.lesson4.task6.SumOfArrElmntsSearcher;

import java.util.Scanner;

// Урок 4. Ключевое слово this. Экземпляры класса
public class Main {
    public static void main(String[] args) {
        // 1. Зачем нужно ключевое слово this?

        // Ответ. Ключевое слово this это указатель на область оперативной памяти, где хранится экземпляр класса.
        // this необходимо для доступа к полям и методам конкретного экземпляра класса

        // 2. Можно ли обратиться к полям класса, не используя ключевое слово this? Как?
        // Ответ. Можно. Java автоматически добавляет ключевое слово this.
        // Но если в атрибутах метода будет переменная с таким же названием, что и поле класса,
        // то для того, чтобы уточнить с чем мы работаем, this нужно обязательно указать.

        // 3. Когда стоит использовать слово this?
        // Ответ. Ключевое слово this нужно использовать внутри метода, чтобы обратиться к свойству или методу конкретного объекта класса

        // 4. Создайте класс, который находит наибольшее из трех чисел. Ко всем переменным обращаться можно ТОЛЬКО используя this.

        GreaterOfThreeNumbersSearcher searcher = new GreaterOfThreeNumbersSearcher((int)Math.pow(3,7), (int)Math.pow(6,3), (int)Math.pow(2,10));
        searcher.compare();
        System.out.println(searcher.returnResult());

        // 5. Создайте класс, который делает из трех маленьких строк одну большую. Ко всем переменным обращаться можно ТОЛЬКО используя this.
        StringCreator stringCreator = new StringCreator("Java", "это", "мощь!");
        stringCreator.concatStrings();
        System.out.println(stringCreator.returnResult());

        // 6. Создайте класс, который принимает аргументом, какую задачу он должен решить: “найти минимум из 2 чисел”,
        // “найти сумму элементов массива”, “вывести строку с конца”. На выходе этот класс пишет в консоль Java-код,
        // который решает заданную задачу. Ко всем переменным обращаться можно ТОЛЬКО используя this.

        Scanner sc = new Scanner(System.in);
        MinOfTwoNumbersSearcher minOfTwoNumbersSearcher = new MinOfTwoNumbersSearcher();
        SumOfArrElmntsSearcher sumOfArrElmntsSearcher = new SumOfArrElmntsSearcher();
        ReverseStringPrinter reverseStringPrinter = new ReverseStringPrinter();

        Multitasker multitasker = new Multitasker(sc, minOfTwoNumbersSearcher, sumOfArrElmntsSearcher, reverseStringPrinter);
        System.out.println(multitasker);
        System.out.println("Введите задачу, которую необходимо решить: ");
        try {
            String task = sc.nextLine();
            multitasker.selectTask(task);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}

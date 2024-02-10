package ru.fafurin.lesson4.task6;

import java.util.Scanner;

public class Multitasker {
    private final Scanner scanner;
    private final MinOfTwoNumbersSearcher minOfTwoNumbersSearcher;
    private final SumOfArrElmntsSearcher sumOfArrElmntsSearcher;
    private final ReverseStringPrinter reverseStringPrinter;

    public Multitasker(Scanner scanner, MinOfTwoNumbersSearcher minOfTwoNumbersSearcher, SumOfArrElmntsSearcher sumOfArrElmntsSearcher, ReverseStringPrinter reverseStringPrinter) {
        this.scanner = scanner;
        this.minOfTwoNumbersSearcher = minOfTwoNumbersSearcher;
        this.sumOfArrElmntsSearcher = sumOfArrElmntsSearcher;
        this.reverseStringPrinter = reverseStringPrinter;
    }

    @Override
    public String toString() {
        return
                "Добро пожаловать в \"Multitasker v 0.1\" \n" +
                        "Multitasker может: \n" +
                        "- найти минимум из 2 чисел \n" +
                        "- найти сумму элементов массива \n" +
                        "- вывести строку с конца";
    }

    public void selectTask(String task) {
        switch (task) {
            case "найти минимум из 2 чисел" -> this.startMinOfTwoNumbersSearcher();
            case "найти сумму элементов массива" -> this.startSumOfArrElmntsSearcher();
            case "вывести строку с конца" -> this.startReverseStringPrinter();
            default -> System.out.println("Введите корректную задачу");
        }
    }

    private void startMinOfTwoNumbersSearcher() {
        System.out.println("Введите два целых числа для сравнения: ");
        int x = this.scanner.nextInt();
        int y = this.scanner.nextInt();
        this.minOfTwoNumbersSearcher.setData(x, y);
        System.out.printf("Меньшее число: %d", minOfTwoNumbersSearcher.getResult());
    }

    private void startSumOfArrElmntsSearcher() {
        System.out.println("Введите количество целых чисел: ");
        int arrLength = this.scanner.nextInt();
        int[] arr = new int[arrLength];
        System.out.println("Введите целые числа: ");
        for (int x = 0; x < arrLength; x++) {
            arr[x] = this.scanner.nextInt();
        }
        this.sumOfArrElmntsSearcher.setData(arr);
        System.out.printf("Сумма введенных чисел равна: %d", sumOfArrElmntsSearcher.getResult());
    }

    private void startReverseStringPrinter() {
        System.out.println("Введите строку: ");
        String str = this.scanner.nextLine();
        this.reverseStringPrinter.setData(str);
        reverseStringPrinter.printResult();
    }

}

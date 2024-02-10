package ru.fafurin.lesson5;

import ru.fafurin.lesson5.task10.TicTacToeStringBuilder;
import ru.fafurin.lesson5.task11.FileInformation;
import ru.fafurin.lesson5.task8.CurrencyLoader;
import ru.fafurin.lesson5.task9.BreakingBadQuote;

import java.util.Scanner;

// Урок 5. StringBuilder, обработка строк

public class Main {
    public static void main(String[] args) {
        // 1. Пользователь вводит стихотворение из четырёх строк.
        // Соберите их в одну переменную, между каждой строкой вставьте символ переноса строки: «\n»

        Scanner sc = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        for (int x = 0; x < 4; x++) {
            stringBuilder.append(sc.nextLine()).append("\n");
        }
        System.out.println(stringBuilder);

        //2. Пользователь вводит три слова, соберите из них строку, где слова будут в обратном порядке
        for (int x = 0; x < 3; x++) {
            stringBuilder.insert(0, sc.next() + " ");
        }
        System.out.println(stringBuilder);

        //3. Пользователь вводит слово. Добавьте к нему в начало «вы говорите:» … слово пользователя. И в конец: «.. и что?»
        String word = sc.next();
        stringBuilder.append(word);
        stringBuilder.insert(0, "Вы говорите: ");
        stringBuilder.insert(stringBuilder.length(), ", и что?");
        System.out.println(stringBuilder);

        //4. Пользователь вводит пять слов, соберите из них целую строку, между каждым словом вставьте «, и»
        for (int x = 0; x < 5; x++) {
            stringBuilder.append(sc.next()).append(", и ");
        }
        System.out.println(stringBuilder.delete(stringBuilder.length() - 4, stringBuilder.length()));

        //5. Пользователь вводит предложение их двух слов (считайте в одну переменную String phrase).
        // Вставьте между этими словами «так сказать» используя StringBuilder.insert. Было: «Учу Java». Станет: «Учу, так сказать, Java»
        System.out.println("Please, enter two words...");
        String phrase = sc.nextLine();
        stringBuilder.append(phrase);
        stringBuilder.insert(stringBuilder.indexOf(" "), ", так сказать, ");
        System.out.println(stringBuilder);

        //6. Пользователь вводит число, любое. 237, например. Выведите: 237 программистов, окончание должно зависеть от числа. 1 программист, 2 программиста, и так далее
        System.out.println("Please, enter a number...");
        int number = sc.nextInt();
        stringBuilder.append(number);
        switch (stringBuilder.charAt(stringBuilder.length() - 1)) {
            case 1 -> System.out.println(stringBuilder.append(" программист"));
            case 2, 3, 4 -> System.out.println(stringBuilder.append(" программиста"));
            default -> System.out.println(stringBuilder.append(" программистов"));
        }

        //7. Пользователь вводит предложение, удалите все пробелы из него
        System.out.println("Please, enter a sentence...");
        String str = sc.nextLine();
        if (!str.contains(" ")) {
            System.out.println("Please, enter a sentence...");
            str = sc.nextLine();
        } else {
            stringBuilder.append(str);
            int index = 0;
            while (index != -1) {
                stringBuilder.deleteCharAt(stringBuilder.indexOf(" "));
                index = stringBuilder.indexOf(" ");
            }
            System.out.println(stringBuilder);
        }

        //8. Вернитесь к программе, которая запрашивает курс валют.
        // Напишите генератор даты для запроса к апи, на основе даты, введенной пользователем. Используйте StringBuilder.
        CurrencyLoader loader = new CurrencyLoader();
        loader.generateQuery("15.03.2022").getDollarQuotes();

        //9. Скачайте цитату из breaking bad и замените все плохие слова звёздочками
        BreakingBadQuote breakingBadQuote = new BreakingBadQuote();

        //10. Напишите крестики-нолики, используя StringBuilder
        // Непонятное задание. Зачем использовать StringBuilder?
        // Пришлось повыёживаться
        TicTacToeStringBuilder game = new TicTacToeStringBuilder();

        //11. Пусть пользователь вводит поля класса FileInformation, но в одну строку;
        // формат придумайте сами. Считайте ввод пользователя и из него создайте экземпляр класса.

        System.out.println("Enter path, file name and file size...");
        Scanner scanner = new Scanner(System.in);
        try {
            FileInformation fileInformation = FileInformation.createNewFileInformationObject(scanner.nextLine());
            System.out.println(fileInformation);
        } catch (RuntimeException e) {
            System.err.println("You entered not valid data!");
        }
    }
}

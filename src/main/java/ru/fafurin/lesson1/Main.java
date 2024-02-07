package ru.fafurin.lesson1;

import ru.fafurin.lesson1.task1.Faculty;
import ru.fafurin.lesson1.task1.University;
import ru.fafurin.lesson1.task2.Company;
import ru.fafurin.lesson1.task2.MacOS;
import ru.fafurin.lesson1.task1.Department;
import ru.fafurin.lesson1.task2.OS;
import ru.fafurin.lesson1.task2.Windows;

import java.io.File;
import java.util.Arrays;

// Урок 1. Введение в классы. Поля класса. Процедурное программирование, ООП, организация кода

public class Main {
    public static void main(String[] args) {

        // 1. Создайте классы с полями для описания структуры университета. Комбинируйте! Пусть одни классы будут полями других
        University pgu = new University(
                "Penza State University",
                "Penza, Krasnaya, 40",
                new Faculty[]{
                        new Faculty("Physics and mathematics",
                                new Department[]{
                                        new Department("Physics", 14, 35, 1300),
                                        new Department("Mathematics", 16, 37, 1340),
                                }
                        ),
                        new Faculty("Medical",
                                new Department[]{
                                        new Department("Dentistry", 7, 12, 2300),
                                        new Department("Surgery", 13, 27, 2340),
                                }
                        ),
                }
        );
        System.out.println(pgu);

        // 2. Создайте классы для описания операционных систем
        OS macOS14 = new MacOS("macOS",
                new Company("Apple", "Information technology", "April 1, 1976", 161_000),
                "December 19, 2023",  "14.03");
        OS windows95 = new Windows("Windows",
                new Company("Microsoft", "Information technology", "1975", 238_000),
                "November 26, 1997",  "OEM Service Release 2.5");

        System.out.println(macOS14);
        System.out.println(windows95);

        // 3. Создайте классы для описания языков программирования (типизации, версии, массив ключевых слов..)

        // 4. Сохраните информацию о всех файлах в заданной директории в массив FileInformation
        File dir = new File("temp");
        File[] files = dir.listFiles();

        FileInformation[] fileInfo = new FileInformation[files.length];
        for (int x = 0; x < files.length; x++) {
            fileInfo[x] = new FileInformation(files[x].getAbsolutePath(), files[x].getName(), files[x].length());
        }

        System.out.println(Arrays.toString(fileInfo));

        // 5. Сохраните снимок дня NASA в свой созданный класс
        LoaderFromNasaApi loader = new LoaderFromNasaApi();
        loader.getImagesByDates("2001-05-01", "2001-05-31");


        // 6. Сделайте класс для цитаты из breaking bad: цитата и автор. Сохраните в массив таких классов 10 цитат.
        BreakingBadQuote[] breakingBadQuotes = new BreakingBadQuote[10];
        for (int x = 0; x < breakingBadQuotes.length; x++) {
            breakingBadQuotes[x] = new BreakingBadQuote();
        }

        for (BreakingBadQuote breakingBadQuote : breakingBadQuotes) {
            System.out.println(breakingBadQuote);
        }
    }
}

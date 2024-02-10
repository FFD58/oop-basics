package ru.fafurin.lesson7;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

// Урок 7. Параметры методов.
public class Main {
    public static void main(String[] args) {
        // 1. Реализуйте метод, который находит из трех чисел то, которое делится на 2 остальных; или возвращает -1, если такого нет
        System.out.println(foundDivisible(111, 333, 3));

        // 2. Реализуйте метод, который из двух массивов строк собирает третий, в котором чередуются элементы первых двух
        mergeStringArrays(new String[]{"Java", "PHP", "JavaScript", "Python"}, new String[]{"Backend", "Web", "Frontend"});

        // 3. Возьмите любую программу, которую вы писали до этого.. какая сердцу ближе.
        // Отрефакторите ее (улучшите читабельность кода) - путем разбиения крупных частей на методы поменьше. Стало лучше? (надеюсь, да)
        // 4. Отрефакторите(улучшите читабельность) кода вашей реализации анализа курса валют.
        // Добавил возможность получения котировок других валют (евро, британский фунт, немецкая марка) по заданной дате в формате Date

        CurrencyLoader currencyLoader = new CurrencyLoader();
        Date today = new Date();
        currencyLoader.writeCurrencyQuotesByDateToFile(Currency.GBP.getTitle(), today, Currency.GBP);

        // 5. Реализуйте метод, который возвращает случайную цитату Уолтера Уайта.

        BreakingBadQuote breakingBadQuote = new BreakingBadQuote();
        breakingBadQuote.printWalterWhiteQuote();

        // 6. Реализуйте метод, который выводит explanation сегодняшнего снимка дня NASA

        LoaderFromNasaApi loader = new LoaderFromNasaApi();
        System.out.println(loader.returnTodayExplanation());

        // 7. Реализуйте метод, который возвращает explanation снимка дня NASA, в качестве параметра принимайте LocalDate - дату, на которую нужно брать снимок
        Calendar calendar1 = new GregorianCalendar(2017, Calendar.JANUARY , 1);
        Calendar calendar2 = new GregorianCalendar(2017, Calendar.JANUARY , 31);
        Date date1 = calendar1.getTime();
        Date date2 = calendar2.getTime();
        System.out.println(loader.returnExplanationByDate(date1));

        // 8. Реализуйте метод, который принимает два LocalDate, и сохраняет все снимки дня NASA в указанный промежуток
        loader.getFileFromString(loader.returnNASAImagesData(date1, date2));
    }

    // 1. Реализуйте метод, который находит из трех чисел то, которое делится на 2 остальных; или возвращает -1, если такого нет
    private static int foundDivisible(int x, int y, int z) {
        int result;
        if (x % y == 0 && x % z == 0) {
            result = x;
        } else if (y % x == 0 && y % z == 0) {
            result = y;
        } else if (z % x == 0 && z % y == 0) {
            result = z;
        } else result = -1;
        return result;
    }

    // 2. Реализуйте метод, который из двух массивов строк собирает третий, в котором чередуются элементы первых двух
    private static void mergeStringArrays(String[] arr1, String[] arr2) {
        String[] mergedArr = new String[arr1.length + arr2.length];
        int maxLen = Math.max(arr1.length, arr2.length);
        int j = 0;
        for (int i = 0; i < maxLen; i++) {
            if (i < arr1.length) mergedArr[j++] = arr1[i];
            if (i < arr2.length) mergedArr[j++] = arr2[i];
        }
        System.out.println(Arrays.toString(mergedArr));
    }

}

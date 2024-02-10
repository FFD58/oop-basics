package ru.fafurin.lesson6;

import java.io.IOException;
import java.util.Scanner;

// Урок 6. Операторы Continue, break.

public class Main {
    public static void main(String[] args) throws IOException {
//        // 1. Пользователь вводит 10 слов в массив. Найдите первое слово, в котором есть две гласные буквы подряд
        Scanner sc = new Scanner(System.in);
        String[] strArr = new String[10];
        String vowels = "аеёиоуыэюя";
        String result = "";
        boolean isContinue = true;
        for (int x = 0; x < strArr.length; x++) {
            if (!isContinue) break;
            strArr[x] = sc.next();
            for (int y = 0; y < strArr[x].length() - 2; y++) {
                if (vowels.contains(strArr[x].substring(y, y + 1)) &&
                        vowels.contains(strArr[x].substring(y + 1, y + 2))) {
                    isContinue = false;
                    result = strArr[x];
                    break;
                }
            }
        }
        System.out.println("Первое слово, в котором есть две гласные буквы подряд: " + result);
//
//        // 2. Пользователь вводит массив чисел. Найдите первое четное число
        System.out.print("Введите длину массива: ");
        int length = sc.nextInt();
        int[] arr = new int[length];
        for (int x = 0; x < arr.length; x++) {
            System.out.print("Введите целое число: ");
            arr[x] = sc.nextInt();
            if (arr[x] % 2 == 0) {
                System.out.println("Первое четное число: " + arr[x]);
                break;
            }
        }
//
//        // 3. Найдите первое чётное число в массиве, которое больше 100
        for (int x = 0; x < arr.length; x++) {
            System.out.print("Введите целое число: ");
            arr[x] = sc.nextInt();
            if (arr[x] % 2 == 0 && arr[x] > 100) {
                System.out.println("Первое четное число больше 100: " + arr[x]);
                break;
            }
        }
//
//        // 4. Найдите последнее слово в массиве, которое написано ЗаБоРчИкОм (что б узнать, заглавная ли буква, используйте Character.isUpperCase(letter) )
        strArr = new String[]{"PhP", "JaVaScRiPt", "JaVa", "Python"};
        for (int x = strArr.length - 1; x >= 0; x--) {
            if (Character.isUpperCase(strArr[x].charAt(strArr[x].length() - 2))) {
                System.out.println("Последнее слово в массиве, которое написано ЗаБоРчИкОм: " + strArr[x]);
                break;
            }
        }
//
//        // 5. Выводите числа от 1 до того момента, как сумма всех цифр в числе не будет равна 20 (пример такого числа - 875)
        decomposeNumber(20);
//
//        // 6. Выведите все даты невисокосного года. В январе 31 день, феврале - 28, далее чередуется - в марте 31, в апреле 30…
//
        for (int j = 1; j <= 12; j++) {
            for (int i = 1; i <= 31; i++) {
                if (j < 8) {
                    if (j == 2) {
                        if (i > 28) continue;
                    }
                    if (j % 2 != 0) {
                        System.out.print(i + " ");
                    } else {
                        if (i == 31) break;
                        System.out.print(i + " ");
                    }
                } else {
                    if (j % 2 == 0) {
                        System.out.print(i + " ");
                    } else {
                        if (i == 31) break;
                        System.out.print(i + " ");
                    }
                }
            }
            System.out.println();
        }
//
//        // 7. Сохраняйте снимки NASA с 1 января того момента, пока в поле Explanation нет слова “Earth”.
        String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2023-01-03&end_date=2023-01-25";
        LoaderFromNasaApi.getResult(LoaderFromNasaApi.downloadWebPage(url));

    }
    // Метод для решения 5-й задачи
    // Алгоритм понятен, но никак в голове не укладывается, как реализовать на практике

    // Неудачная попытка
    private static void decomposeNumber(int number) {
        for (int x = 1; x <= (number + 1) / 2; x++) {
            for (int y = 1; y <= (number + 1) / 2; y++) {
                if (x < y) {
                    for (int z = 1; z <= (number + 1) / 2; z++) {
                        if (y < z && x + y + z == number) System.out.println(x + " " + y + " " + z);
                    }
                }
            }
        }
    }
}

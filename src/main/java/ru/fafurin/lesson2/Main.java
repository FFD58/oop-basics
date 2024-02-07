package ru.fafurin.lesson2;

import java.util.Arrays;

// Урок 2. Введение в методы. Return
public class Main {
    public static void main(String[] args) {
        System.out.println(returnMaxString("qwerty", "asd", "qwqwerqwrqwr", "x", "12"));

        System.out.println(returnStringWithFence("Привет!"));

        System.out.println(returnMaxArrInt(new int[]{1, 2, 45, 101, -123, 29}));

        System.out.println(Arrays.toString(returnMaxSumOfArrElements(
                new int[]{101, -22, 145, 1010, -1123, 1129},
                new int[]{1092, -122, 345, 1101, -11123, 1229},
                new int[]{109, 2111, 452, -21100, 8123, 2901})
        ));

        System.out.println(Arrays.toString(returnOnlyNonNegativeNumbersArr(new int[]{101, -22, 145, -1010, -1123, 1129, 0, -12, 1234})));

    }


    // 1. Напишите метод, который возвращает наиболее из двух целых чисел
    private static int returnMaxInt(int x, int y) {
        return x > y ? x : y;
    }

    // 2. Напишите метод, который возвращает наиболее из двух дробных чисел
    //Вынослив похоже, не так ли? Хотелось бы как-то оптимизировать?:) не спешите, это все возможно: мы до этого ещё дойдём!

    private static double returnMaxDouble(double x, double y) {
        return x > y ? x : y;
    }

    // 3. Напишите метод, который возвращает самую длинную из трех строк
    private static String returnMaxString(String str1, String str2, String str3) {
        return str1.length() > str2.length() ? (str1.length() > str3.length() ? str1 : str3) : str2;
    }

    // 4. Из четырёх
    private static String returnMaxString(String str1, String str2, String str3, String str4) {
        String result1 = str1.length() > str2.length() ? str1 : str2;
        String result2 = str3.length() > str4.length() ? str3 : str4;
        return result1.length() > result2.length() ? result1 : result2;
    }

    // 5. Из пяти. Хочется как-то оптимизировать?:) это хорошо, сможем, когда изучим vararg
    private static String returnMaxString(String str1, String str2, String str3, String str4, String str5) {
        String result1 = returnMaxString(str1, str2, str3);
        String result2 = str4.length() > str5.length() ? str4 : str5;
        return result1.length() > result2.length() ? result1 : result2;
    }

    // 6. Напишите метод, который возвращает входящую строку, делая ее ЗаБоРчИкОм
    private static String returnStringWithFence(String str) {
        str = str.toUpperCase();
        StringBuilder builder = new StringBuilder();
        for (int x = 0; x < str.length(); x++) {
            if (x % 2 != 0) builder.append(Character.toLowerCase(str.charAt(x)));
            else builder.append(str.charAt(x));
        }
        return builder.toString();
    }

    // 7. Напишите метод, который возвращает наибольший элемент массива
    private static int returnMaxArrInt(int[] arr) {
        int max = 0;
        for (int x = 0; x < arr.length; x++) {
            if (arr[x] > max) max = arr[x];
        }
        return max;
    }

    // 8. Напишите метод, который принимает три массива, а возвращает массив, сумма элементов которого самая большая
    private static int[] returnMaxSumOfArrElements(int[] arr1, int[] arr2, int[] arr3) {
        if (returnSumOfArrElements(arr1) > returnSumOfArrElements(arr2) && returnSumOfArrElements(arr1) > returnSumOfArrElements(arr3))
            return arr1;
        else if (returnSumOfArrElements(arr2) > returnSumOfArrElements(arr1) && returnSumOfArrElements(arr2) > returnSumOfArrElements(arr3))
            return arr2;
        else return arr3;
    }

    // Метод возвращает сумму элементов массива целых чисел
    private static int returnSumOfArrElements(int[] arr) {
        int sum = 0;
        for (int x = 0; x < arr.length; x++) {
            sum += arr[x];
        }
        return sum;
    }

    // 9. Напишите метод, который принимает массив чисел, а возвращает исходный массив, но без отрицательных чисел
    private static int[] returnOnlyNonNegativeNumbersArr(int[] arr) {
        int count = 0;
        for (int x = 0; x < arr.length; x++) {
            if (arr[x] >= 0) count++;
        }
        int[] newArr = new int[count];
        int y = 0;
        for (int x = 0; x < arr.length; x++) {
            if (arr[x] >= 0) newArr[y++] = arr[x];
        }
        return newArr;
    }
}


package ru.fafurin.lesson8;

import java.util.Arrays;

// Урок 8. Перегрузка методов
public class Main {
    public static void main(String[] args) {

    // 1. Реализуйте методы, max(x,y) - для целых, вещественных чисел, и для строк (в случае строк - возвращает самую длинную)
        System.out.println(max(4,123));
        System.out.println(max(4.34234,1.12323));
        System.out.println(max("boolean","float"));

    // 2. Реализуйте методы and(boolean x, boolean y), and(boolean x, int y), and(int x, boolean y), который будет возвращать логическое И. Целые числа равные 0 трактовать как false, остальные true.
        System.out.println(and(true,false));
        System.out.println(and(1231,true));
        System.out.println(and(false,12));

    // 3. Реализуйте методы join(String s1, String s2), join(String s1, String s2, String s3), …. join(String s1, String s2, String s3, String s4) - которые склеивают строки
        System.out.println(join("Java", "- мощь!"));
        System.out.println(join("Java", "- самый", "крутой!"));
        System.out.println(join("Java", "- лучший", "язык", "программирования!"));

    // 4. Реализуйте методы merge(int[] array1, int[] array2), merge(int[] array1, int[] array2,int[] array3), merge(int[] array1, int[] array2, int[] array3, int[] array4) - который возвращает новый массив, в котором он соединяет все предыдущие (было 3 массива по 10 элементов, станет массив с 20 элементами)
        System.out.println(Arrays.toString(merge(new int[]{0, 1, 2, 3, 4}, new int[]{5, 6, 7, 8, 9, 10, 11})));
        System.out.println(Arrays.toString(merge(new int[]{0, 1, 2, 3, 4}, new int[]{5, 6, 7, 8}, new int[]{9, 10, 11})));
        System.out.println(Arrays.toString(merge(new int[]{0, 1, 2, 3, 4}, new int[]{5, 6, 7, 8}, new int[]{9, 10, 11}, new int[]{12, 13, 14})));

    }

    // 1. Реализуйте методы, max(x,y) - для целых, вещественных чисел, и для строк (в случае строк - возвращает самую длинную)
    private static int max(int x, int y) {
        return x > y ? x : y;
    }

    private static double max(double x, double y) {
        return x > y ? x : y;
    }

    private static int max(String x, String y) {
        return x.length() > y.length() ? x.length() : y.length();
    }

    // 2. Реализуйте методы and(boolean x, boolean y), and(boolean x, int y), and(int x, boolean y), который будет возвращать логическое И. Целые числа равные 0 трактовать как false, остальные true.

    private static boolean and(boolean x, boolean y) {
        return x && y;
    }

    private static boolean and(boolean x, int y) {
        boolean z = y != 0;
        return x && z;
    }

    private static boolean and(int x, boolean y) {
        boolean z = x != 0;
        return y && z;
    }

    // 3. Реализуйте методы join(String s1, String s2), join(String s1, String s2, String s3), ….
    // join(String s1, String s2, String s3, String s4) - которые склеивают строки
    private static String join(String s1, String s2) {
        return s1 + " " + s2;
    }

    private static String join(String s1, String s2, String s3) {
        return s1 + " " + s2 + " " + s3;
    }

    private static String join(String s1, String s2, String s3, String s4) {
        return s1 + " " + s2 + " " + s3 + " " + s4;
    }

    // 4. Реализуйте методы merge(int[] array1, int[] array2), merge(int[] array1, int[] array2,int[] array3),
    // merge(int[] array1, int[] array2, int[] array3, int[] array4) - который возвращает новый массив,
    // в котором он соединяет все предыдущие (было 3 массива по 10 элементов, станет массив с 20 элементами)
    private static int[] merge(int[] array1, int[] array2) {
        int mergedArrLength = array1.length + array2.length;
        int[] mergedArr = new int[mergedArrLength];
        int x = 0;
        int y = array1.length;
        for (int i = 0; i < mergedArrLength; i++) {
            if (i < array1.length) mergedArr[x++] = array1[i];
            if (i < array2.length) mergedArr[y++] = array2[i];
        }
        return mergedArr;
    }

    private static int[] merge(int[] array1, int[] array2, int[] array3) {
        int mergedArrLength = array1.length + array2.length + array3.length;
        int[] mergedArr = new int[mergedArrLength];
        int x = 0;
        int y = array1.length;
        int z = array1.length + array2.length;
        for (int i = 0; i < mergedArrLength; i++) {
            if (i < array1.length) mergedArr[x++] = array1[i];
            if (i < array2.length) mergedArr[y++] = array2[i];
            if (i < array3.length) mergedArr[z++] = array3[i];
        }
        return mergedArr;
    }

    private static int[] merge (int[] array1, int[] array2, int[] array3, int[] array4) {
        int mergedArrLength = array1.length + array2.length + array3.length + array4.length;
        int[] mergedArr = new int[mergedArrLength];
        int x = 0;
        int y = array1.length;
        int z = array1.length + array2.length;
        int c = array1.length + array2.length + array3.length;
        for (int i = 0; i < mergedArrLength; i++) {
            if (i < array1.length) mergedArr[x++] = array1[i];
            if (i < array2.length) mergedArr[y++] = array2[i];
            if (i < array3.length) mergedArr[z++] = array3[i];
            if (i < array4.length) mergedArr[c++] = array4[i];
        }
        return mergedArr;
    }

}

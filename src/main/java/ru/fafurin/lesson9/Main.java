package ru.fafurin.lesson9;

// Урок 9. Многомерные массивы.
public class Main {
    public static void main(String[] args) {

        // 1. Выведите таблицу умножения 1-9
        printMultiplicationTable(9);
        System.out.println();

        //2. Выведите таблицу умножения 1-20
        printMultiplicationTable(20);

        //3. Создайте двумерный массив, задайте для него значения, выведите его элементы.
        int[][] intArr = fillTwoDimensionalArray(5, 5);
        printTwoDimensionalArray(intArr, 5, 5);

        //4. Создайте двумерный массив. Выведите его предпоследнюю строчку
        intArr = fillTwoDimensionalArray(9, 9);

        for (int row = 0; row < intArr.length; row++) {
            for (int col = 0; col < intArr.length; col++) {
                if (row == intArr.length - 2) System.out.print(intArr[row][col]);
            }
        }
        System.out.println();

        //5. Создайте двумерный массив. Выведите его первый столбец
        intArr = fillTwoDimensionalArray(9, 9);

        for (int row = 0; row < intArr.length; row++) {
            for (int col = 0; col < intArr.length; col++) {
                if (col == 0) System.out.println(intArr[row][col]);
            }
        }

        //6. создайте матрицу(двумерный массив) int[][], заполните ее таблицей умножения 1-9. Выведите ее.
        printTwoDimensionalArray(multiplicationTableAsTwoDimensionalArray(9), 9, 9);
        System.out.println();

        //7. Создайте матрицу int[][], заполните ее календарем на текущий месяц:
        //пн вт ср чт пт сб вс
        //1 2 3 4 5
        //6 7 8 9 10 11 12 Выведите ее.
        printTwoDimensionalArray(fillArrayWithJanuaryDates(), 6, 7);
        System.out.println();

        //8. Создайте матрицу char[][], проинициализируйте ее латинским алфавитом, выведите его.
        // Подсказка - можно получить первую букву как char ch = ‘a’, следующую - как ch + 1, и так далее.
        printTwoDimensionalArray(fillArrayWithLatinLetters(), 5, 6);
        System.out.println();

        //9. Предыдущее задание, но с русским алфавитом.
        printTwoDimensionalArray(fillArrayWithGreatRussianLanguageAlphabetLetters(), 6, 6);
        System.out.println();

    }

    // Таблица умножения на size значений для 1-2 заданий.
    private static void printMultiplicationTable(int size) {
        size++;
        for (int row = 1; row < size; row++) {
            for (int col = 1; col < size; col++) {
                int mult = col * row;
                String str = String.valueOf(mult);
                System.out.print(mult);
                for (int i = 0; i < 6 - str.length(); i++) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    // Заполняет двумерный массив целых чисел единицами
    private static int[][] fillTwoDimensionalArray(int rowCount, int colCount) {
        int[][] intArr = new int[rowCount][colCount];
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                intArr[row][col] = row;
            }
        }
        return intArr;
    }

    // Таблица умножения на size значений для 1-2 заданий.
    private static int[][] multiplicationTableAsTwoDimensionalArray(int size) {
        int[][] intArr = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                intArr[row][col] = (col + 1) * (row + 1);
            }
        }
        return intArr;
    }

    // Выводит двумерный массив
    private static void printTwoDimensionalArray(int[][] arr, int rowCount, int colCount) {
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                System.out.print(arr[row][col]);
                String str = String.valueOf(arr[row][col]);
                for (int i = 0; i < 6 - str.length(); i++) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    // Выводит в консоль содержимое двумерного массива со строками rowCount и столбцами colCount
    private static void printTwoDimensionalArray(String[][] arr, int rowCount, int colCount) {
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                System.out.print(arr[row][col]);
                String str = String.valueOf(arr[row][col]);
                for (int i = 0; i < 6 - str.length(); i++) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static void printTwoDimensionalArray(char[][] arr, int rowCount, int colCount) {
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                System.out.print(arr[row][col] + "   ");
            }
            System.out.println();
        }
    }

    // заполняет двумерный массив датами января 2024
    private static String[][] fillArrayWithJanuaryDates() {
        String[][] arr = new String[6][7];
        String[] daysOfWeek = new String[]{"Пн", "Вт", "Ср", "Чт", "Пт", "Сб", "Вс"};
        for (int x = 0; x < 7; x++) {
            arr[0][x] = daysOfWeek[x] + "    ";
        }
        for (int row = 1; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                int value = col + (row - 1)* 7 + 1;
                if (value <= 31) {
                    arr[row][col] = String.valueOf(value);
                } else if (value < 36) arr[row][col] = "";
            }
        }
        return arr;
    }

    // Создает матрицу с латинским алфавитом
    private static char[][] fillArrayWithLatinLetters() {
        char[][] latinChars = new char[5][6];
        int charCodeLetterA = 97;
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 6; col++) {
                int code = col + charCodeLetterA + row * 6;
                if (code <= 122) {
                    latinChars[row][col] = (char) (col + charCodeLetterA + row * 6);
                } else if (code < 127) latinChars[row][col] = ' ';
            }
        }
        return latinChars;
    }

    // Создает матрицу с Русским алфавитом
    private static char[][] fillArrayWithGreatRussianLanguageAlphabetLetters() {
        char[][] greatRussianLanguageAlphabetLetters = new char[6][6];
        char letter = 'а';
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 6; col++) {
                if ((int) letter != 1104) greatRussianLanguageAlphabetLetters[row][col] = letter++;
                else greatRussianLanguageAlphabetLetters[row][col] = ' ';
            }
        }
        return greatRussianLanguageAlphabetLetters;
    }

}





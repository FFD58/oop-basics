package ru.fafurin.lesson4.task6;

public class SumOfArrElmntsSearcher {
    private int[] numbers;

    public void setData(int[] arr) {
        this.numbers = arr;
    }
    public int getResult() {
        int result = 0;
        for (int x = 0; x < this.numbers.length; x++) {
            result += numbers[x];
        }
        return result;
    }

}

package ru.fafurin.lesson4.task6;

public class MinOfTwoNumbersSearcher {
    private int x;
    private int y;

    public void setData(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getResult() {
        return this.x < this.y ? this.x : this.y;
    }

}

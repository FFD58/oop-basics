package ru.fafurin.lesson4.task4;

public class GreaterOfThreeNumbersSearcher {
    private int x;
    private int y;
    private int z;

    private int result;

    public GreaterOfThreeNumbersSearcher(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void compare() {
        this.result = (this.x > this.y) ? (this.x > this.z ? this.x : this.z) : this.y;
    }

    public int returnResult() {
        return result;
    }
}

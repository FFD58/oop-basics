package ru.fafurin.lesson4.task6;

public class ReverseStringPrinter {
    private String str;

    public void setData(String str) {
        this.str = str;
    }
    public void printResult() {
        for (int x = this.str.length() - 1; x >= 0; x--) {
            System.out.print(str.charAt(x));
        }
    }

}

package ru.fafurin.lesson4.task5;

public class StringCreator {
    private String str1;
    private String str2;
    private String str3;

    private String result;

    public StringCreator(String str1, String str2, String str3) {
        this.str1 = str1;
        this.str2 = str2;
        this.str3 = str3;
    }

    public void concatStrings() {
        this.result = this.str1 + " " + this.str2 + " " + this.str3;
    }

    public String returnResult() {
        return this.result;
    }
}

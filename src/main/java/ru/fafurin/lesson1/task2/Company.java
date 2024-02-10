package ru.fafurin.lesson1.task2;

public class Company {
    String title;
    String areaServed;
    String founded;
    int employees;

    public Company(String title, String areaServed, String founded, int employees) {
        this.title = title;
        this.areaServed = areaServed;
        this.founded = founded;
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Company{" +
                "title='" + title + '\'' +
                ", areaServed='" + areaServed + '\'' +
                ", founded='" + founded + '\'' +
                ", employees=" + employees +
                '}';
    }
}

package ru.fafurin.lesson1.task1;

public class Department {
    private String name;
    private int subjects;
    private int teachersCount;
    private int studentsCount;

    public Department(String name, int subjects, int teachersCount, int studentsCount) {
        this.name = name;
        this.subjects = subjects;
        this.teachersCount = teachersCount;
        this.studentsCount = studentsCount;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", subjects=" + subjects +
                ", teachersCount=" + teachersCount +
                ", studentsCount=" + studentsCount +
                '}';
    }
}

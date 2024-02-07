package ru.fafurin.lesson1.task1;

import java.util.Arrays;

public class Faculty {
    private String name;
    private Department[] departments;

    public Faculty(String name, Department[] departments) {
        this.name = name;
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                ", departments=" + Arrays.toString(departments) +
                '}';
    }
}

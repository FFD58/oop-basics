package ru.fafurin.lesson1.task1;

import java.util.Arrays;

public class University {
    private String name;
    private String address;
    private Faculty[] faculties;

    public University(String name, String address, Faculty[] faculties) {
        this.name = name;
        this.address = address;
        this.faculties = faculties;
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", faculties=" + Arrays.toString(faculties) +
                '}';
    }
}

package ru.fafurin.lesson1;

public class FileInformation {
    private String absolutePath;
    private String name;
    private long size;

    public FileInformation(String absolutePath, String name, long size) {
        this.absolutePath = absolutePath;
        this.name = name;
        this.size = size;
    }

    @Override
    public String toString() {
        return "FileInformation{" +
                "absolutePath='" + this.absolutePath + '\'' +
                ", name='" + this.name + '\'' +
                ", size=" + this.size +
                '}';
    }
}

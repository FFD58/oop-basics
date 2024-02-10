package ru.fafurin.lesson5.task11;

public class FileInformation {
    public String absolutePath;
    public String name;
    public long size;

    public FileInformation(String absolutePath, String name, long size) {
        this.absolutePath = absolutePath;
        this.name = name;
        this.size = size;
    }

    @Override
    public String toString() {
        return  "absolutePath = '" + this.absolutePath + '\'' +
                ", name = '" + this.name + '\'' +
                ", size = " + this.size;
    }

    public static FileInformation createNewFileInformationObject(String str) {
        String[] words = str.split(" ");
        if (words.length != 3) {
            throw new RuntimeException();
        }
        String path = words[0];
        String fileName = words[1];
        long fileSize = Long.parseLong(words[2]);
        return new FileInformation(path, fileName, fileSize);
    }

}

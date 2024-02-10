package ru.fafurin.lesson5.task8;

import ru.fafurin.lesson5.PageDownloader;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CurrencyLoader {
    private final String USD = "R01235";
    private String url = "https://www.cbr.ru/scripts/XML_daily.asp?date_req=";
    private PageDownloader pageDownloader = new PageDownloader();
    private String date;

    public CurrencyLoader generateQuery(String userQuery) {
        StringBuilder builder = new StringBuilder(this.url);
        this.date = userQuery;
        builder.append(userQuery.replace('.', '/'));
        this.url = builder.toString();
        return this;
    }

    public void getDollarQuotes() {
        String filename = "Dollar value for " + this.date + ".txt";
        String source = this.pageDownloader.downloadWebPage(this.url);
        String result = this.formatString(source, this.USD);
        if (result.contains("Dollar quote not found!")) {
            System.out.printf("Dollar quote for %s not found!\n", this.date);
        } else {
            this.setStringToFile(filename, result);
            System.out.printf("Dollar quote for %s successfully saved to file %s\n",this.date, filename);
        }
    }

    private String formatString(String source, String currentValueId) {
        if (source.contains(currentValueId)) {
            String date = source.substring(source.indexOf("Date=") + 6, source.indexOf("Date=") + 16);
            int startIndex = source.indexOf(currentValueId);
            String value = source.substring(startIndex + 104, startIndex + 111);
            return date + ": " + value;
        } else return "Dollar quote not found!";
    }

    private void setStringToFile(String filename, String source) {
        try {
            FileWriter writer = new FileWriter(filename, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(source);
            bufferWriter.write("\n");
            bufferWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

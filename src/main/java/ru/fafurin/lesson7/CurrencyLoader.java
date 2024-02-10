package ru.fafurin.lesson7;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrencyLoader {
    private String url;

    // записывает в файл filename котировку валюты currency за день date
    public void writeCurrencyQuotesByDateToFile(String filename, Date date, Currency currency) {
        String dateStr = new SimpleDateFormat("dd/MM/yyyy").format(date);
        setUrlByDate(dateStr);
        String source = downloadWebPage();
        if (source.contains(currency.getId())) {
            String result = this.formatString(source, currency.getId());
            if (result.contains("Currency quote not found!")) {
                result = String.format("%s: no data available", date);
                this.setStringToFile(filename, result);
                System.out.printf("%s quote for %s not found!\n", currency.getTitle(), date);
            } else {
                this.setStringToFile(filename, result);
                System.out.printf("%s quote for %s successfully saved to file %s\n", currency.getTitle(), date, filename);
            }
        }
    }

    private void setUrlByDate(String date) {
        this.url = String.format("https://www.cbr.ru/scripts/XML_daily.asp?date_req=%s", date);
    }

    public void setUrl(String day, String month, String year) {
        this.url = String.format("https://www.cbr.ru/scripts/XML_daily.asp?date_req=%s/%s/%s", day, month, year);
    }

    private String formatString(String source, String currentValueId) {
        if (source.contains(currentValueId)) {
            String date = source.substring(source.indexOf("Date=") + 6, source.indexOf("Date=") + 16);
            int startValueIndex = source.indexOf("<Value>", source.indexOf(currentValueId)) + "<Value>".length();
            int endValueIndex = source.indexOf("/Value", startValueIndex) - 1;
            String value = source.substring(startValueIndex, endValueIndex);
            return date + ": " + value;
        } else return "Currency quote not found!";
    }

    private String downloadWebPage() {
        StringBuilder res = new StringBuilder();
        try {
            String line;
            URLConnection urlConnection = new URL(this.url).openConnection();
            InputStream is = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                res.append(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return res.toString();
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

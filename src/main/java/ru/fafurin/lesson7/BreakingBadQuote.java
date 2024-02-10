package ru.fafurin.lesson7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class BreakingBadQuote {

    private final String URL = "https://api.breakingbadquotes.xyz/v1/quotes";

    private String author;
    private String quote;

    // Выводит только цитату Walter White
    public void printWalterWhiteQuote() {
        boolean isContinue = true;
        while (isContinue) {
            String result = formatDownloadString();
            if (result.contains("Walter White")) {
                System.out.println(result);
                isContinue = false;
            }
        }
    }
    // Выводит указанное количество цитат из сериала
    public void printRandomQuotesFromBreakingBad(int count) {
        String[] quotesArr = new String[count];
        quotesArr[0] = formatDownloadString();
        for (int i = 0; i < quotesArr.length; i++) {
            System.out.printf("Quote %d downloaded \n", i);
            for (int x = 0; x < i; x++) {
                if (!formatDownloadString().equals(quotesArr[x])) {
                    quotesArr[i] = formatDownloadString();
                } else {
                    System.out.println("Quote already in array");
                }
            }
        }
        for (String s : quotesArr) {
            System.out.println(s);
            System.out.println("- - - - - - - - - -");
        }
    }

    // Форматирует строку для дальнейшей обработки
    private String formatDownloadString() {
        String result = "";
        try {
            String str = downloadWebPage(this.URL);
            this.author = str.substring(str.indexOf("author\":") + 9, str.indexOf("\"}]"));
            this.quote = str.substring(str.indexOf("quote:") + 11, str.indexOf(",\"author\":"));
            result = String.format("%s: %s", this.author, this.quote);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    // Загружает содержимое url в строку
    private String downloadWebPage(String url) throws IOException {
        StringBuilder res = new StringBuilder();
        String line;
        URLConnection urlConnection = new URL(url).openConnection();
        try (InputStream is = urlConnection.getInputStream(); BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            while ((line = br.readLine()) != null) {
                res.append(line);
            }
        }
        return res.toString();
    }

}

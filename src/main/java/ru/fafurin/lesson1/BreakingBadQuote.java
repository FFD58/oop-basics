package ru.fafurin.lesson1;

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

    public BreakingBadQuote() {
        getQuoteAndAuthor();
    }

    @Override
    public String toString() {
        return quote + "\n" + this.searchAuthorPosition() + author + "\n";
    }

    // Outputs only the Walter White quote
    public void printWalterWhiteQuotes() {
        String result = formatDownloadString();
        System.out.println(result.contains("Walter White") ? result : "Try again");
    }

    // Displays the specified number of quotes from the series
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

    private void getQuoteAndAuthor() {
        String str = downloadWebPage(this.URL);
        this.author = str.substring(str.indexOf("author\":") + 9, str.indexOf("\"}]"));
        this.quote = str.substring(str.indexOf("quote:") + 11, str.indexOf(",\"author\":"));
    }

    private String formatDownloadString() {
        return String.format("%s: %s", this.author, this.quote);
    }

    // Loads the contents of the url into a string
    private static String downloadWebPage(String url) {
        StringBuilder res = new StringBuilder();
        try {
            String line;
            URLConnection urlConnection = new URL(url).openConnection();
            try (InputStream is = urlConnection.getInputStream(); BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                while ((line = br.readLine()) != null) {
                    res.append(line);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return res.toString();
    }

    // Found whitespaces count for alignment author at the end of the quote
    private String searchAuthorPosition() {
        int authorPositionIndex = this.quote.length() - this.author.length();
        StringBuilder builder = new StringBuilder();
        for (int x = 0; x < authorPositionIndex; x++) {
            builder.append(" ");
        }
        return builder.toString();
    }

}

package ru.fafurin.lesson5.task9;

import ru.fafurin.lesson5.PageDownloader;

public class BreakingBadQuote {

    private final String URL = "https://api.breakingbadquotes.xyz/v1/quotes";

    private final String[] obsceneWords = new String[]{
            "fuck", "bitch", "f*ck", "damn", "whore", "slut", "freak", "douchebag", "gay", "asshole", "sucker",
            "dick", "prick", "cunt", "damn", "pussy", "bastard", "jerk", "retard", "stupid", "fool", "nerd",
    };

    private String author;
    private String quote;

    private PageDownloader pageDownloader = new PageDownloader();

    public BreakingBadQuote() {
        this.getQuoteAndAuthor();
        System.out.println(this.quote);
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
        for (int i = 1; i < quotesArr.length; i++) {
            this.getQuoteAndAuthor();
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
        String str = this.pageDownloader.downloadWebPage(this.URL);
        this.author = str.substring(str.indexOf("author\":") + 9, str.indexOf("\"}]"));
        this.quote = str.substring(str.indexOf("quote:") + 11, str.indexOf(",\"author\":"));
        this.quote = "Gatorade, Fuck me, Bitch!";
        this.censorTheQuote();
    }

    private String formatDownloadString() {
        return String.format("%s: %s", this.author, this.quote);
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

    private void checkQuoteForObsceneWord(String obsceneWord) {
        StringBuilder builder = new StringBuilder();
        if (this.quote.toLowerCase().contains(obsceneWord.toLowerCase())) {
            for (int x = 0; x < obsceneWord.length(); x++) {
                builder.append("*");
            }
            this.quote = this.quote.replace(obsceneWord, builder.toString());
        }
    }

    public void censorTheQuote() {
        for (String obsceneWord : this.obsceneWords) {
            checkQuoteForObsceneWord(obsceneWord);
        }
    }
}

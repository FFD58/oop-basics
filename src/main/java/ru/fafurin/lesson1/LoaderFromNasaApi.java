package ru.fafurin.lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LoaderFromNasaApi {
    // uri NASA API astronomy picture of the day
    private static final String NASA_API = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY";

    public void getImagesByDates(String startDate, String endDate) {
        // даты вводить в формате гггг-мм-дд
        String dates = String.format("&start_date=%s&end_date=%s", startDate, endDate);
        String url = NASA_API + dates;
        this.getResult(this.downloadWebPage(url));
    }

    private void getResult(String string) {
        boolean isExit = true;
        while (isExit) {
            if (string.contains("\"url\"")) {
                String url = string.substring(string.indexOf("\"url\"") + 7, string.indexOf("}") - 1);
                String filename = url.substring(url.lastIndexOf("/") + 1);
                this.saveImgToFile(filename, url);
                String replace = string.substring(string.indexOf("{"), string.indexOf("}") + 2);
                string = string.replace(replace, "");
            } else isExit = false;
        }
        System.out.println("Images downloaded...");
    }

    private void saveImgToFile(String filename, String url) {
        String path = System.getProperty("user.dir") + "\\images";
        try {
            Files.createDirectories(Paths.get(path));
            if (filename.contains("jpg")) {
                try (InputStream in = new URL(url).openStream()) {
                    Files.copy(in, Paths.get("images/" + filename));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Image " + filename + " saved.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private String downloadWebPage(String url) {
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
}

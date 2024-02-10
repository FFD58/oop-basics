package ru.fafurin.lesson6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LoaderFromNasaApi {
    public static void getResult(String source) {
        boolean isContinue = true;
        while (isContinue) {
            if (source.contains("\"url\"")) {
                int explanationIndex = source.indexOf("explanation") + 14;
                String explanation = source.substring(explanationIndex, source.indexOf("\"", explanationIndex));
                String imageUrl = source.substring(source.indexOf("url") + 6, source.indexOf(".jpg\"") + 4);
                if (explanation.contains("Earth")) break;
                saveToFile(imageUrl, "images");
                String replace = source.substring(source.indexOf("{"), source.indexOf("}") + 2);
                source = source.replace(replace, "");
            } else isContinue = false;
        }
    }
    private static void saveToFile(String imageUrl, String dir) {
        String filename = imageUrl.substring(imageUrl.lastIndexOf("/") + 1);
        String path = System.getProperty("user.dir") + "\\" + dir;

        try (InputStream in = new URL(imageUrl).openStream()) {
            Files.createDirectories(Paths.get(path));
            Files.copy(in, Paths.get("images/" + filename));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String downloadWebPage(String url) {
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

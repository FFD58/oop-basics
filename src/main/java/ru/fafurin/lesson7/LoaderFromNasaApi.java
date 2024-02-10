package ru.fafurin.lesson7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoaderFromNasaApi {
    // uri NASA API astronomy picture of the day
    private static final String NASA_API = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY";


    // Возвращает explanation сегодняшнего снимка дня NASA
    public String returnTodayExplanation() {
        String result = this.downloadWebPage(NASA_API);
        int explanationIndex = result.indexOf("explanation") + "explanation".length() + 3;
        return result.substring(explanationIndex, result.indexOf("\"", explanationIndex));
    }
    // Возвращает explanation снимка дня NASA по дате
    public String returnExplanationByDate(Date date) {
        String dateStr = this.dateToString(date);
        String dates = String.format("&start_date=%s&end_date=%s", dateStr, dateStr);
        String result = this.downloadWebPage(NASA_API + dates);
        int explanationIndex = result.indexOf("explanation") + "explanation".length() + 3;
        return result.substring(explanationIndex, result.indexOf("\"", explanationIndex));
    }

    // Возвращает данные по снимкам дней NASA в интервале из двух дат
    public String returnNASAImagesData(Date startDate, Date endDate) {
        String startDateStr = this.dateToString(startDate);
        String endDateStr = this.dateToString(endDate);
        String dates = String.format("&start_date=%s&end_date=%s", startDateStr, endDateStr);
        String url = NASA_API + dates;
        return this.downloadWebPage(url);
    }

    public void getFileFromString(String string) {
        boolean isExit = true;
        while (isExit) {
            // проверяем есть ли в строке url
            if (string.contains("\"url\"")) {
                // получаем ссылку на изображение
                String url = string.substring(string.indexOf("\"url\"") + 7, string.indexOf("}") - 1);
                // из ссылки получаем название файла
                String filename = url.substring(url.lastIndexOf("/") + 1);
                // создаем папку в директории проекта
                String path = System.getProperty("user.dir") + "\\images";
                try{
                    Files.createDirectories(Paths.get(path));
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                // проверяем картинку ли мы закачиваем
                if (filename.contains("jpg")) {
                    try (InputStream in = new URL(url).openStream()) {
                        Files.copy(in, Paths.get("images/" + filename));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Image " + filename + " saved.");
                // удаляем из строки блок с загруженной картинкой
                String replace = string.substring(string.indexOf("{"), string.indexOf("}") + 2);
                string = string.replace(replace, "");

            } else isExit = false;
        }
        System.out.println("Images downloaded...");
    }

    // Загружает содержимое url в строку
    private String downloadWebPage(String url) {
        StringBuilder res = new StringBuilder();
        String line;
        try {
            URLConnection urlConnection = new URI(url).toURL().openConnection();
            InputStream is = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                res.append(line);
            }
        } catch (IOException | URISyntaxException e) {
            System.out.println(e.getMessage());
        }
        return res.toString();
    }

    private String dateToString(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
}

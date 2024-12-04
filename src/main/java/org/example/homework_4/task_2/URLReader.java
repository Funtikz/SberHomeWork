package org.example.homework_4.task_2;

import java.io.*;
import java.net.*;

public class URLReader {

    public static void readContent(String url) {
        try {
            URL website = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) website.openConnection();
            connection.setRequestMethod("GET");

            int status = connection.getResponseCode();
            if (status != 200) {
                System.out.println("Ошибка при подключении: HTTP код " + status);
                return;
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine).append("\n");
            }
            in.close();

            System.out.println(content.toString());

        } catch (MalformedURLException e) {
            System.out.println("Неверный формат URL. Попробуйте снова.");
        } catch (IOException e) {
            System.out.println("Ошибка при доступе к ресурсу. Попробуйте позже.");
        }
    }
}
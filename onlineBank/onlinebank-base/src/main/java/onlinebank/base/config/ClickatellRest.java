package com.onlinebank.core.config;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class ClickatellRest {

    private static final String CLICKATELL_REST_BASE_URL = "https://api.clickatell.com/rest/";

    private static String APIKEY = "hv_dckBS5rFfpF6oirSZnA.YwlfJocmpcHe360qZXa5eK4Pl1POCEWFG0_Dp35bLbyPJa85jR1guhT";

    private static final String POST = "POST";

    private String apiKey;

    public ClickatellRest(String apiKey) {
        this.apiKey = apiKey;
    }

    public void sendMessage(String[] numbers, String message) throws IOException {
        String number = numbers[0];
        for (int x = 1; x < numbers.length; x++) {
            number += "\",\"" + numbers[x];
        }
        // Send Request:
      this.excute("message", POST, "{\"to\":[\"" + number
                + "\"],\"text\":\"" + message + "\"}");
    }

    private String excute(String resource, String method, String dataPacket) throws IOException {
        URL url;
        HttpURLConnection connection = null;
        // Create connection
        url = new URL(CLICKATELL_REST_BASE_URL + resource);
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(method);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("X-Version", "1");
        connection.setRequestProperty("Authorization", "Bearer " + apiKey);
        String l = "0";
        if (dataPacket != null) {
            l = Integer.toString(dataPacket.getBytes().length);
        }
        connection.setRequestProperty("Content-Length", "" + l);
        connection.setRequestProperty("Content-Language", "ru-RU");
        connection.setUseCaches(false);
        connection.setDoInput(true);
        connection.setDoOutput(dataPacket != null);

        // Send request
        if (dataPacket != null) {
            DataOutputStream wr = new DataOutputStream(
                    connection.getOutputStream());
            wr.writeBytes(dataPacket);
            wr.flush();
            wr.close();
        }
        // Get Response
        connection.getResponseCode();
        InputStream stream = connection.getErrorStream();
        if (stream == null) {
            stream = connection.getInputStream();
        }
        BufferedReader rd = new BufferedReader(
                new InputStreamReader(stream));
        String line;
        StringBuffer response = new StringBuffer();
        while ((line = rd.readLine()) != null) {
            response.append(line);
            response.append('\n');
        }
        rd.close();

        if (connection != null) {
            connection.disconnect();
        }
        return response.toString().trim();
    }

    public static void multipleNumbers(String[] number, String message) throws IOException {

        ClickatellRest click = new ClickatellRest(APIKEY);
        click.sendMessage(number, message);
    }
}

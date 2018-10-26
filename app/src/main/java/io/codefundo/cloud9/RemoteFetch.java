package io.codefundo.cloud9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

public class RemoteFetch {

    private static final String OPEN_WEATHER_MAP_API =
            "http://api.openweathermap.org/data/2.5/weather?q=%s&units=metric&APPID=";

    public static JSONObject getJSON(Context context, String city) {
        try {
            final String OPEN_WEATHER_MAP_API =
                    "http://api.openweathermap.org/data/2.5/weather?units=metric&q=" + city +
                            "&APPID=" + context.getString(R.string.open_weather_maps_app_id);
            URL url = new URL(OPEN_WEATHER_MAP_API);
            HttpURLConnection connection =
                    (HttpURLConnection) url.openConnection();

            connection.connect();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            StringBuffer json = new StringBuffer(1024);
            String tmp = "";
            while ((tmp = reader.readLine()) != null)
                json.append(tmp).append("\n");
            reader.close();

            JSONObject data = new JSONObject(json.toString());

            // This value will be 404 if the request was not
            // successful
            if (data.getInt("cod") != 200) {
                return null;
            }

            return data;
        } catch (Exception e) {
            return null;
        }
    }
}


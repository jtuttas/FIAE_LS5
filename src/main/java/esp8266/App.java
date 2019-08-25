package src.main.java.esp8266;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.*;
public class App {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=Hanover,de&appid=4727c8383bacbff7ac85de94ec48c85c");

        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // print result
        System.out.println("HTTP Respoce: "+response.toString());

        // Einlesen als JSON
        JSONObject obj = new JSONObject(response.toString());
        System.out.println("Temperatur ist:"+obj.getJSONObject("main").getFloat("temp")+" K");
        
    }
}
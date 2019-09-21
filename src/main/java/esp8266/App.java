package esp8266;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class App {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://192.168.155.17:8080/get?pressure");

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
        System.out.println("Druck ist:"+obj.getJSONObject("buffer").getJSONObject("pressure").getJSONArray("buffer").getDouble(0)+" mBAR");
    }
}
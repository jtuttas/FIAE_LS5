package app;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public class App {
    

    /**
     * main method
     */
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://192.168.178.87:8080/get?pressure");

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        System.out.println("\nSending 'GET' request to URL : " + url);

        Scanner reader = new Scanner(con.getInputStream());
        String inputLine="";
        while (reader.hasNext()) {
            inputLine=inputLine+reader.nextLine();
        }
        reader.close();

        System.out.println("HTTP Responce: "+inputLine);
        JSONObject obj = new JSONObject(inputLine);
        System.out.println("Druck ist:"+obj.getJSONObject("buffer").getJSONObject("pressure").getJSONArray("buffer").getDouble(0)+" mBAR");    
    }
}

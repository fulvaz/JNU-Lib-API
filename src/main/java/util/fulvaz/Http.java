package util.fulvaz;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by fulvaz on 16/10/6.
 */
public class Http {
    public static void main(String[] args) {
        try {
            System.out.println(Http.sendGET("http://opac.jnu.edu.cn/search*chx/?searchtype=X&searcharg=%E7%BE%8E%E4%B8%BD%E6%96%B0%E4%B8%96%E7%95%8C&SORT=D&searchscope=1&x=44&y=8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String sendGET(String target) throws IOException {
        URL url = new URL(target);
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        }
        return null;
    }

    public static String sendPost(String target, String body) throws IOException {
        URL url = new URL(target);
        HttpURLConnection con = (HttpURLConnection)url.openConnection();

        con.setRequestMethod("POST");

        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(body);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder sb = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine);
            }

            in.close();
        }
        return null;
    }
}

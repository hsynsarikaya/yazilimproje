package projeproje.yazilimproje;

import java.io.IOException;

import com.squareup.okhttp.*;

public class WebServisTest {

    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
          .url("http://localhost:8888/haberci/olustur?haber=TrafikKazası")
          .get()
          .addHeader("cache-control", "no-cache")
          .addHeader("postman-token", "cf587d5f-e520-fcc7-027c-ea6f1187d851")
          .build();

        try {
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            System.out.println("Hata: " + e);
        }
    }
}
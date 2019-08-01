package com.test;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class StreamTutorialMainClass {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        List<String> namesList = Arrays.asList("Bala","Arun","Teja","Vijay","Arul","Sakthi","Sathya",null,null);

//        for(int i=0;i<namesList.size();i++){
//            System.out.println(namesList.get(i));
//        }

        namesList.stream().sorted(Comparator.nullsFirst(Comparator.naturalOrder())).forEach(System.out::println);

        URL google = new URL("https://www.flipkart.com");
        URL amazon = new URL("https://www.amazon.in");
        URL quora = new URL("https://www.quora.com/");

        Long start = new Date().getTime();
        CompletableFuture completableFuture1 = CompletableFuture.supplyAsync(()->{
            StringBuffer response3 = new StringBuffer();
            try{
                HttpsURLConnection httpsURLConnection3 = (HttpsURLConnection) google.openConnection();
                BufferedReader in3 = new BufferedReader(new InputStreamReader(httpsURLConnection3.getInputStream()));
                String line3;
                while ((line3 = in3.readLine())!=null){
                    response3.append(line3);
                }
            }
            catch(Exception e){}
            return response3;
        });

        CompletableFuture completableFuture2 = CompletableFuture.supplyAsync(()->{
            StringBuffer response3 = new StringBuffer();
            try{
                HttpsURLConnection httpsURLConnection3 = (HttpsURLConnection) amazon.openConnection();
                BufferedReader in3 = new BufferedReader(new InputStreamReader(httpsURLConnection3.getInputStream()));
                String line3;
                while ((line3 = in3.readLine())!=null){
                    response3.append(line3);
                }
            }
            catch(Exception e){}
            return response3;
        });
        CompletableFuture completableFuture3 = CompletableFuture.supplyAsync(()->{
            StringBuffer response3 = new StringBuffer();
            try{
                HttpsURLConnection httpsURLConnection3 = (HttpsURLConnection) quora.openConnection();
                BufferedReader in3 = new BufferedReader(new InputStreamReader(httpsURLConnection3.getInputStream()));
                String line3;
                while ((line3 = in3.readLine())!=null){
                    response3.append(line3);
                }
            }
            catch(Exception e){}
            return response3;
        });
//        System.out.println("Response: " + completableFuture1.get().toString() + completableFuture2.get().toString() + completableFuture3.get().toString());
        completableFuture1.get();
        completableFuture2.get();
        completableFuture3.get();
        System.out.println("CompletableFuture call time taken: "+(new Date().getTime() - start));

        start = new Date().getTime();
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) google.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
        StringBuffer response = new StringBuffer();
        String line;
        while ((line = in.readLine())!=null){
            response.append(line);
        }
        HttpsURLConnection httpsURLConnection1 = (HttpsURLConnection) amazon.openConnection();
        BufferedReader in1 = new BufferedReader(new InputStreamReader(httpsURLConnection1.getInputStream()));
        StringBuffer response1 = new StringBuffer();
        String line1;
        while ((line1 = in1.readLine())!=null){
            response1.append(line1);
        }
        HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) quora.openConnection();
        BufferedReader in2 = new BufferedReader(new InputStreamReader(httpsURLConnection2.getInputStream()));
        StringBuffer response2 = new StringBuffer();
        String line2;
        while ((line2 = in2.readLine())!=null){
            response2.append(line2);
        }
//        System.out.println("Response: " + response + response1 + response2);
        System.out.println("Normal call time taken: "+(new Date().getTime() - start));

    }
}

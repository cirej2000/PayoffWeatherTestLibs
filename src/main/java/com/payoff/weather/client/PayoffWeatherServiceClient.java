package com.payoff.weather.client;

import com.jayway.restassured.response.Response;

import java.util.Locale;
import java.util.ResourceBundle;
import java.net.URL;
import java.net.URI;

import static com.jayway.restassured.RestAssured.*;
import static java.util.ResourceBundle.*;

/**
 * Created by eric on 6/5/2015.
 */
public class PayoffWeatherServiceClient {
    private int httpStatusCode;
    private String jsonResponse = "";
   // private String hostName = "";
   // private String urlPath = "";
   // private StringBuilder requestUrl = null;
    private Response responseObject = null;
    private ResourceBundle rb;

    public PayoffWeatherServiceClient()
    {
        rb = getBundle("WeatherResourcesSite", new Locale("en", "US"));
       // requestUrl=new StringBuilder("https://");
       // requestUrl.append(rb.getString("defaultWeatherHost")).append(rb.getString("defaultServicePath")).append(rb.getString("defaultServicePath")).append("?").append(rb.getString("defaultParameter"));
        //System.out.println("Dummy output force update.");
    }

    public void callWeatherService(BadUrlTypes type)
    {
        rb = getBundle("WeatherResourcesSite", new Locale("en", "US"));
        //requestUrl=new StringBuilder("https://");
        if (type.equals(BadUrlTypes.NO_LOCATION))
            responseObject = com.jayway.restassured.RestAssured.given().headers("X-Mashape-Key", "5eaiIdkH1bmshSmjkdw9LNYIspr0p1mvRUTjsn7Sgpt1V2NaMa", rb.getString("header2"), rb.getString("headerValue2")).get("https://george-vustrey-weather.p.mashape.com/api.php");
        else if(type.equals(BadUrlTypes.NO_AUTH))
            responseObject = com.jayway.restassured.RestAssured.given().headers(rb.getString("header2"), rb.getString("headerValue2")).get("https://george-vustrey-weather.p.mashape.com/api.php?location=Paris");
        else if(type.equals(BadUrlTypes.NO_AUTH_KEY))
            responseObject = com.jayway.restassured.RestAssured.given().headers("X-Mashape-Key", null, rb.getString("header2"), rb.getString("headerValue2")).get("https://george-vustrey-weather.p.mashape.com/api.php?location=Berlin");
        else if(type.equals(BadUrlTypes.BAD_AUTH))
            responseObject = com.jayway.restassured.RestAssured.given().headers("X-Mashape-Key", "5eaiIdkH1 ", rb.getString("header2"), rb.getString("headerValue2")).get("https://george-vustrey-weather.p.mashape.com/api.php?location=Chicago");
        jsonResponse = responseObject.asString();
        httpStatusCode = responseObject.getStatusCode();
    }

    public void callWeatherService(String method, String location)
    {
        if (method.toLowerCase().equals("get"))
            responseObject = com.jayway.restassured.RestAssured.given().headers("X-Mashape-Key", "5eaiIdkH1bmshSmjkdw9LNYIspr0p1mvRUTjsn7Sgpt1V2NaMa", rb.getString("header2"), rb.getString("headerValue2")).get("https://george-vustrey-weather.p.mashape.com/api.php?location="+location);
        else if (method.toLowerCase().equals("post"))
            responseObject = com.jayway.restassured.RestAssured.given().headers("X-Mashape-Key", "5eaiIdkH1bmshSmjkdw9LNYIspr0p1mvRUTjsn7Sgpt1V2NaMa", rb.getString("header2"), rb.getString("headerValue2")).post("https://george-vustrey-weather.p.mashape.com/api.php?location=" + location);
        else if (method.toLowerCase().equals("put"))
            responseObject = com.jayway.restassured.RestAssured.given().headers("X-Mashape-Key", "5eaiIdkH1bmshSmjkdw9LNYIspr0p1mvRUTjsn7Sgpt1V2NaMa", rb.getString("header2"), rb.getString("headerValue2")).put("https://george-vustrey-weather.p.mashape.com/api.php?location=" + location);
        else if (method.toLowerCase().equals("delete"))
            responseObject = com.jayway.restassured.RestAssured.given().headers("X-Mashape-Key", "5eaiIdkH1bmshSmjkdw9LNYIspr0p1mvRUTjsn7Sgpt1V2NaMa", rb.getString("header2"), rb.getString("headerValue2")).put("https://george-vustrey-weather.p.mashape.com/api.php?location="+location);

        //store the response as a string for now and put our code in an integer for later retrieval
        jsonResponse = responseObject.asString();
        httpStatusCode = responseObject.getStatusCode();
    }


    public String getResponseBody()
    {
        return this.jsonResponse;
    }

    public int getResponseStatusCode()
    {
        return this.httpStatusCode;
    }
}

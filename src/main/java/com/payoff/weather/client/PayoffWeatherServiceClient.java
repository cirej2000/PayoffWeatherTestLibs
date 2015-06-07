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
    private String hostName = "";
    private String urlPath = "";
    private StringBuilder requestUrl = null;
    private Response responseObject = null;
    private ResourceBundle rb;

    public PayoffWeatherServiceClient()
    {
        rb = getBundle("WeatherResourcesSite", new Locale("en", "US"));
        requestUrl=new StringBuilder("https://");
        requestUrl.append(rb.getString("defaultWeatherHost")).append(rb.getString("defaultServicePath")).append(rb.getString("defaultServicePath")).append("?").append(rb.getString("defaultParameter"));

    }

    public void get(String location)
    {
        //given().header("X-Mashape-Key","5eaiIdkH1bmshSmjkdw9LNYIspr0p1mvRUTjsn7Sgpt1V2NaMa",rb.getString("header2"),rb.getString("headerValue2"));
        responseObject = com.jayway.restassured.RestAssured.given().headers("X-Mashape-Key", "5eaiIdkH1bmshSmjkdw9LNYIspr0p1mvRUTjsn7Sgpt1V2NaMa", rb.getString("header2"), rb.getString("headerValue2")).get("https://george-vustrey-weather.p.mashape.com/api.php?location="+location);
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

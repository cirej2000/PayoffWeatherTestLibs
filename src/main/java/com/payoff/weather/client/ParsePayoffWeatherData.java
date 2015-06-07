package com.payoff.weather.client;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by eric on 6/6/2015.
 */
public class ParsePayoffWeatherData {
    public static int getErrorMessageCode(String error)
    {
        JSONObject msg = new JSONObject(error);
        return msg.getInt("code");
    }

    public static String getErrorMessage(String error)
    {
        JSONObject msg = new JSONObject(error);
        return msg.getString("message");
    }

    public static int getResultSetSize(String response){
        JSONArray responseSet = new JSONArray(response);
        return responseSet.length();
    }

    /**
     * Returns the name of the day of week based on a 1 based index (1=first day in forecast)
     * @param day - 1 based index
     * @param response - string returned by our weather service request
     * @return - a string representing the day of week (3 char representation)
     */
    public static String getDayOfWeek(int day, String response)
    {
        JSONArray responseSet = new JSONArray(response);
        return responseSet.getJSONObject(day-1).getString("day_of_week");
    }

    /**
     * Returns the condition of the weather for the given day (1=first day in forecast)
     * @param day - 1 based index
     * @param response - string returned by our weather service request
     * @return - a string representing explanation of the weather conditions for the day in the forecast
     */
    public static String getDaysCondition(int day, String response)
    {
        JSONArray responseSet = new JSONArray(response);
        return responseSet.getJSONObject(day-1).getString("condition");
    }

    /**
     * Returns the fahrenheit high temp for a given day (1=first day in forecast)
     * @param day - 1 based index
     * @param response - string returned by our weather service request
     * @return - a string representing the high temperature in F
     */
    public static String getDailyHigh(int day, String response)
    {
        JSONArray responseSet = new JSONArray(response);
        return responseSet.getJSONObject(day-1).getString("high");
    }

    /**
     * Returns the fahrenheit high temp for a given day (1=first day in forecast)
     * @param day - 1 based index
     * @param response - string returned by our weather service request
     * @return - a string representing the low temperature in F
     */
    public static String getDailyLow(int day, String response)
    {
        JSONArray responseSet = new JSONArray(response);
        return responseSet.getJSONObject(day-1).getString("low");
    }

    /**
     * Returns the celsius high temp for a given day (1=first day in forecast)
     * @param day - 1 based index
     * @param response - string returned by our weather service request
     * @return - a string representing the high temperature in C
     */
    public static String getDailyHighC(int day, String response)
    {
        JSONArray responseSet = new JSONArray(response);
        return responseSet.getJSONObject(day-1).getString("high_celsius");
    }

    /**
     * Returns the celsius high temp for a given day (1=first day in forecast)
     * @param day - 1 based index
     * @param response - string returned by our weather service request
     * @return - a string representing the low temperature in C
     */
    public static String getDailyLowC(int day, String response)
    {
        JSONArray responseSet = new JSONArray(response);
        return responseSet.getJSONObject(day-1).getString("low_celsius");
    }

}

package com.example.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public ApiClient(){}

    private Gson getGson() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        return gson;
    }

    private Retrofit getRetrofit() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.privatbank.ua/")
                .addConverterFactory(GsonConverterFactory.create(getGson()))
                .build();
        return retrofit;
    }

    public CurrencyService getCurrencyService() {
        CurrencyService currencyService = getRetrofit().create(CurrencyService.class);

        return currencyService;
    }
}

package com.example.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CurrencyService {

    @GET("p24api/pubinfo?exchange&json&coursid=11")
    Call<List<CurrencyResponse>> getCurrencies();
}

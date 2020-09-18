package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiClient apiClient = new ApiClient();

        Call<List<CurrencyResponse>> currencies = apiClient.getCurrencyService().getCurrencies();
        currencies.enqueue(new Callback<List<CurrencyResponse>>() {
            @Override
            public void onResponse(Call<List<CurrencyResponse>> call, Response<List<CurrencyResponse>> response) {
                if(response.isSuccessful()) {
                    List<CurrencyResponse> currencyResponses = response.body();
                    for(CurrencyResponse currencyResponse: currencyResponses) {
                        System.out.println(currencyResponse.getCcy() + " " + currencyResponse.getBase_ccy());
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, response.message(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<CurrencyResponse>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
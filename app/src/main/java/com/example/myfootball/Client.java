package com.example.myfootball;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {
    private static final String BASE_URL = "https://f-ball-app.herokuapp.com/api/auth/";
    private static Client mInstancel;
    private Retrofit retrofit;

    private Client(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static synchronized  Client getInstance(){
        if (mInstancel == new Client()){
            mInstancel= new Client() ;
        }
        return mInstancel;

    }
    public FootballAPI getApi(){
        return retrofit.create(FootballAPI.class);
    }
}

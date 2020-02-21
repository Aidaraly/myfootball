package com.example.myfootball;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface FootballAPI {

    @FormUrlEncoded
    @POST("register")
    Call<ResponseBody> signupUser(
            @Field("email") String email,@Field("password") String password, @Field("name") String name,
            @Field("surname") String surname, @Field("age") String age
    );


}

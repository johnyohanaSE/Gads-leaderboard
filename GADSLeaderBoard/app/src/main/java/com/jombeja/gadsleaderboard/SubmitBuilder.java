/**package com.jombeja.gadsleaderboard;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SubmitBuilder {
    private static final String URL1 = "https://docs.google.com/forms/d/e/";

    private static Retrofit.Builder subBuilder = new Retrofit.Builder()
            .baseUrl(URL1)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit subRetrofit = subBuilder.build();

    public static <S> S buildservice(Class<S> serviceType){
        return subRetrofit.create(serviceType);
    }

}**/

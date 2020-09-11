package com.jombeja.gadsleaderboard;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LearningApi {

    @GET("api/hours")
    Call<List<LearningData>> getHours();
}

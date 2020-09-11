package com.jombeja.gadsleaderboard;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Submit {

    //@POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    //Call<SubmitData> getForm (@Body SubmitData submitData);

    @FormUrlEncoded
    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    Call<SubmitData> submitForm(
            @Field("entry.1877115667")String firstname,
            @Field("entry.2006916086")String lastname,
            @Field("entry.1824927963")String emailaddress,
            @Field("entry.284483984")String githublink
    );

}

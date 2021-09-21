package com.hadimusthafa.retrofitpost;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("/api/users")
    Call<Model> getUserInfo(@Field("name") String name, @Field("job") String job);
}


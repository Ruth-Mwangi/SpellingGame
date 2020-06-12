package com.ruth.spellinggame.networks;

import com.ruth.spellinggame.models.WebsterSearchResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WebsterApi {
    @GET("{word}")
    Call<List<WebsterSearchResponse>> getDefinition (
            @Path("word") String string,
            @Query("key") String WEBSTER_API_KEY
    );
}

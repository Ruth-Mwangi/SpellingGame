package com.ruth.spellinggame.networks;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.ruth.spellinggame.Constants.WEBSTER_API_KEY;
import static com.ruth.spellinggame.Constants.WEBSTER_BASE_URL;

public class WebsterClient {
    private static Retrofit retrofit = null;

    public static WebsterApi getClient() {
        if (retrofit == null) {
            OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
            Interceptor interceptorOne = new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request newRequest = chain.request().newBuilder()
                            .addHeader("key", WEBSTER_API_KEY)
                            .build();
                    return chain.proceed(newRequest);
                }
            };
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClient.addInterceptor(interceptorOne)
                    .addInterceptor(interceptor);
            retrofit = new Retrofit.Builder()
                    .baseUrl(WEBSTER_BASE_URL)
                    .client(okHttpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(WebsterApi.class);
    }
}

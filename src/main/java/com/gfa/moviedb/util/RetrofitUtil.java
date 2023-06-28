package com.gfa.moviedb.util;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitUtil {

    static String accessToken = System.getenv("accessToken");

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {

        Retrofit.Builder builder = null;
        if (retrofit == null) {

            // Create an OkHttpClient instance with an Interceptor
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(chain -> {
                Request originalRequest = chain.request();

                // Add header(s) to the original request
                Request modifiedRequest = originalRequest.newBuilder()
                        .header("Authorization", "Bearer " + accessToken)
                        .build();

                return chain.proceed(modifiedRequest);
            });

            builder = new Retrofit.Builder()
                    .baseUrl("https://api.themoviedb.org/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build());


        }
        assert builder != null;
        return builder.build();
    }
}

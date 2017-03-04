package by.black_pearl.userapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by BLACK_Pearl.
 */

public class RetrofitManager {

    public static Retrofit getRetrofit(String address) {
        return new Retrofit.Builder().baseUrl(address)
                .addConverterFactory(GsonConverterFactory.create()).build();
    }

    public interface ServerApiInterface {

        @GET("api/users")
        Call<List<UserData>> getUsersData();
    }
}

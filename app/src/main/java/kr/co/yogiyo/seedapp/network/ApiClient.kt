package kr.co.yogiyo.seedapp.network

import kr.co.yogiyo.seedapp.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

/**
 *  ex)
 *  Call<ResponseBody> call = ApiClient.retrofit.create(ApiStores::class.java).getRestaurants()
 */
object ApiClient {
    val retrofit: Retrofit by lazy {
        val builder = OkHttpClient.Builder().apply {
            if (BuildConfig.DEBUG) {
                val loggingInterceptor = HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
                addInterceptor(loggingInterceptor)
            }
        }

        val okHttpClient = builder
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .build()

        Retrofit.Builder()
            .baseUrl(ApiStores.BASE_URL)
            .client(okHttpClient)
            .build()
    }
}

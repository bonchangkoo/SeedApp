package kr.co.yogiyo.seedapp.network


/**
 *  ex)
 *  @GET("restful/restaurant") fun getRestaurants(): Call<ResponseBody>
 */

interface ApiStores {

    companion object {
        // Do not modify BASE_URL
        const val BASE_URL = "http://45.32.46.136:8001/"
    }
}

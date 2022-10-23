package tr.com.atakan.hdgbootcamp.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MockRetrofitClientApi {
    private const val apiToken = "" // TODO api yazılacak

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://crudcrud.com/api/$apiToken/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getApi(): MockApi = getRetrofit().create(MockApi::class.java)
}
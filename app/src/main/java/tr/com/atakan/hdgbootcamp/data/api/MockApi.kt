package tr.com.atakan.hdgbootcamp.data.api

import tr.com.atakan.hdgbootcamp.domain.model.Talk
import retrofit2.Response
import retrofit2.http.GET

interface MockApi {

    @GET("talks")
    suspend fun getTalks(): Response<List<Talk>>
}
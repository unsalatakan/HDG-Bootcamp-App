package tr.com.atakan.hdgbootcamp.data.repository

import tr.com.atakan.hdgbootcamp.data.api.MockApi
import tr.com.atakan.hdgbootcamp.domain.model.Talk
import tr.com.atakan.hdgbootcamp.domain.repository.TalkRepository

class RemoteTalkRepositoryImpl(private val api: MockApi) : TalkRepository {
    override suspend fun getTalks(): List<Talk> {
        return api.getTalks().body() ?: emptyList()
    }
}
package tr.com.atakan.hdgbootcamp.domain.repository

import tr.com.atakan.hdgbootcamp.domain.model.Talk

interface TalkRepository {
    suspend fun getTalks() : List<Talk>
}
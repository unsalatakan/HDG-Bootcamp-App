package tr.com.atakan.hdgbootcamp.domain.usecase

import tr.com.atakan.hdgbootcamp.domain.model.Talk
import tr.com.atakan.hdgbootcamp.domain.repository.TalkRepository

interface GetTalksUseCase {
    suspend fun getTalks() : List<Talk>
}

class GetTalksUseCaseImpl(private val repository: TalkRepository) : GetTalksUseCase {
    override suspend fun getTalks(): List<Talk> {
        return repository.getTalks()
    }
}
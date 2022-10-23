package tr.com.atakan.hdgbootcamp.ui.screen.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import tr.com.atakan.hdgbootcamp.data.repository.FakeTalkRepositoryImpl
import tr.com.atakan.hdgbootcamp.domain.usecase.GetTalksUseCase
import tr.com.atakan.hdgbootcamp.domain.usecase.GetTalksUseCaseImpl
import tr.com.atakan.hdgbootcamp.ui.model.Talk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {
    val talks = MutableLiveData<List<Talk>>()
    private val useCase: GetTalksUseCase = GetTalksUseCaseImpl(FakeTalkRepositoryImpl())

    fun getTalks() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = mutableListOf<Talk>()
            for (talk in useCase.getTalks()) {
                result.add(talk.toUiModel())
            }
            talks.postValue(result)
        }
    }
}
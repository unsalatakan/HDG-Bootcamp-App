package tr.com.atakan.hdgbootcamp.data.repository

import tr.com.atakan.hdgbootcamp.R
import tr.com.atakan.hdgbootcamp.domain.model.Minutes
import tr.com.atakan.hdgbootcamp.domain.model.Talk
import tr.com.atakan.hdgbootcamp.domain.repository.TalkRepository
import java.util.*

class FakeTalkRepositoryImpl : TalkRepository {
    override suspend fun getTalks(): List<Talk> {
        return listOf(
            Talk(
                id = "week5",
                title = "Huawei Mobile Services | #Week5 |",
                speaker = "Mert Kesgin",
                date = Date(1664726400000),
                duration = Minutes(75),
                subjects = setOf("Material Design", "Kotlin", "Android", "UI"),
                image = R.drawable.maxresdefault5
            ),
            Talk(
                id = "week4",
                title = "Kotlin Coroutine & Flow | #Week4 |",
                speaker = "Yener Çiftçi",
                date = Date(1664121600000),
                duration = Minutes(80),
                subjects = setOf("Coroutine", "Kotlin", "Android", "Flow"),
                image = R.drawable.maxresdefault4
            ),
            Talk(
                id = "week3",
                title = "Model Architecture | #Week3 |",
                speaker = "Erol Kaftanoğlu",
                date = Date(1663430400000),
                duration = Minutes(110),
                subjects = setOf("Model Architecture", "Kotlin", "Android", "UI"),
                image = R.drawable.maxresdefault3
            ),
            Talk(
                id = "week2-2",
                title = "Jetpack Compose | #Week2 #Day2 |",
                speaker = "Mert Topbaş",
                date = Date(1662912000000),
                duration = Minutes(120),
                subjects = setOf("Jetpack Compose", "Kotlin", "Android", "UI"),
                image = R.drawable.maxresdefault2
            ),
            Talk(
                id = "week2-1",
                title = "Jetpack Compose Bootcamp | #Week2 #Day1 |",
                speaker = "Mert Topbaş",
                date = Date(1662825600000),
                duration = Minutes(90),
                subjects = setOf("Jetpack Compose", "Kotlin", "Android", "UI"),
                image = R.drawable.maxresdefault2
            ),
            Talk(
                id = "week1",
                title = "Material Design | #Week1 #Day1 |",
                speaker = "Ali Şahin Aydoğan",
                date = Date(1662307200000),
                duration = Minutes(45),
                subjects = setOf("Material Design", "Kotlin", "Android", "UI"),
                image = R.drawable.maxresdefault
            )
        )
    }
}
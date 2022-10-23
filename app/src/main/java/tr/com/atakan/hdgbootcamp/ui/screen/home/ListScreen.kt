package tr.com.atakan.hdgbootcamp.ui.screen.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import tr.com.atakan.hdgbootcamp.R
import tr.com.atakan.hdgbootcamp.ui.screen.home.widget.TalkCard
import tr.com.atakan.hdgbootcamp.ui.model.Talk
import tr.com.atakan.hdgbootcamp.ui.theme.TechTalkAppTheme

@Composable
fun ListScreen(talksLiveData: LiveData<List<Talk>>, onRefresh: () -> Unit) {
    val talks by talksLiveData.observeAsState(initial = emptyList())

    Scaffold(
        backgroundColor = MaterialTheme.colors.primarySurface,
        topBar = { AppBar(onRefresh) }) {
        TalksList(talks)
    }
}

@Composable
private fun AppBar(onRefresh: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "",
            style = MaterialTheme.typography.h5,
            color = Color.White,
            fontFamily = FontFamily.SansSerif,
            fontSize = 22.sp
        )
        IconButton(
            modifier = Modifier.padding(0.dp).size(0.dp,0.dp),
            onClick = onRefresh
        ) {
            Icon(
                imageVector = Icons.Filled.Refresh,
                contentDescription = stringResource(R.string.reload)
            )
        }
        Icon(
            painterResource(id = R.drawable.logo),
            contentDescription = "",
            modifier = Modifier.size(70.dp,70.dp).padding(10.dp),
            tint = MaterialTheme.colors.secondary
        )
        IconButton(
            modifier = Modifier.padding(16.dp),
            onClick = onRefresh
        ) {
            Icon(
                imageVector = Icons.Filled.Refresh,
                contentDescription = stringResource(R.string.reload)
            )
        }
    }
}

@Composable
fun TalksList(talks: List<Talk>) = LazyColumn {
    items(talks) { talk ->
        TalkCard(talk = talk)
    }
}

@Preview
@Composable
fun ListScreenExample() {
    TechTalkAppTheme {
        val liveData = MutableLiveData(
            listOf(
                Talk(
                    title = "Eğitim Bulunamadı",
                    speaker = "Konuşmacı Yok",
                    date = "01/07/2021 16:00",
                    duration = 60,
                    subjects = setOf("Android", "Kotlin", "Jetpack Compose"),
                    image = R.drawable.banner
                ),
            )
        )
        ListScreen(liveData) { }
    }
}
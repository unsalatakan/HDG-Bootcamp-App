package tr.com.atakan.hdgbootcamp.ui.screen.home.widget

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.HourglassEmpty
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tr.com.atakan.hdgbootcamp.R
import tr.com.atakan.hdgbootcamp.ui.model.Talk
import tr.com.atakan.hdgbootcamp.ui.theme.PantoneYellow
import tr.com.atakan.hdgbootcamp.ui.theme.TechTalkAppTheme
import tr.com.atakan.hdgbootcamp.ui.widget.Chip

@OptIn(ExperimentalMaterialApi::class, ExperimentalAnimationApi::class)
@Composable
fun TalkCard(talk: Talk) {
    var visible by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = 8.dp,
        onClick = { if (talk.subjects.isNotEmpty()) visible = !visible },
        shape = RoundedCornerShape(18.dp)
    ) {
        Column {
            val typography = MaterialTheme.typography
            Image(
                painter = painterResource(id = talk.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .background(Color.DarkGray)
                    .height(210.dp)
                    .fillMaxWidth()
            )
            Column(Modifier.padding(16.dp)) {
                Text(text = talk.title, style = typography.h6)
                Text(text = talk.speaker, style = typography.body2)
                Row(
                    modifier = Modifier.padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.CalendarToday,
                        contentDescription = stringResource(R.string.date),
                        tint = PantoneYellow,
                        modifier = Modifier.padding(end = 16.dp)
                    )
                    Text(text = talk.date)
                }
                Row(
                    modifier = Modifier.padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.HourglassEmpty,
                        contentDescription = stringResource(R.string.duration),
                        tint = PantoneYellow,
                        modifier = Modifier.padding(end = 16.dp)
                    )
                    Text(text = "${talk.duration} min")
                }

                if (talk.subjects.isNotEmpty()) {
                    AnimatedVisibility(visible = visible) {
                        Column {
                            Spacer(modifier = Modifier.padding(8.dp))
                            Text(
                                text = stringResource(R.string.subjects),
                                style = typography.body2
                            )
                            Spacer(modifier = Modifier.padding(8.dp))
                            Row {
                                talk.subjects.forEach { subject ->
                                    Chip(subject)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ExampleTalkCard() {
    TechTalkAppTheme {
        TalkCard(
            talk = Talk(
                title = "",
                speaker = "",
                date = "01/07/2021 16:00",
                duration = 60,
                subjects = emptySet(),
                image = R.drawable.banner
            )
        )
    }
}

@Preview(name = "", fontScale = 1.5f, locale = "en")
@Composable
fun ExampleTalkCardWithSubjects() {
    TechTalkAppTheme {
        TalkCard(
            talk = Talk(
                title = "",
                speaker = "",
                date = "01/07/2021 16:00",
                duration = 60,
                subjects = setOf("Android", "Kotlin", "Jetpack Compose"),
                image = R.drawable.banner
            )
        )
    }
}
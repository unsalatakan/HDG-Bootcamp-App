package tr.com.atakan.hdgbootcamp.ui.screen.home.widget

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import tr.com.atakan.hdgbootcamp.ui.model.Talk
import tr.com.atakan.hdgbootcamp.ui.theme.TechTalkAppTheme
import org.junit.Rule
import org.junit.Test

class TalkCardTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testTalkCard() {
        composeTestRule.run {
            setContent {
                TechTalkAppTheme {
                    TalkCard(
                        talk = Talk(
                            title = "Title",
                            speaker = "Speaker",
                            date = "01/01/2021 12:00",
                            duration = 60,
                            subjects = setOf("Subject1", "Subject2")
                        )
                    )
                }
            }

            onNodeWithText("Title").assertIsDisplayed()
            onNodeWithText("Speaker").assertIsDisplayed()
            onNodeWithText("01/01/2021 12:00").assertIsDisplayed()
            onNodeWithText("60 min").assertIsDisplayed()
            onRoot().performClick()
            onNodeWithText("Subject1").assertIsDisplayed()
            onNodeWithText("Subject2").assertIsDisplayed()
        }
    }
}
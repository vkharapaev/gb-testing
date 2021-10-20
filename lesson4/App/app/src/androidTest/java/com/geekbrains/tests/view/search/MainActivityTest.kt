package com.geekbrains.tests.view.search

import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.pressImeActionButton
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.geekbrains.tests.R
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setUp() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun activity_AssertNotNull() {
        scenario.onActivity {
            assertNotNull(it)
        }
    }

    @Test
    fun activity_isInResumeState() {
        assertEquals(scenario.state, Lifecycle.State.RESUMED)
    }

    @Test
    fun activity_EditTextIsVisible() {
        onView(withId(R.id.searchEditText)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }

    @Test
    fun activity_EditTextIsOnScreen() {
        onView(withId(R.id.searchEditText)).check(matches(isDisplayed()))
    }

    @Test
    fun activity_isButtonVisible() {
        onView(withId(R.id.toDetailsActivityButton)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }

    @Test
    fun activity_isOnScreen() {
        onView(withId(R.id.toDetailsActivityButton)).check(matches(isDisplayed()))
    }

    @Test
    fun activity_ButtonTextIsOk() {
        onView(withId(R.id.toDetailsActivityButton)).check(matches(withText("TO DETAILS")))
    }

    @Test
    fun activity_EditText_HintTextIsCorrect() {
        onView(withId(R.id.searchEditText)).check(matches(withHint("Enter keyword e.g. android")))
    }

    @Test
    fun activity_MakeRequest() {
        onView(withId(R.id.searchEditText)).perform(typeText("algol"))
        onView(withId(R.id.searchEditText)).perform(pressImeActionButton())
        Thread.sleep(5000)
        scenario.onActivity {
            val size = it.findViewById<RecyclerView>(R.id.recyclerView).adapter?.itemCount ?: -1
            assertTrue(size > 0)
        }
    }

    @After
    fun tearDown() {
        scenario.close()
    }
}
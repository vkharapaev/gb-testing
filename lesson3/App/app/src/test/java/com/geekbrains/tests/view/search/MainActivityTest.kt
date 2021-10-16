package com.geekbrains.tests.view.search

import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.geekbrains.tests.R
import junit.framework.TestCase
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest : TestCase() {

    lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    public override fun setUp() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun activity_AssertNotNull() {
        assertNotNull(scenario)
    }

    @Test
    fun activity_IsResumed() {
        assertEquals(Lifecycle.State.RESUMED, scenario.state)
    }

    @Test
    fun activityEditText_notNull() {
        scenario.onActivity {
            assertNotNull(it.findViewById(R.id.searchEditText))
        }
    }

    @Test
    fun activityEditText_isVisible() {
        scenario.onActivity {
            val editText: EditText = it.findViewById(R.id.searchEditText)
            assertEquals(View.VISIBLE, editText.visibility)
            assertNotNull(it.findViewById(R.id.searchEditText))
        }
    }

    @Test
    fun activityRecyclerView_isNotNull() {
        scenario.onActivity {
            assertNotNull(it.findViewById(R.id.recyclerView))
        }
    }

    @Test
    fun activityRecyclerView_isVisible() {
        scenario.onActivity {
            val recyclerView: RecyclerView = it.findViewById(R.id.recyclerView)
            assertEquals(View.VISIBLE, recyclerView.visibility)
        }
    }

    @Test
    fun activityEditText_fetchData() {
        scenario.onActivity {
            val editText: EditText = it.findViewById(R.id.searchEditText)
            editText.setText("java")
            editText.onEditorAction(EditorInfo.IME_ACTION_SEARCH)
            Thread.sleep(2000)
            val recyclerView: RecyclerView = it.findViewById(R.id.recyclerView)
            assertTrue(recyclerView.adapter?.itemCount ?: 0 > 0)
        }
    }

    @After
    public override fun tearDown() {
        scenario.close()
    }
}
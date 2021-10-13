package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter

import com.github.terrakok.cicerone.Screen
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.navigation.IRouter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.navigation.IScreens

class MainPresenterTest {

    @Mock
    private lateinit var router: IRouter

    @Mock
    private lateinit var screens: IScreens

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun test_onFirstViewAttach() {
        val userScreen = mock(Screen::class.java)
        `when`(screens.users()).thenReturn(userScreen)
        MainPresenter(router, screens).onFirstViewAttach()
        verify(router, times(1)).replaceScreen(userScreen)
    }

    @Test
    fun test_BackClick() {
        MainPresenter(router, screens).backClick()
        verify(router, times(1)).exit()
    }
}
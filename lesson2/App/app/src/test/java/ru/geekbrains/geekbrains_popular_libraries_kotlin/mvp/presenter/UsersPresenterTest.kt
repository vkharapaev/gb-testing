package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter

import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.navigation.IRouter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter.repositories.IGithubUsersRepo
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view.`UsersView$$State`

class UsersPresenterTest {

    @Mock
    private lateinit var router: IRouter

    @Mock
    private lateinit var githubUserRepository: IGithubUsersRepo

    @Mock
    private lateinit var view: `UsersView$$State`

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun test_onFirstViewAttach() {
        val presenter = UsersPresenter(githubUserRepository, router)
        presenter.setViewState(view)
        presenter.onFirstViewAttach()
        verify(view, times(1)).init()
        verify(view, times(1)).updateList()
    }

    @Test
    fun test_backClick() {
        UsersPresenter(githubUserRepository, router).backClick()
        verify(router, times(1)).exit()
    }
}
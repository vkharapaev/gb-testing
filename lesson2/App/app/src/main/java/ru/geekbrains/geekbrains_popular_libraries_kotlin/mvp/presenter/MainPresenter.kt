package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter

import moxy.MvpPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.navigation.IRouter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.navigation.IScreens
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view.MainView

class MainPresenter(private val router: IRouter, private val screens: IScreens) :
    MvpPresenter<MainView>() {

    public override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.users())
    }

    fun backClick() {
        router.exit()
    }
}
package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.navigation

import com.github.terrakok.cicerone.Screen

interface IRouter {
    fun replaceScreen(screen: Screen)
    fun exit()
}
package ru.geekbrains.geekbrains_popular_libraries_kotlin.ui

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.navigation.IRouter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.navigation.AndroidRouter

class App : Application() {

    companion object {
        lateinit var instance: App
    }

    private val _router = AndroidRouter()

    val router: IRouter get() = _router

    private val cicerone: Cicerone<Router> by lazy {
        Cicerone.create(_router)
    }

    val navigatorHolder get() = cicerone.getNavigatorHolder()

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
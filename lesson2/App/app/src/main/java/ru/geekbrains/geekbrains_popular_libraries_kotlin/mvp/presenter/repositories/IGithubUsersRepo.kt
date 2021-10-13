package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter.repositories

import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.GithubUser

interface IGithubUsersRepo {
    fun getUsers(): List<GithubUser>
}
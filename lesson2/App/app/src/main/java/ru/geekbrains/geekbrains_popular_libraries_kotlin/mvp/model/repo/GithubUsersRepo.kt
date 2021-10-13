package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.repo

import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.GithubUser
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter.repositories.IGithubUsersRepo

class GithubUsersRepo: IGithubUsersRepo {
    private val users = listOf(
        GithubUser("login1"),
        GithubUser("login2"),
        GithubUser("login3"),
        GithubUser("login4"),
        GithubUser("login5"),
        GithubUser("login6"),
        GithubUser("login7"),
    )

    override fun getUsers(): List<GithubUser> {
        return users
    }
}
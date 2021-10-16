package com.geekbrains.tests.presenter.search

import com.geekbrains.tests.presenter.PresenterContract
import com.geekbrains.tests.view.search.ViewSearchContract

internal interface PresenterSearchContract : PresenterContract<ViewSearchContract> {
    fun searchGitHub(searchQuery: String)
}

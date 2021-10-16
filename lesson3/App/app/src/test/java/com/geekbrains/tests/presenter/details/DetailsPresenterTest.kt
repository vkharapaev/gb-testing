package com.geekbrains.tests.presenter.details

import com.geekbrains.tests.view.details.ViewDetailsContract
import com.nhaarman.mockito_kotlin.only
import com.nhaarman.mockito_kotlin.verify
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class DetailsPresenterTest : TestCase() {

    @Mock
    private lateinit var view: ViewDetailsContract

    @Before
    override fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testIncrement_onIncrement() {
        val presenter = DetailsPresenter(10)
        presenter.onAttach(view)
        presenter.onIncrement()
        verify(view, only()).setCount(11)
    }

    @Test
    fun testIncrement_onDecrement() {
        val presenter = DetailsPresenter(10)
        presenter.onAttach(view)
        presenter.onDecrement()
        verify(view, only()).setCount(9)
    }
}
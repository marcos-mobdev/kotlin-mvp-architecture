package br.com.appforge.kotlinmvparchitecture.presenter

import br.com.appforge.kotlinmvparchitecture.model.Post

interface IPostPresenter {
    fun showPosts(list: List<Post>)
    fun loading(showLoading: Boolean)
}
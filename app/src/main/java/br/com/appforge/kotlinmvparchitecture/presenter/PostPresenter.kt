package br.com.appforge.kotlinmvparchitecture.presenter
import br.com.appforge.kotlinmvparchitecture.model.api.PostAPI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class PostPresenter (// What will be displayed
    private val view: IPostPresenter,
    private val postAPI: PostAPI
){
    private val coroutine = CoroutineScope(Dispatchers.IO)

    fun getPosts(){
        view.loading(true)
        coroutine.launch {
            val posts = postAPI.getPosts()

            withContext(Dispatchers.Main){
                view.showPosts(posts)
                view.loading(false)
            }

        }
    }

    fun onDestroy(){
        coroutine.cancel()
    }

}
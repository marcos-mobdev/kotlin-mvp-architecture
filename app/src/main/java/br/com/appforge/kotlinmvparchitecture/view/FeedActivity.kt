package br.com.appforge.kotlinmvparchitecture.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.appforge.kotlinmvparchitecture.R
import br.com.appforge.kotlinmvparchitecture.databinding.ActivityFeedBinding
import br.com.appforge.kotlinmvparchitecture.model.Post
import br.com.appforge.kotlinmvparchitecture.model.api.PostAPI
import br.com.appforge.kotlinmvparchitecture.presenter.IPostPresenter
import br.com.appforge.kotlinmvparchitecture.presenter.PostPresenter

class FeedActivity : AppCompatActivity(), IPostPresenter{

    private val binding by lazy{
        ActivityFeedBinding.inflate(layoutInflater)
    }

    //Instance of Presenter
    private lateinit var postPresenter: PostPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //Instance of API
        val postAPI = PostAPI()
        //Initializing Presenter
        postPresenter = PostPresenter(this,postAPI)

    }

    override fun onStart() {
        super.onStart()
        postPresenter.getPosts()
    }

    override fun showPosts(list: List<Post>) {
        var postsText = ""
        list.forEach { post->
            postsText += "${post.id} - ${post.title}\n"
        }
        binding.textView.text = postsText
    }

    override fun loading(showLoading: Boolean) {

    }


}
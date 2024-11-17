 package br.com.appforge.kotlinmvparchitecture.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import br.com.appforge.kotlinmvparchitecture.databinding.ActivityMainBinding
import br.com.appforge.kotlinmvparchitecture.model.Post
import br.com.appforge.kotlinmvparchitecture.model.api.PostAPI
import br.com.appforge.kotlinmvparchitecture.presenter.IPostPresenter
import br.com.appforge.kotlinmvparchitecture.presenter.PostPresenter

 class MainActivity : AppCompatActivity(), IPostPresenter { //Added PostPresenter interface
     //How will be displayed

     private val binding by lazy{
         ActivityMainBinding.inflate(layoutInflater)
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

        binding.btnGetPosts.setOnClickListener {
            postPresenter.getPosts()
        }

        binding.btnNavigate.setOnClickListener {
            startActivity(Intent(this,FeedActivity::class.java))
        }
    }

     override fun onDestroy() {
         super.onDestroy()
         postPresenter.onDestroy()
     }

     override fun showPosts(list: List<Post>) {
        var postsText = ""
         list.forEach { post->
             postsText += "${post.id} - ${post.title}\n"
        }
         binding.textView.text = postsText
     }

     override fun loading(showLoading: Boolean) {
         if(showLoading){
             binding.progressBar.visibility = View.VISIBLE
         }else{
             binding.progressBar.visibility = View.INVISIBLE
         }
     }


 }
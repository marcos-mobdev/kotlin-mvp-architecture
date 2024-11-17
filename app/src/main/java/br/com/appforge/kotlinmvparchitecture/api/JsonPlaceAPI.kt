package br.com.appforge.kotlinmvparchitecture.api

import br.com.appforge.kotlinmvparchitecture.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface JsonPlaceAPI {

    @GET("posts")
    suspend fun getPosts(): Response< List<Post> >

}
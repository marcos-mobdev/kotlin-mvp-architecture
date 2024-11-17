package br.com.appforge.kotlinmvparchitecture.model

data class Post(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)
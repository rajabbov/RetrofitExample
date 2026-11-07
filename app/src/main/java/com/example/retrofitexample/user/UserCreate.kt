package com.example.retrofitexample.user

data class UserCreate(
    val createdAt: String,
    val id: String,
    val job: String,
    val name: String
)
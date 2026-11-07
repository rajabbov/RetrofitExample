package com.example.retrofitexample.user

import com.example.retrofitexample.user.User
import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("data")
    val user: User
)

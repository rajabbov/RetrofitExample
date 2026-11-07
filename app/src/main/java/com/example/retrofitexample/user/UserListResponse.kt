package com.example.retrofitexample.user

import com.example.retrofitexample.user.Support
import com.example.retrofitexample.user.User
import com.google.gson.annotations.SerializedName

data class UserListResponse(
    @SerializedName("data")
    val userList: List<User>,
    val page: Int,
    val per_page: Int,
    val support: Support,
    val total: Int,
    val total_pages: Int
)
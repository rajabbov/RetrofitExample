package com.example.retrofitexample

import com.example.retrofitexample.todo.Todo
import com.example.retrofitexample.user.UserCreate
import com.example.retrofitexample.user.UserListResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {
    @GET("/todos")
    suspend fun getTodoList(): Response<List<Todo>>

    @GET("/api/users")
    suspend fun getAllUserByPage(@Query("page") page: Int): Response<UserListResponse>

    @GET("/api/users/{id}")
    suspend fun getUserById(@Path("id") userId: Int): Response<UserListResponse>

    @POST("/api/users")
    suspend fun createUser(@Body userCreate: UserCreate): Response<UserCreate>

    @DELETE("/api/users/{id}")
    suspend fun deleteUser(@Path("id") userId: Int): Response<Unit>

}
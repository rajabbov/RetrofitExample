package com.example.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitexample.databinding.ActivityMainBinding
import com.example.retrofitexample.todo.TodoAdapter
import com.example.retrofitexample.user.User
import com.example.retrofitexample.user.UserAdapter
import com.example.retrofitexample.user.UserCreate
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var todoAdapter: TodoAdapter
    private lateinit var userAdapter: UserAdapter
    val TAG = "TAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        todoAdapter = TodoAdapter()
        val retrofit = Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://reqres.in")
            .build()
        val api = retrofit.create(ApiInterface::class.java)
        lifecycleScope.launch {



        }

//        lifecycleScope.launch {
//            val response = api.createUser(UserCreate("", "", "Mobile developer", "Ibrohimjon"))
//            if (response.isSuccessful) {
//                Log.d(TAG, "onCreate: ${response.body()}")
//            } else {
//                Log.d(TAG, "onCreate: Sorry something with creating")
//            }
//        }
//        lifecycleScope.launch {
//            val response = api.deleteUser(2)
//            if (response.isSuccessful) {
//                Log.d(TAG, "onCreate: ${response.body()} ${response.code()}")
//            } else {
//                Log.d(TAG, "onCreate: Sorry something with creating")
//            }
//        }

//        lifecycleScope.launch {
//            val response = api.getTodoList().body()
//            response?.apply {
//                todoAdapter.submitList(this)
//            }
//            Log.d("TAG", "onCreate: ${response?.joinToString()}")
//        }
        userAdapter = UserAdapter()
        val manager = LinearLayoutManager(this@MainActivity)
        binding.recyclerView.apply {
            adapter = todoAdapter
            layoutManager = manager
            adapter = userAdapter
            addItemDecoration(DividerItemDecoration(this@MainActivity, manager.orientation))
        }

        val flow : Flow<PagingData<User>> = Pager(
            config = PagingConfig(pageSize = 3, enablePlaceholders = false),
            pagingSourceFactory = {UserPagingSource(api)}
        ).flow

    }
}
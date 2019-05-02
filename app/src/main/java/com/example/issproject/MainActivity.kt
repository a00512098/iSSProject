package com.example.issproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.issproject.datasource.ResponseObserver
import com.example.issproject.datasource.ResponseRepo
import com.example.issproject.model.ApiResponse
import com.example.issproject.model.Response
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity(), ResponseObserver.ResponseCallback {

    private var positionsList: ArrayList<Response> = ArrayList()
    private val responseRepo: ResponseRepo = ResponseRepo()
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayoutManager = LinearLayoutManager(this)
        adapter = RecyclerAdapter(positionsList)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        if (positionsList.size == 0) {
            responseRepo.getResponse(this)
        }
    }

    override fun onSuccess(response: ApiResponse) {
    }

    override fun onError(e: Throwable) {
    }
}

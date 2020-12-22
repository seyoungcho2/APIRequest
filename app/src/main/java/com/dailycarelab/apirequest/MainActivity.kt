package com.dailycarelab.apirequest

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dailycarelab.apirequest.dto.PlayerList
import com.dailycarelab.apirequest.retrofit.RetrofitClient
import com.dailycarelab.apirequest.retrofit.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


class MainActivity : AppCompatActivity() {

    private val TAG = this::class.java.simpleName
    private lateinit var retrofit : Retrofit
    private lateinit var supplementService : RetrofitService

    lateinit var textView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRetrofit()


        textView = findViewById(R.id.textView)
        findViewById<Button>(R.id.button).setOnClickListener {
            getSearchList(supplementService, "morris")
        }
    }

    private fun initRetrofit(){

        retrofit = RetrofitClient.getInstance()
        supplementService = retrofit.create(RetrofitService::class.java)
    }

    private fun getSearchList(service: RetrofitService, keyword: String){
        service.requestList(keyword).enqueue(object : Callback<PlayerList> {
            override fun onFailure(call: Call<PlayerList>, t: Throwable) {
                Log.d(TAG, "실패 : {$t}")
            }

            override fun onResponse(
                call: Call<PlayerList>,
                response: Response<PlayerList>
            ) {
                Log.d(TAG, "성공")
                textView.text = response.body().toString()
                //reponse.body()는 PlayerList를 반환한다.
            }
        })
    }
}
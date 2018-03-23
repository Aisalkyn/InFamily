package com.example.nestana.infamily.ui.articles

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.nestana.infamily.R
import com.example.nestana.infamily.utils.ApplicationClass

class ArticlesActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articles)
    }



    fun init(){
        val app = this.applicationContext as ApplicationClass

    }

    fun initRecyclerView(){

    }


}

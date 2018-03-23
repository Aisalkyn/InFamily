package com.example.nestana.infamily.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.nestana.infamily.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        children.setOnClickListener {
            //intent = Intent(this, ChildActivity.class::java)
        }


    }
}

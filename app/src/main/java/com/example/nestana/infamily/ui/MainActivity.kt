package com.example.nestana.infamily

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.nestana.infamily.categories.CategoriesActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){
    companion object {
        val SECTION_ID: String="category_id"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var intent = Intent(this, CategoriesActivity::class.java)
        childrenSection.setOnClickListener{
            intent.putExtra(SECTION_ID,1)
            startActivity(intent)
        }
        parentsSection.setOnClickListener{
            intent.putExtra(SECTION_ID,2)
            startActivity(intent)
        }
        futureParentsSection.setOnClickListener{
            intent.putExtra(SECTION_ID,3)
            startActivity(intent)
        }
    }



}

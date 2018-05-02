package com.example.nestana.infamily

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.nestana.infamily.ui.FutureParentsActivity
import com.example.nestana.infamily.ui.categories.CategoriesActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){
    companion object {
        val SECTION_ID: String="section_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = Intent(this, CategoriesActivity::class.java)
        childrenSection.setOnClickListener{
            intent.putExtra(SECTION_ID,1)
            startActivity(intent)
        }
        parentsSection.setOnClickListener{
            intent.putExtra(SECTION_ID,2)
            startActivity(intent)
        }
        futureParentsSection.setOnClickListener{
            val myIntent = Intent(this, FutureParentsActivity::class.java)
            startActivity(myIntent)
        }
    }



}

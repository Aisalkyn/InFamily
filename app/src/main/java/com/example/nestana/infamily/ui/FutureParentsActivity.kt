package com.example.nestana.infamily.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.nestana.infamily.R
import com.example.nestana.infamily.ui.adoption_info.AdoptionInfoActivity
import com.example.nestana.infamily.ui.check_document_list.CheckListActivity
import com.example.nestana.infamily.ui.quiz.QuizActivity
import kotlinx.android.synthetic.main.activity_future_parents.*

class FutureParentsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_future_parents)
        cvAdoptInfo.setOnClickListener{
            val myIntent = Intent(this, AdoptionInfoActivity::class.java)
            startActivity(myIntent)
        }

        cvFindDocs.setOnClickListener{
            val myIntent = Intent(this, CheckListActivity::class.java)
            startActivity(myIntent)
        }

        cvParentTest.setOnClickListener{
            val myIntent = Intent(this, QuizActivity::class.java)
            startActivity(myIntent)
        }

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id: Int = item!!.itemId
        if (id == android.R.id.home){
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}

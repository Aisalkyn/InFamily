package com.example.nestana.infamily.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.nestana.infamily.R
import com.example.nestana.infamily.ui.check_document_list.CheckListActivity
import kotlinx.android.synthetic.main.activity_future_parents.*

class FutureParentsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_future_parents)
        cvAdoptInfo.setOnClickListener{

        }

        cvFindDocs.setOnClickListener{
            val myIntent = Intent(this, CheckListActivity::class.java)
            startActivity(myIntent)
        }

        cvParentTest.setOnClickListener{

        }
    }




}

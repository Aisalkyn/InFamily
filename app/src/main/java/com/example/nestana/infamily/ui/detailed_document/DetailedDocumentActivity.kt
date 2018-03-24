package com.example.nestana.infamily.ui.detailed_document

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.nestana.infamily.R
import com.example.nestana.infamily.model.Document
import com.example.nestana.infamily.ui.check_document_list.CheckListActivity
import kotlinx.android.synthetic.main.activity_detailed_document.*

class DetailedDocumentActivity : AppCompatActivity() {
    var mDocument: Document? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_document)

        mDocument = intent.getParcelableExtra(CheckListActivity.PARCED_DOCUMENT)

        init()
    }


    fun init() {
        tvTitleDetailedDocument.text = mDocument!!.title
        tvDescDetailedDocument.text = mDocument!!.description
        tvPhoneDetailedDocument.text = mDocument!!.contacts
        tvScheduleDetailedDocument.text = mDocument!!.schedule
        tvAddressDetailedDocument.text = mDocument!!.address
    }

}

package com.example.nestana.infamily.ui.detailed_document

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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

        tvPhoneDetailedDocument.setOnClickListener {
            showAlertViewCall()
        }
        tvAddressDetailedDocument.setOnClickListener {
            showAlertViewMap()

            //Toast.makeText(this, " map", Toast.LENGTH_LONG).show()
        }
    }

    private fun showAlertViewCall(
    ) {
        val simpleAlert = AlertDialog.Builder(this).create()
            simpleAlert.setTitle(R.string.call)
            simpleAlert.setMessage("Позвонить на этот номер? " + "\n" + mDocument!!.contacts)
            simpleAlert.setButton(AlertDialog.BUTTON_POSITIVE, "Позврнить", { dialogInterface, which ->
                val callIntent = Intent(Intent.ACTION_DIAL)
                val p = "tel:" + mDocument!!.contacts
                callIntent.data = Uri.parse(p)
                startActivity(callIntent)
            })
            simpleAlert.setButton(AlertDialog.BUTTON_NEGATIVE, "Отменить", { dialogInterface, i ->
                simpleAlert.dismiss()
            })


        simpleAlert.show()
    }
    private fun showAlertViewMap(
    ) {
        val simpleAlert = AlertDialog.Builder(this).create()
        simpleAlert.setTitle(R.string.open_map)
        simpleAlert.setMessage("Показать на карте? " + "\n" + mDocument!!.address)
        simpleAlert.setButton(AlertDialog.BUTTON_POSITIVE, "Открыть", { dialogInterface, which ->
            val mapIntent = Intent(this, MapActivity::class.java)
            val p = "url:" + mDocument!!.contacts
            mapIntent.data = Uri.parse(p)
            startActivity(mapIntent)
        })
        simpleAlert.setButton(AlertDialog.BUTTON_NEGATIVE, "Отменить", { dialogInterface, i ->
            simpleAlert.dismiss()
        })


        simpleAlert.show()
    }

}

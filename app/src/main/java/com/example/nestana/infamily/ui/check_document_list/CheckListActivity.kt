package com.example.nestana.infamily.ui.check_document_list

import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.MenuItem
import android.view.View
import com.example.nestana.infamily.R
import com.example.nestana.infamily.model.Document
import com.example.nestana.infamily.ui.PhotoAnalyzeActivity
import com.example.nestana.infamily.ui.check_document_list.adapter.DocumentAdapter
import com.example.nestana.infamily.ui.check_document_list.adapter.ImageAdapter
import com.example.nestana.infamily.ui.detailed_document.DetailedDocumentActivity
import com.example.nestana.infamily.utils.ApplicationClass
import kotlinx.android.synthetic.main.activity_categories.*
import kotlinx.android.synthetic.main.activity_check_list.*
import org.jetbrains.anko.toast

class CheckListActivity : PhotoAnalyzeActivity(), CheckListContract.View, DocumentAdapter.OnItemClickListener, View.OnClickListener {

    companion object {
        val PARCED_DOCUMENT = "parced_document"
    }



    override fun onClick(v: View?) {
        if (v == ivAddPhotoDocument) {
            showPickImageDialog()
        }else if (v == btSendDocument){
            showChooseOptionDialog()

        }
    }


    var mAdapter: DocumentAdapter? = null
    var mDocumentList: List<Document>? = null
    var mPresenter: CheckListPresenter? = null

    var mImagePaths: ArrayList<String>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_list)



        init()
    }

    fun showChooseOptionDialog() {

        val dialogClickListener = DialogInterface.OnClickListener { dialog, which ->
            when (which) {
                DialogInterface.BUTTON_POSITIVE -> {
                    toast("Отправлено на проверку")
                }

                DialogInterface.BUTTON_NEGATIVE -> {
                    dialog.dismiss()
                }
            }
        }

        val builder = AlertDialog.Builder(this)
        builder.setMessage("Вы согласны с отправкой данных документа на сервер? " ).setPositiveButton("Да", dialogClickListener)
                .setNegativeButton("Нет", dialogClickListener).show()
    }
    fun init() {
        ivAddPhotoDocument.setOnClickListener(this)
        val app = this.applicationContext as ApplicationClass
        mPresenter = CheckListPresenter(app.service!!, this, this)
        mPresenter!!.loadDocuments()
        btSendDocument.setOnClickListener(this)
        initRecyclerView()
        viewPagerOfImage.adapter = ImageAdapter(this, arrayListOf(""))
        indicator.setViewPager(viewPagerOfImage)
    }

    fun initRecyclerView(){
        mAdapter = DocumentAdapter(ArrayList(), this)
        rvDocumentList.adapter = mAdapter
        rvDocumentList.layoutManager = LinearLayoutManager(this)
    }
    override fun setImagePaths(imgPaths: ArrayList<String>?) {
        mImagePaths = imgPaths
        viewPagerOfImage.adapter = ImageAdapter(this, mImagePaths)
    }
    override fun onSuccess(documentList: List<Document>?) {
        mDocumentList = documentList
        mAdapter!!.setList(mDocumentList!!)
    }

    override fun onFail(message: String) {
        toast(message)
    }

    override fun onItemClick(document: Document) {
        val myIntent = Intent(this, DetailedDocumentActivity::class.java)
        myIntent.putExtra(PARCED_DOCUMENT, document)
        startActivity(myIntent)
    }


}

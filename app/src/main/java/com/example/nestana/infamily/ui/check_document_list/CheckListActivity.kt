package com.example.nestana.infamily.ui.check_document_list

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.MenuItem
import com.example.nestana.infamily.R
import com.example.nestana.infamily.model.Document
import com.example.nestana.infamily.ui.check_document_list.adapter.DocumentAdapter
import com.example.nestana.infamily.utils.ApplicationClass
import kotlinx.android.synthetic.main.activity_categories.*
import kotlinx.android.synthetic.main.activity_check_list.*
import org.jetbrains.anko.toast

class CheckListActivity : AppCompatActivity(), CheckListContract.View, DocumentAdapter.OnItemClickListener {

    var mAdapter: DocumentAdapter? = null
    var mDocumentList: List<Document>? = null
    var mPresenter: CheckListPresenter? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_list)
        init()
    }


    fun init() {
        initToolbar()
        val app = this.applicationContext as ApplicationClass
        mPresenter = CheckListPresenter(app.service!!, this, this)
        mPresenter!!.loadDocuments()
        initRecyclerView()
    }

    fun initRecyclerView(){
        mAdapter = DocumentAdapter(ArrayList(), this)
        rvDocumentList.layoutManager = LinearLayoutManager(this)
        rvCategoryList.adapter = mAdapter
    }

    override fun onSuccess(documentList: List<Document>?) {
        mDocumentList = documentList
        mAdapter!!.setList(mDocumentList!!)
    }

    override fun onFail(message: String) {
        toast(message)
    }

    override fun onItemClick(document: Document) {

    }
    fun initToolbar(){
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id =item!!.itemId
        if (id == android.R.id.home){
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}

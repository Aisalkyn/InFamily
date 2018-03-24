package com.example.nestana.infamily.ui.categories

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.example.nestana.infamily.MainActivity
import com.example.nestana.infamily.R
import com.example.nestana.infamily.ui.categories.adapter.CategoryAdapter
import com.example.nestana.infamily.model.Category
import com.example.nestana.infamily.ui.adaption_info.AdoptionInfoActivity
import com.example.nestana.infamily.utils.ApplicationClass
import kotlinx.android.synthetic.main.activity_categories.*
import org.jetbrains.anko.toast
import java.text.FieldPosition

class CategoriesActivity : AppCompatActivity(), CategoriesContract.View, CategoryAdapter.OnItemClickListener {
    var mAdapter: CategoryAdapter? = null
    var mSectionId: Int? = null
    companion object {
        val CATEGORY_ID: String = "category_id"
    }
    override fun onItemClick(category: Category) {

        val myIntent = Intent(this, AdoptionInfoActivity::class.java)
        myIntent.putExtra(CATEGORY_ID, category.id)
        startActivity(myIntent)

    }

    var mCategoryList: List<Category>? = null
    var mCategoryPresenter: CategoriesPresenter? = null

    override fun onSuccess(categoryList: List<Category>) {
            mCategoryList = categoryList
            mAdapter!!.setList(mCategoryList!!)

    }


    override fun onFail(message: String) {
        toast(message)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)
        mSectionId = intent.getIntExtra(MainActivity.SECTION_ID, -1)
        init()
    }

    fun init(){
        initToolbar()
        val app = this.applicationContext as ApplicationClass
        mCategoryPresenter = CategoriesPresenter(app.service!!, this, this)
        mCategoryPresenter!!.loadCategories(mSectionId!!)
        initRecyclerView()
    }

    fun initRecyclerView(){
        mAdapter = CategoryAdapter(ArrayList(), this)
        rvCategoryList.adapter = mAdapter
        rvCategoryList.layoutManager = LinearLayoutManager(this)
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

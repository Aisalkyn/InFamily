package com.example.nestana.infamily.ui.articles

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import com.example.nestana.infamily.R
import com.example.nestana.infamily.model.Article
import com.example.nestana.infamily.ui.articles.adapter.ArticleAdapter
import com.example.nestana.infamily.ui.articles_detailed.ArticleDetailedActivity
import com.example.nestana.infamily.ui.categories.CategoriesActivity
import com.example.nestana.infamily.utils.ApplicationClass
import kotlinx.android.synthetic.main.activity_articles.*
import org.jetbrains.anko.toast

class ArticlesActivity : AppCompatActivity(), ArticlesContract.View, ArticleAdapter.OnItemClickListener {

    companion object {
        val PARCED_OBJECT = "parced_object"
    }

    var mArticleList: List<Article>? = null
    var mPresenter: ArticlesPresenter? = null
    var mCategoryId: Int? = null
    var mAdapter: ArticleAdapter? = null

    override fun onSuccess(articleList: List<Article>) {
        mArticleList = articleList
        mAdapter!!.setList(mArticleList!!)

    }

    override fun onFail(message: String) {
        toast(message)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articles)
        mCategoryId = intent.getIntExtra(CategoriesActivity.CATEGORY_ID, -1)
        init()
    }


    fun init() {
        initToolbar()
        val app = this.applicationContext as ApplicationClass
        mPresenter = ArticlesPresenter(app.service!!, this, this)
        mPresenter!!.loadArticles(mCategoryId!!)
        initRecyclerView()
    }

    fun initRecyclerView() {
        mAdapter = ArticleAdapter(ArrayList(), this)
        rvArticleList.adapter = mAdapter
        rvArticleList.layoutManager = LinearLayoutManager(this)
    }

    override fun onItemClick(article: Article) {
        val myIntent = Intent(this, ArticleDetailedActivity::class.java)
        myIntent.putExtra(PARCED_OBJECT, article)
        startActivity(myIntent)
    }

    fun initToolbar() {
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item!!.itemId
        if (id == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

}

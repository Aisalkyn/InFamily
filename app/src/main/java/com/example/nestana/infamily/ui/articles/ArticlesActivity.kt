package com.example.nestana.infamily.ui.articles

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.nestana.infamily.R
import com.example.nestana.infamily.model.Article
import com.example.nestana.infamily.ui.articles.adapter.ArticleAdapter
import com.example.nestana.infamily.ui.categories.CategoriesActivity
import com.example.nestana.infamily.utils.ApplicationClass
import kotlinx.android.synthetic.main.activity_articles.*
import org.jetbrains.anko.toast

class ArticlesActivity : AppCompatActivity(), ArticlesContract.View, ArticleAdapter.OnItemClickListener {
    override fun onItemClick(article: Article) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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


}

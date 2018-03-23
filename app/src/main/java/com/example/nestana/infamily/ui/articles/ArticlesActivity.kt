package com.example.nestana.infamily.ui.articles

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.nestana.infamily.R
import com.example.nestana.infamily.model.Article
import com.example.nestana.infamily.utils.ApplicationClass

class ArticlesActivity : AppCompatActivity(), ArticlesContract.View {

    var mArticleList: List<Article>? = null
    var mPresenter: ArticlesPresenter? = null


    override fun onSuccess(articleList: List<Article>) {
        mArticleList = articleList

    }

    override fun onFail(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articles)
    }



    fun init(){
        val app = this.applicationContext as ApplicationClass

    }

    fun initRecyclerView(){

    }


}

package com.example.nestana.infamily.ui.articles_detailed

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.example.nestana.infamily.R
import com.example.nestana.infamily.model.Article
import com.example.nestana.infamily.ui.articles.ArticlesActivity
import kotlinx.android.synthetic.main.activity_article_detailed.*

class ArticleDetailedActivity : AppCompatActivity() {
    var mArticle: Article? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_detailed)

        mArticle = intent.getParcelableExtra(ArticlesActivity.PARCED_OBJECT)
        init()
    }



    fun init(){
        initToolbar()
        Glide.with(this)
                .load(mArticle!!.image)
                .centerCrop()
                .into(ivDetailedArticleImage)
        tvDetailedArticleTitle.text = mArticle!!.title
        tvDetailedArticleContent.text = mArticle!!.content
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

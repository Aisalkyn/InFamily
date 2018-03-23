package com.example.nestana.infamily.ui.articles

import com.example.nestana.infamily.model.Article

/**
 * Created by admin on 24.03.2018.
 */
interface ArticlesContract{
    interface View{
        fun onSuccess(articleList: List<Article>)
        fun onFail(message: String)
    }
    interface Presenter{
        fun loadArticles()
    }
}
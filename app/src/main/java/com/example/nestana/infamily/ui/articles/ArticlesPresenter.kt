package com.example.nestana.infamily.ui.articles

import android.content.Context
import com.example.nestana.infamily.model.Article
import com.example.nestana.infamily.utils.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
/**
 * Created by admin on 24.03.2018.
 */
class ArticlesPresenter(var mService: ApiService, var mContext: Context, var mView: ArticlesContract.View): ArticlesContract.Presenter{
    override fun loadArticles(categoryId: Int) {
        mService.getArticlesByCategoryId(categoryId).enqueue(object : Callback<List<Article>>{
            override fun onFailure(call: Call<List<Article>>?, t: Throwable?) {
                mView.onFail(t!!.message!!)
                t.printStackTrace()
            }

            override fun onResponse(call: Call<List<Article>>?, response: Response<List<Article>>?) {
                if (response!!.isSuccessful){
                    mView.onSuccess(response.body()!!)
                }else{
                    mView.onFail(response.message())
                }
            }
        })
    }
}
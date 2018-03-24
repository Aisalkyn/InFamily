package com.example.nestana.infamily.ui.categories

import android.content.Context
import com.example.nestana.infamily.model.Category
import com.example.nestana.infamily.utils.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoriesPresenter(val mService: ApiService, val context: Context, val mView: CategoriesContract.View) : CategoriesContract.Presenter {



    override fun loadCategories(id: Int) {
        mService.getCategoriesBySectionId(id).enqueue(object : Callback<List<Category>> {
            override fun onFailure(call: Call<List<Category>>?, t: Throwable?) {
                mView.onFail(t!!.message!!)
                t.printStackTrace()
            }

            override fun onResponse(call: Call<List<Category>>?, response: Response<List<Category>>?) {
                if (response!!.isSuccessful) {
                    mView.onSuccess(response.body()!!)
                } else {
                    mView.onFail(response.message())
                }
            }
        })
    }


}
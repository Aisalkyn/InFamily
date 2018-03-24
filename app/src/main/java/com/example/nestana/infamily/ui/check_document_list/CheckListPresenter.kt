package com.example.nestana.infamily.ui.check_document_list

import android.content.Context
import com.example.nestana.infamily.model.Document
import com.example.nestana.infamily.utils.ApiService

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by admin on 24.03.2018.
 */
class CheckListPresenter(var mService: ApiService, var mContext: Context, var mView: CheckListContract.View) : CheckListContract.Presenter {


    override fun loadDocuments() {
        mService.getDocuments().enqueue(object : Callback<List<Document>> {
            override fun onFailure(call: Call<List<Document>>?, t: Throwable?) {
                mView.onFail(t!!.message!!)
            }

            override fun onResponse(call: Call<List<Document>>?, response: Response<List<Document>>?) {
                if (response!!.isSuccessful) {
                    mView.onSuccess(response.body())
                } else {
                    mView.onFail(response.message())
                }
            }
        })
    }

}
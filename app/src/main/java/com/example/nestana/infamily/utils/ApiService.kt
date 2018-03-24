package com.example.nestana.infamily.utils
import com.example.nestana.infamily.model.Article
import com.example.nestana.infamily.model.Category
import com.example.nestana.infamily.model.Document
import retrofit2.Call
import retrofit2.http.*


/**
 * Created by admin on 28.02.2018.
 */
interface ApiService {

    @GET("section/{sectionId}/")
    fun getCategoriesBySectionId(@Path("sectionId") sectionId: Int): Call<List<Category>>

    @GET("category/{categoryId}/")
    fun getArticlesByCategoryId(@Path("categoryId") categoryId: Int): Call<List<Article>>

    @GET("documents/")
    fun getDocuments(): Call<List<Document>>


}
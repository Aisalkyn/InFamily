package com.example.nestana.infamily.ui.categories

import com.example.nestana.infamily.model.Category

/**
 * Created by admin on 24.03.2018.
 */
interface CategoriesContract {
    interface View {
        fun onSuccess(categoryList: List<Category>)
        fun onFail(message: String)
    }

    interface Presenter {
        fun loadCategories(id: Int)
    }
}
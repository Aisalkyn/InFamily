package com.example.nestana.infamily.ui.check_document_list

/**
 * Created by admin on 24.03.2018.
 */
interface CheckListContract{
    interface View{
        fun onSuccess(documentList: List<com.example.nestana.infamily.model.Document>?)
        fun onFail(message: String)
    }

    interface Presenter{
        fun loadDocuments()
    }
}